package com.konduto.sdk.models;

import com.google.gson.JsonObject;
import com.konduto.sdk.exceptions.KondutoInvalidEntityException;
import com.konduto.sdk.factories.KondutoTenantFactory;
import com.konduto.sdk.utils.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KondutoTenantTest {

    @Test
    public void serializationTest(){
        KondutoTenant tenant = KondutoTenantFactory.getKondutoTenant();
        JsonObject tenantJSON = (JsonObject) TestUtils.readJSONFromFile("tenant.json");
        try {
            assertEquals("serialization failed", tenantJSON, tenant.toJSON());
        } catch (KondutoInvalidEntityException e) {
            e.printStackTrace();
        }

        KondutoTenant deserializedTenant = (KondutoTenant)
                KondutoModel.fromJSON(tenantJSON, KondutoTenant.class);

        assertEquals("deserialization failed", tenant, deserializedTenant);

    }

    @Test(expected=KondutoInvalidEntityException.class)
    public void invalidCustomerSerializationThrowsExceptionTest() throws KondutoInvalidEntityException {
        KondutoTenant tenant = new KondutoTenant();
        tenant.toJSON(); // triggers invalid tenant exception
    }
}
