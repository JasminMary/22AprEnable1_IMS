package com.qa.ims.persistence.domain;

public class Items {
	
	private Long itemId;
	private String itemName;
	private Double price;

	public Items (String itemName, Double price) {
		this.setItemName(itemName);
		this.setPrice(price);
	}
	public Items (Long id, String itemName, Double price) {
		this.setItemId(id);
		this.setItemName(itemName);
		this.setPrice(price);
	}
	
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long id) {
		this.itemId = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "itemId: " + itemId + ", item name: " + itemName + ", Item Price: " + price;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		Items other = (Items) obj;
		if (getItemName() == null) {
			if (other.getItemName() != null)
				return false;
		} else if (!getItemName().equals(other.getItemName()))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
	

}
