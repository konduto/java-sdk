package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoSellerFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;
import java.text.SimpleDateFormat;

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

        // assertEquals("deserialization failed", seller, deserializedSeller);
        assertEquals("Konduto Seller Id deve ser igual", seller.getId(), deserializedSeller.getId());
        assertEquals("Konduto Seller Name deve ser igual", seller.getName(), deserializedSeller.getName());
        // assertEquals("Konduto Seller CreatedAt deve ser igual", seller.getCreatedAt(), deserializedSeller.getCreatedAt());
        //Remove time na data UnixTimestamp
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Formata data
        String dataOriginal = sdf.format(seller.getCreatedAt());
        String dataDeserializada = sdf.format(deserializedSeller.getCreatedAt());
        //Compara as datas
        assertEquals("A data de criação deve ser igual (YYYY-MM-DD)", dataOriginal, dataDeserializada);

    }

    @Test(expected=KondutoInvalidEntityException.class)
    public void invalidCustomerSerializationThrowsExceptionTest() throws KondutoInvalidEntityException {
        KondutoCustomer customer = new KondutoCustomer();
        customer.toJSON(); // triggers invalid customer exception
    }
}
