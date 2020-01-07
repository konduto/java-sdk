package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoBureauQuery;
import com.konduto.sdk.models.KondutoBureauResponseField;
import com.konduto.sdk.models.KondutoBureauService;

import java.util.*;

public class KondutoBureauQueryFactory {

    public static Collection<KondutoBureauQuery> getQueries() {
        Set<KondutoBureauQuery> querySet = new HashSet<KondutoBureauQuery>();
        querySet.add(getQuery());
        return querySet;
    }

    public static KondutoBureauQuery getQuery() {
        KondutoBureauQuery query = new KondutoBureauQuery();
        query.setService(KondutoBureauService.EMAIL_AGE);
        query.setAttribute(KondutoBureauResponseField.ADVICE, "Lower " +
                "Fraud Risk");
        query.setAttribute(KondutoBureauResponseField.EMAIL_DOMAIN_EXISTS,
                true);
        return query;
    }
}
