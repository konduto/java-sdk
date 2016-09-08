package com.konduto.sdk.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.konduto.sdk.adapters.*;
import com.konduto.sdk.annotations.Required;
import com.konduto.sdk.annotations.ValidateFormat;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;

/**
 *
 * This is the parent of all models.
 *
 */
public abstract class KondutoModel {
	protected KondutoModel(){ }

	@Override
	public abstract boolean equals(Object obj);

	/* Transient and static attributes won't be included in serialization */
	private static Type paymentCollectionType = new TypeToken<Collection<KondutoPayment>>(){}.getType();
	private static Type travelType = new TypeToken<KondutoTravel>(){}.getType();
    private static Type busTravelLegType = new TypeToken<KondutoBusTravelLeg>(){}.getType();
    private static Type flightTravelLegType = new TypeToken<KondutoFlightTravelLeg>(){}.getType();


	protected static Gson gson = new GsonBuilder()
			.registerTypeAdapter(paymentCollectionType, new KondutoPaymentCollectionDeserializer())
			.registerTypeHierarchyAdapter(KondutoPayment.class, new KondutoPaymentSerializer())
			.registerTypeAdapter(travelType, new KondutoTravelAdapter())
            .registerTypeAdapter(busTravelLegType, new KondutoBusTravelLegAdapter())
            .registerTypeAdapter(flightTravelLegType, new KondutoFlightTravelLegAdapter())
			.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setDateFormat("yyyy-MM-dd")
			.create();

	protected transient List<String> errors = new ArrayList<String>();

	/* Serialization methods */

	/**
	 * Serializes a model instance to JSON.
	 * @return a {@link com.google.gson.JsonObject}
	 * @throws KondutoInvalidEntityException
	 */
	public JsonObject toJSON() throws KondutoInvalidEntityException{
		if(!this.isValid()) { throw new KondutoInvalidEntityException(this); }
		return (JsonObject) gson.toJsonTree(this);
	}

	/**
	 * Converts a {@link com.google.gson.JsonObject} to a model instance.
	 * @param json the serialized instance
	 * @param klass the instance class
	 * @return an instance of KondutoModel (e.g a KondutoAddress if klass is {@code KondutoAddress.class})
	 */
	public static KondutoModel fromJSON(JsonObject json, Class<?> klass){
		return (KondutoModel) gson.fromJson(json, klass);
	}

	/* Error printing methods */

	/**
	 * @return {@link com.konduto.sdk.models.KondutoModel#errors errors} pretty printed.
	 */
	public String getErrors(){
		StringBuilder errors = new StringBuilder();
		for(String error : this.errors) {
			errors.append("\n");
			errors.append(error);
		}
		return this.getClass().getSimpleName() + errors.toString();
	}

	/**
	 * Adds a 'is required' message to {@link com.konduto.sdk.models.KondutoModel#errors errors}
	 *
	 * @param field the incorrect field
	 * @param value the incorrect field value
	 */
	void addIsRequiredError(Field field, Object value) {
		if(value != null) {
			this.errors.add("" +
					"\t" +
					field.getName() + " of class " +
					value.getClass().getSimpleName() +
					" is required but came " +
					'\'' + value + '\'');
		} else {
			this.errors.add("\t" + field.getName() + " is required but came null");
		}

	}

	/**
	 * Validates whether a string field's value matches a given regex.
	 * If it doesn't then add an error to the errors collection.
	 * @param field the field
	 * @param value the value
	 * @param format the format (a Java regex)
	 */
    private void addInvalidFormatError(Field field, Object value, String format) {
        this.errors.add("" +
                "\t" +
                field.getName() + " value is " + value + " which format does not match " + '\'' + format + '\'');
    }

	/**
	 *
	 * @param errors a String containing a
	 * {@link com.konduto.sdk.models.KondutoModel#errors KondutoModel instance errors}
	 */
	void addIsInvalidError(String errors) {
		this.errors.add(errors);
	}

	/**
	 * @return whether this KondutoModel instance is valid or not.
	 */
	/* Validation method */
	public boolean isValid() {
		errors.clear();
		Object value;

		for(Field f : getAllFields(new LinkedList<Field>(), this.getClass())) {
			if (!f.isSynthetic()) {
				try {
					f.setAccessible(true);
					value = f.get(this);

					// validates requirement
					if(f.isAnnotationPresent(Required.class)){
						if(value == null) {
							addIsRequiredError(f, null);
						} else {
							Method isEmptyMethod = value.getClass().getMethod("isEmpty");
							boolean isEmpty = (Boolean) isEmptyMethod.invoke(value);
							if(isEmpty) {
								addIsRequiredError(f, value);
							}
						}
					}

                    if(f.isAnnotationPresent(ValidateFormat.class)){
                        String format = f.getAnnotation(ValidateFormat.class).format();
                        if (value != null) {
                            boolean match = ((String) value).matches(format);
                            if(!match) {
                                addInvalidFormatError(f, value, format);
                            }
                        }
                    }

					// if the field is a KondutoModel, check if it is valid
					if (value instanceof KondutoModel) {
						if(!((KondutoModel) value).isValid()) {
							addIsInvalidError(((KondutoModel) value).getErrors());
						}
					}
				} catch (NoSuchMethodException e) {
					// no problem if method does not exist;
				} catch (IllegalAccessException e) {
					throw new RuntimeException("Illegal access to a required field should never happen.");
				} catch (InvocationTargetException e) {
					throw new RuntimeException();
				}
			}
		}

		return errors.isEmpty();

	}

	public static List<Field> getAllFields(List<Field> fields, Class<?> type) {
		fields.addAll(Arrays.asList(type.getDeclaredFields()));

		if (type.getSuperclass() != null) {
			fields = getAllFields(fields, type.getSuperclass());
		}

		return fields;
	}

    /**
	 * Enables Map-based construction in KondutoModel children.
	 *
	 * @param attributes a {@link HashMap} containing attributes. For a field 'totalAmount' with type Long, we should
	 *                   add the following entry to the map: 'totalAmount', 123L.
	 */
	public static KondutoModel fromMap(Map<String,Object> attributes, Class<?> klass){

		KondutoModel model;

		try {
			model = (KondutoModel) klass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new RuntimeException("could not instantiate an object of " + klass);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("constructor is not accessible in " + klass);
		}



		for(Map.Entry<String, Object> attribute : attributes.entrySet()) {

			String attributeName = attribute.getKey();

			try {
				Field field = klass.getDeclaredField(attributeName);

				Object value = attribute.getValue();

				if(!relatedClasses(field.getType(), value.getClass())){
					throw new IllegalArgumentException(String.format(
							"Illegal value for attribute %s. Expected a value of class %s, but got a value of class %s",
							field.getName(),
							field.getType(),
							value.getClass()
					));
				}

				field.setAccessible(true);

				field.set(model, value);

			} catch (NoSuchFieldException e) {
				throw new IllegalArgumentException(String.format("Attribute %s was not found.", attributeName));
			} catch (IllegalAccessException e) {
				throw new RuntimeException("if field was found it should be accessible (via field.setAccessible(true))");
			}
		}

		return model;

	}

	/**
	 * Classes are related iff class1 is the same as class2 or if one of them is a wrapper for the other one
	 * (e.g class1 is int.class and class2 is Integer.class)
	 * @param class1 a class
	 * @param class2 another class
	 * @return whether class1 and class2 are related
	 */
	private static boolean relatedClasses(Class<?> class1, Class<?> class2) {
		if(class1.equals(class2)) return true;
		if(isWrapped(class1, class2)) return true;
		if(isWrapped(class2, class1)) return true;
		return false;
	}

	/**
	 * Checks whether class1 is wrapped by class2.
	 * @param class1 supposedly wrapped class.
	 * @param class2 supposedly wrapper class.
	 * @return true if class1 is wrapped by class2 or false otherwise.
	 */
	private static boolean isWrapped(Class<?> class1, Class<?> class2) {
		if(class1.equals(boolean.class) && class2.equals(Boolean.class)) return true;
		if(class1.equals(byte.class) && class2.equals(Byte.class)) return true;
		if(class1.equals(short.class) && class2.equals(Short.class)) return true;
		if(class1.equals(char.class) && class2.equals(Character.class)) return true;
		if(class1.equals(int.class) && class2.equals(Integer.class)) return true;
		if(class1.equals(long.class) && class2.equals(Long.class)) return true;
		if(class1.equals(float.class) && class2.equals(Float.class)) return true;
		if(class1.equals(double.class) && class2.equals(Double.class)) return true;
		return false;
	}

	/**
	 * Fluent constructor implementation
	 * @param attributeName the attribute name (e.g greeting)
	 * @param attributeValue the attribute value (e.g "Hello")
	 * @return a new instance
	 *
	 * @see <a href=http://en.wikipedia.org/wiki/Fluent_interface>Fluent interface article</a>
	 */
	public KondutoModel with(String attributeName, Object attributeValue){
		try {
			Field field = this.getClass().getDeclaredField(attributeName);
			field.setAccessible(true);
			field.set(this, attributeValue);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException("field " + attributeName + " was not found.");
		} catch (IllegalAccessException e) {
			throw new RuntimeException("field " + attributeName + "was found. Therefore it should be accessible.");
		}
		return this;
	}

	protected boolean nullSafeAreDatesEqual(Date one, Date two){
		return (one == null && two == null) ||
				((one != null && two != null) && one.compareTo(two) == 0);

	}
}
