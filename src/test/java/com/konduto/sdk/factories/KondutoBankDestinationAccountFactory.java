package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoBankDestinationAccount;
import com.konduto.sdk.models.KondutoBankDocumentType;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by igor.rodrigues (nickname: igor.francesco) 10/06/2022.
 */
public class KondutoBankDestinationAccountFactory {

    public static Collection<KondutoBankDestinationAccount> getDestinationAccounts() {
        return Arrays.asList(getSenderAccount(), getReceiverAccount());
    }

    //sender and receiver
    public static KondutoBankDestinationAccount getSenderAccount() {
        KondutoBankDestinationAccount sender = new KondutoBankDestinationAccount();
        sender.setId("Conta 003");
        sender.setKeyType(KondutoBankDocumentType.PIX_EVP);
        sender.setKeyValue("123e4567-e89b-12d3-a456-426655440000");
        sender.setBankCode("17298092");
        sender.setBankName("Itaú BBA");
        sender.setBankBranch("0001");
        sender.setBankAccount("01234-5");
        sender.setHolderName("Igor Francesco");
        sender.setHolderTaxId("123.456.789-09");
        sender.setAmount(200.0);
        return sender;
    }

    public static KondutoBankDestinationAccount getReceiverAccount() {
        KondutoBankDestinationAccount receiver = new KondutoBankDestinationAccount();
        receiver.setId("Conta 007");
        receiver.setKeyType(KondutoBankDocumentType.PIX_PHONE);
        receiver.setKeyValue("(11) 911112222");
        receiver.setBankCode("60872504");
        receiver.setBankName("Banco Itaú");
        receiver.setBankBranch("0001");
        receiver.setBankAccount("12345-6");
        receiver.setHolderName("Ana Luna");
        receiver.setHolderTaxId("046.123.123-13");
        receiver.setAmount(500.0);
        return receiver;
    }
}
