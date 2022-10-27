package com.konduto.sdk.models;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/**
 *
 * Payment type enum.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public enum KondutoPaymentType {
	@SerializedName("credit")
	CREDIT {
		@Override
		protected Class<? extends KondutoPayment> getKlass() {
			return KondutoCreditCardPayment.class;
		}
	},
	BOLETO {
		@Override
		protected Class<? extends KondutoPayment> getKlass() {
			return KondutoBoletoPayment.class;
		}

		@Override
		public KondutoPayment deserialize(JsonObject je,
										  JsonDeserializationContext context) {
			KondutoBoletoPayment pmt = new KondutoBoletoPayment();
			String expirationDateAsStr = je.get("expiration_date").getAsString();
			pmt.setExpirationDate(expirationDateAsStr);
			return pmt;
		}
	},
	TRANSFER {
		@Override
		protected Class<? extends KondutoPayment> getKlass() {
			return KondutoTransferPayment.class;
		}
	},
	VOUCHER {
		@Override
		protected Class<? extends KondutoPayment> getKlass() {
			return KondutoVoucherPayment.class;
		}
	},
	DEBIT {
		@Override
		protected Class<? extends KondutoPayment> getKlass() {
			return KondutoDebitPayment.class;
		}
	},
	TED {
		@Override
		protected Class<? extends KondutoPayment> getKlass() {
			return KondutoTEDPayment.class;
		}
	};

	protected abstract Class<? extends KondutoPayment> getKlass();

	/**
	 * Deserialize a JSON to a KondutoPayment of given type
	 * @param je the JSON Object
	 * @param context the deserialization context
	 * @return a KondutoPayment instance
	 */
	public KondutoPayment deserialize(JsonObject je,
									  JsonDeserializationContext context) {
		return context.deserialize(je, getKlass());
	}
}
