package com.qa.ims.persistence.domain;

//import java.util.ArrayList;
//import java.util.List;

public class Orders {
	private Long orderId;
	private Long custId;


	public Orders(Long orderId, Long custId) {
		this.setOrderId(orderId);
		this.setCustomerId(custId);

	}

	public Orders(Long custId) {
		super();
		this.custId = custId;
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


	@Override
	public String toString() {
		return "order_id: " + orderId + " Customer id: " + custId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
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

		return true;
	}



}

	
