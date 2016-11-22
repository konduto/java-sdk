package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 *
 * Device model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 *
 */
public class KondutoOption extends KondutoModel {

	@SerializedName("real_time")
	private boolean realTime;

	@SerializedName("sales_channel")
	private KondutoSalesChannel salesChannel;

	public KondutoOption(){}

	/* Equals */

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof KondutoOption)) return false;

		KondutoOption that = (KondutoOption) o;

		if (realTime != that.realTime) return false;
		if (salesChannel != that.salesChannel) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	/* Getters and Setters */
	public boolean getRealTime() {
		return realTime;
	}

	public void setRealTime(boolean realTime) {
		this.realTime = realTime;
	}

	public KondutoSalesChannel getSalesChannel() {
		return salesChannel;
	}

	public void setSalesChannel(KondutoSalesChannel salesChannel) {
		this.salesChannel = salesChannel;
	}
}