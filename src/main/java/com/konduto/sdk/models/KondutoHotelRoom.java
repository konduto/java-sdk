package com.konduto.sdk.models;

import com.google.gson.annotations.SerializedName;
import com.google.gson.JsonParseException;
import com.konduto.sdk.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * Hotel Room model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 *
 */
public class KondutoHotelRoom extends KondutoModel {

	private String number;
	private String code;
	private String type;

	@SerializedName("check_in_date")
	private String checkinDate; // format: yyyy-MM-ddT2018-12-25T18:00Z

	@SerializedName("check_out_date")
	private String checkoutDate; // format: yyyy-MM-ddT2018-12-25T18:00Z

	@SerializedName("number_of_guests")
	private int numberOfGuests;

	@SerializedName("board_basis")
	private String boardBasis;

	private Collection<KondutoGuest> guests;

	/**
	 * Default constructor.
	 */
	public KondutoHotelRoom(){}

	/* Equals */
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;

		KondutoHotelRoom that = (KondutoHotelRoom) object;

		if (numberOfGuests != that.numberOfGuests) return false;
		if (number != null ? !number.equals(that.number) : that.number != null) return false;
		if (code != null ? !code.equals(that.code) : that.code != null) return false;
		if (type != null ? !type.equals(that.type) : that.type != null) return false;
		if (checkinDate != null ? !checkinDate.equals(that.checkinDate) : that.checkinDate != null) return false;
		if (checkoutDate != null ? !checkoutDate.equals(that.checkoutDate) : that.checkoutDate != null) return false;
		if (boardBasis != null ? !boardBasis.equals(that.boardBasis) : that.boardBasis != null) return false;
		if (guests != null ? !guests.equals(that.guests) : that.guests != null) return false;

		return true;
	}

	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (number != null ? number.hashCode() : 0);
		result = 31 * result + (code != null ? code.hashCode() : 0);
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (checkinDate != null ? checkinDate.hashCode() : 0);
		result = 31 * result + (checkoutDate != null ? checkoutDate.hashCode() : 0);
		result = 31 * result + numberOfGuests;
		result = 31 * result + (boardBasis != null ? boardBasis.hashCode() : 0);
		result = 31 * result + (guests != null ? guests.hashCode() : 0);
		return result;
	}

	Date deserializeDate(String date) throws JsonParseException {
		try {
			return new SimpleDateFormat(DateFormat.DATE.getFormat(),
					Locale.US).parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new JsonParseException("Unparseable date: \"" + date
					+ "\". Supported format: " + DateFormat.DATE.getFormat());
		}
	}

	String serializeDate(Date src) {
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormat.DATE.getFormat());
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return  sdf.format(src).replace("+0000", "Z");
	}

	/* Getters and Setters */
	/**
	 * Gets the number.
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Sets the number.
	 * @param number the number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Gets the code.
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 * @param code the code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the type.
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 * @param type the type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the checkin date.
	 * @return the checkin date
	 */
	public Date getCheckinDate() {
		return deserializeDate(checkinDate);
	}

	/**
	 * Sets the checkin date.
	 * @param checkinDate the checkin date
	 */
	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = serializeDate(checkinDate);
	}

	/**
	 * Gets the checkout date.
	 * @return the checkout date
	 */
	public Date getCheckoutDate() {
		return deserializeDate(checkoutDate);
	}

	/**
	 * Sets the checkout date.
	 * @param checkoutDate the checkout date
	 */
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = serializeDate(checkoutDate);
	}

	/**
	 * Gets the number of guests.
	 * @return the number of guests
	 */
	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	/**
	 * Sets the number of guests.
	 * @param numberOfGuests the number of guests
	 */
	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	/**
	 * Gets the board basis.
	 * @return the board basis
	 */
	public String getBoardBasis() {
		return boardBasis;
	}

	/**
	 * Sets the board basis.
	 * @param boardBasis the board basis
	 */
	public void setBoardBasis(String boardBasis) {
		this.boardBasis = boardBasis;
	}

	/**
	 * Gets the guests.
	 * @return the guests
	 */
	public Collection<KondutoGuest> getGuests() {
		return guests;
	}

	/**
	 * Sets the guests.
	 * @param guests the guests
	 */
	public void setGuests(Collection<KondutoGuest> guests) {
		this.guests = guests;
	}
}