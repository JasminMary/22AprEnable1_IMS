package com.qa.ims.persistence.domain;

//import java.util.ArrayList;
//import java.util.List;

public class Orders {
	private Long orderId;
	private Long custId;
	private Long itemId;
	private Integer amount;
	private Double totalPrice;
	private String itemName;
	private String custName;

	public Orders(Long orderId, Long itemId, Integer amount, Double totalPrice, String custName, String itemName) {
		this.setOrderId(orderId);
		this.setItemId(itemId);
		this.setQty(amount);
		this.setTotalPrice(totalPrice);
		this.setCustName(custName);
		this.setItemName(itemName);
	}
	public Orders(Long orderId, Long custId, Long itemId, Integer amount) {
		this.setOrderId(orderId);
		this.setCustomerId(custId);
		this.setItemId(itemId);
		this.setQty(amount);
	}

	
	public Orders(Long custId, Long itemId, Integer amount) {
		this.setCustomerId(custId);
		this.setItemId(itemId);
		this.setQty(amount);
	}
	

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	public Long getCustomerId() {
		return custId;
	}

	public void setCustomerId(Long custId) {
		this.custId = custId;
	}
	
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Integer getAmount() {
		return amount;
	}
	
	public void setQty(Integer amount) {
		this.amount = amount;
	}


	
	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "id: " + orderId + " first name: " + custName + " item: " + itemName + " Quantity: " + amount + " Total Price: " + totalPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (getItemName() == null) {
			if (other.getItemName() != null)
				return false;
		} else if (!getItemName().equals(other.getItemName()))
			return false;
		if (getOrderId() == null) {
			if (other.getOrderId() != null)
				return false;
		} else if (!getOrderId().equals(other.getOrderId()))
			return false;
		if (getCustomerId() == null) {
			if (other.getCustomerId() != null)
				return false;
		} else if (!getCustomerId().equals(other.getCustomerId()))
			return false;
		if (getItemId() == null) {
			if (other.getItemId() != null)
				return false;
		} else if (!getItemId().equals(other.getItemId()))
			return false;
		if (getTotalPrice() == null) {
			if (other.getTotalPrice() != null)
				return false;
		if (getAmount() == null) {
			if (other.getAmount() != null)
				return false;
		} else if (!getAmount().equals(other.getAmount()))
			return false;
		} else if (!getTotalPrice().equals(other.getTotalPrice()))
			return false;
		if (getCustName() == null) {
			if (other.getCustName() != null)
				return false;
		} else if (!getCustName().equals(other.getCustName()))
			return false;
		return true;
	}



}

	
