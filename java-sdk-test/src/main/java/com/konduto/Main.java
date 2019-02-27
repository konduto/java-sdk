package com.konduto;

import com.konduto.sdk.Konduto;
import com.konduto.sdk.exceptions.KondutoHTTPException;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.exceptions.KondutoUnexpectedAPIResponseException;
import com.konduto.sdk.models.KondutoCustomer;
import com.konduto.sdk.models.KondutoOrder;
import com.konduto.sdk.models.KondutoOrderStatus;

public class Main {

    private static final String ORDER_ID = "order_test_2_10_2";

    public static void main(String[] args) {
        Konduto konduto = new Konduto("TF284100286E2838BF754");
        KondutoCustomer kondutoCustomer = new KondutoCustomer();
        kondutoCustomer.setEmail("raphael@konduto.com");
        kondutoCustomer.setId("123");
        kondutoCustomer.setName("Raphael Sampaio");
        kondutoCustomer.setTaxId("22008607810");
        KondutoOrder kondutoOrder = new KondutoOrder();
        kondutoOrder.setId(ORDER_ID);
        kondutoOrder.setCustomer(kondutoCustomer);
        kondutoOrder.setTotalAmount(123.4);
        kondutoOrder.setVisitor("abcd1234");
        try {
            konduto.analyze(kondutoOrder);
        } catch (KondutoInvalidEntityException e) {
            e.printStackTrace();
        } catch (KondutoHTTPException e) {
            e.printStackTrace();
        } catch (KondutoUnexpectedAPIResponseException e) {
            e.printStackTrace();
        }

        assert kondutoOrder.getStatus() != null;

        KondutoOrder fetchedKondutoOrder = null;

        try {
             fetchedKondutoOrder = konduto.getOrder(ORDER_ID);
        } catch (KondutoHTTPException e) {
            e.printStackTrace();
        } catch (KondutoUnexpectedAPIResponseException e) {
            e.printStackTrace();
        }

        assert fetchedKondutoOrder != null;
        assert fetchedKondutoOrder.getId().equals(kondutoOrder.getId());

        try {
            konduto.updateOrderStatus(kondutoOrder, KondutoOrderStatus.FRAUD, "it's a fraud");
        } catch (KondutoHTTPException e) {
            e.printStackTrace();
        } catch (KondutoUnexpectedAPIResponseException e) {
            e.printStackTrace();
        }

        assert kondutoOrder.getStatus().equals(KondutoOrderStatus.FRAUD);

        System.out.println("Congrats. The SDK works!");

    }
}
