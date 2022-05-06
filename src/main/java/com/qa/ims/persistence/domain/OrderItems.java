package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItems {

	private Long orderItemId;
	private Long orderId;
	private Long itemId;
	private Long quantity;
	private Double totalPrice;
	
	
	
	public OrderItems(Long orderItemId, Long orderId, Long itemId, Long quantity, Double price) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.totalPrice = price;
	}
	
	public OrderItems(Long orderId, Long itemId, Long quantity) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
	}
	
	public OrderItems(Long orderItemId, Long orderId, Long itemId, Long quantity) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setPrice(Double price) {
		this.totalPrice = price;
	}

	@Override
	public String toString() {
		return "orderItemId=" + orderItemId + ", orderId=" + orderId + ", itemId=" + itemId + ", quantity="
				+ quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, orderId, orderItemId, totalPrice, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItems other = (OrderItems) obj;
		return Objects.equals(itemId, other.itemId) && Objects.equals(orderId, other.orderId)
				&& Objects.equals(orderItemId, other.orderItemId) && Objects.equals(totalPrice, other.totalPrice)
				&& Objects.equals(quantity, other.quantity);
	}
	
	
	
	
	
}
