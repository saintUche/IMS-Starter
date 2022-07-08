package com.qa.ims.persistence.domain;



public class Order {

    Long id;
    Long customerId;
    String items;
    String itemIds;
    double cost;

    

    public Order(Long id, Long customerId, String items, String itemIds, double cost) {
        this.id = id;
        this.customerId = customerId;
        this.items = items;
        this.itemIds = itemIds;
        this.cost = cost;
    }
    
    public Order(Long customerId, String items, String itemIds, double cost) {
        this.customerId = customerId;
        this.items = items;
        this.itemIds = itemIds;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(cost);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((itemIds == null) ? 0 : itemIds.hashCode());
        result = prime * result + ((items == null) ? 0 : items.hashCode());
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
        Order other = (Order) obj;
        if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
            return false;
        if (customerId == null) {
            if (other.customerId != null)
                return false;
        } else if (!customerId.equals(other.customerId))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (itemIds == null) {
            if (other.itemIds != null)
                return false;
        } else if (!itemIds.equals(other.itemIds))
            return false;
        if (items == null) {
            if (other.items != null)
                return false;
        } else if (!items.equals(other.items))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Order [cost=" + cost + ", customerId=" + customerId + ", id=" + id + ", itemIds=" + itemIds + ", items="
                + items + "]";
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public String getItems() {
        return items;
    }
    public void setItems(String items) {
        this.items = items;
    }
    public String getItemIds() {
        return itemIds;
    }
    public void setItemIds(String itemIds) {
        this.itemIds = itemIds;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

 

 
    
}
