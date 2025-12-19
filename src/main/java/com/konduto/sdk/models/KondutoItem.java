package com.konduto.sdk.models;

import java.util.Date;

/**
 * Item model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoItem extends KondutoModel {
	private String sku;
	private Integer category;
	private String name;
	private String description;
	private String productCode;
	private Double unitCost;
	private Double quantity;
	private Double discount;
	private Date created_at;

	/* Constructors */

	/**
	 * Default constructor.
	 */
	public KondutoItem(){}

	/**
	 * Fluent constructor
	 * @param attributeName the attribute name (e.g totalAmount)
	 * @param attributeValue the attribute value (e.g 123.2)
	 * @return a new instance
	 */
	@Override
	public KondutoItem with(String attributeName, Object attributeValue) {
		return (KondutoItem) super.with(attributeName, attributeValue);
	}


	/* Equals */

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof KondutoItem)) return false;

		KondutoItem that = (KondutoItem) o;

		if (category != null ? !category.equals(that.category) : that.category != null) return false;
		if (description != null ? !description.equals(that.description) : that.description != null) return false;
		if (discount != null ? !discount.equals(that.discount) : that.discount != null) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
		if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
		if (sku != null ? !sku.equals(that.sku) : that.sku != null) return false;
		if (unitCost != null ? !unitCost.equals(that.unitCost) : that.unitCost != null) return false;
		if (!nullSafeAreDatesEqual(created_at, that.created_at)){
			return false;
		}
		return true;
	}

	/* Getters and Setters */

	/**
	 * Gets the sku.
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * Sets the sku.
	 * @param sku the sku
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * Gets the category.
	 * @return the category
	 */
	public Integer getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 * @param category the category
	 */
	public void setCategory(Integer category) {
		this.category = category;
	}

	/**
	 * Gets the name.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the description.
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 * @param description the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the product code.
	 * @return the product code
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * Sets the product code.
	 * @param productCode the product code
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * Gets the unit cost.
	 * @return the unit cost
	 */
	public Double getUnitCost() {
		return unitCost;
	}

	/**
	 * Sets the unit cost.
	 * @param unitCost the unit cost
	 */
	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}

	/**
	 * Gets the quantity.
	 * @return the quantity
	 */
	public Double getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 * @param quantity the quantity
	 */
	/**
	 * Sets the quantity.
	 * @param quantity the quantity
	 */
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the discount.
	 * @return the discount
	 */
	public Double getDiscount() {
		return discount;
	}

	/**
	 * Sets the discount.
	 * @param discount the discount
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	/**
	 * Gets the created at.
	 * @return the created at
	 */
	public Date getCreated_at() { return created_at; }

	/**
	 * Sets the created at.
	 * @param created_at the created at
	 */
	public void setCreated_at(Date created_at) { this.created_at = created_at; }
}
