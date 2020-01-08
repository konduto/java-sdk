package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoBureauQuery;

import java.util.*;

public class KondutoBureauQueryFactory {

    public static Collection<KondutoBureauQuery> getQueries() {
        Set<KondutoBureauQuery> querySet = new HashSet<KondutoBureauQuery>();
        querySet.add(getQuery());
        return querySet;
    }

    public static KondutoBureauQuery getQuery() {
        KondutoBureauQuery query = new KondutoBureauQuery();
        query.setService("emailage");
        query.setAttribute("advice", "Lower Fraud Risk");
        query.setAttribute("email_domain_exists", true);
        return query;
    }
}
