package com.konduto.sdk.models;

import java.util.Date;

/**
 * Item model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 */
public class KondutoItem extends KondutoModel {
	private String sku;
	private Integer category;
	private String name;
	private String description;
	private String productCode;
	private Double unitCost;
	private Double quantity;
	private Double discount;
	private Date created_at;

	/* Constructors */

	public KondutoItem(){}

	/**
	 * Fluent constructor
	 * @param attributeName the attribute name (e.g totalAmount)
	 * @param attributeValue the attribute value (e.g 123.2)
	 * @return a new instance
	 */
	@Override
	public KondutoItem with(String attributeName, Object attributeValue) {
		return (KondutoItem) super.with(attributeName, attributeValue);
	}


	/* Equals */

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof KondutoItem)) return false;

		KondutoItem that = (KondutoItem) o;

		if (category != null ? !category.equals(that.category) : that.category != null) return false;
		if (description != null ? !description.equals(that.description) : that.description != null) return false;
		if (discount != null ? !discount.equals(that.discount) : that.discount != null) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
		if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
		if (sku != null ? !sku.equals(that.sku) : that.sku != null) return false;
		if (unitCost != null ? !unitCost.equals(that.unitCost) : that.unitCost != null) return false;
		if (!nullSafeAreDatesEqual(created_at, that.created_at)){
			return false;
		}
		return true;
	}

	/* Getters and Setters */

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Date getCreated_at() { return created_at; }

	public void setCreated_at(Date created_at) { this.created_at = created_at; }
}
