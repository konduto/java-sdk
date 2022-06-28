package com.konduto.sdk.factories;

import com.konduto.sdk.models.KondutoAgentSeller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by igor.rodrigues (nickname: igor.francesco) 03/06/2022.
 */
public class KondutoAgentSellerFactory {

	public static KondutoAgentSeller getAgentSeller() throws ParseException {
		KondutoAgentSeller agent = new KondutoAgentSeller();
		agent.setId("1");
		agent.setLogin("igor.rodrigues");
		agent.setName("Igor F Rodrigues");
		agent.setTaxId("012014567890");
		agent.setCategory("");
		agent.setCreated_at(new Date(1433818800000L));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dob = sdf.parse("25/08/1992");
		agent.setDOB(dob);

		return agent;
	}
}
