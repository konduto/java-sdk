package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoBankDocumentType;
import com.konduto.sdk.models.KondutoBankOriginAccount;

import java.text.ParseException;

/**
 *
 * {
 *   "origin_account": {
 *     "id": "ABC123DEF",
 *     "balance": 250.0,
 *     "key_type": "pix_phone",
 *     "key_value": "+5511912341234",
 *     "bank_code": "00000000",
 *     "bank_name": "Banco do Brasil",
 *     "bank_branch": "0001",
 *     "bank_account": "123123",
 *     "holder_name": "Alberto Armando",
 *     "holder_tax_id": "123.456.789-09"
 *   }
 * }
 *
 */
public class KondutoBankOriginAccountFactory {
	public static KondutoBankOriginAccount getOriginAccount() throws ParseException {
		KondutoBankOriginAccount originAccount = new KondutoBankOriginAccount();
		originAccount.setId("ABC123DEF");
		originAccount.setBalance(250.0);
		originAccount.setKeyType(KondutoBankDocumentType.PIX_PHONE);
		originAccount.setKeyValue("+5511912341234");
		originAccount.setBankCode("00000000");
		originAccount.setBankName("Banco do Brasil");
		originAccount.setBankBranch("0001");
		originAccount.setBankAccount("123123");
		originAccount.setHolderName("Alberto Armando");
		originAccount.setHolderTaxId("123.456.789-09");

		return originAccount;
	}
}
