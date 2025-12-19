package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * Represents an option in the Konduto system.
 * This class extends KondutoModel and contains option-specific attributes.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoOption extends KondutoModel {

	@SerializedName("real_time")
	private boolean realTime;

	@SerializedName("sales_channel")
	private KondutoSalesChannel salesChannel;

	/**
	 * Default constructor.
	 */
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
	/**
	 * Gets the real time flag.
	 * @return the real time flag
	 */
	public boolean getRealTime() {
		return realTime;
	}

	/**
	 * Sets the real time flag.
	 * @param realTime the real time flag
	 */
	public void setRealTime(boolean realTime) {
		this.realTime = realTime;
	}

	/**
	 * Gets the sales channel.
	 * @return the sales channel
	 */
	public KondutoSalesChannel getSalesChannel() {
		return salesChannel;
	}

	/**
	 * Sets the sales channel.
	 * @param salesChannel the sales channel
	 */
	public void setSalesChannel(KondutoSalesChannel salesChannel) {
		this.salesChannel = salesChannel;
	}
}