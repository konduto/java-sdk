package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoSellerFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KondutoSellerTest {

    @Test
    public void serializationTest(){
        KondutoSeller seller = KondutoSellerFactory.getKondutoSeller();
        JsonObject sellerJSON = (JsonObject) TestUtils.readJSONFromFile("seller.json");
        try {
            assertEquals("serialization failed", sellerJSON, seller.toJSON());
        } catch (KondutoInvalidEntityException e) {
            e.printStackTrace();
        }

        KondutoSeller deserializedSeller = (KondutoSeller)
                KondutoModel.fromJSON(sellerJSON, KondutoSeller.class);

        assertEquals("deserialization failed", seller, deserializedSeller);

    }

    @Test(expected=KondutoInvalidEntityException.class)
    public void invalidCustomerSerializationThrowsExceptionTest() throws KondutoInvalidEntityException {
        KondutoCustomer customer = new KondutoCustomer();
        customer.toJSON(); // triggers invalid customer exception
    }
}
