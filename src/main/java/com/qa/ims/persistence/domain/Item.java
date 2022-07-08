package com.qa.ims.persistence.domain;

public class Item {
    Long id; 
    String itemName;
    double cost;


    public Item(Long id, String itemName, double cost) {
        this.id = id;
        this.itemName = itemName;
        this.cost = cost;
    }

    public Item(String itemName, double cost) {
        this.itemName = itemName;
        this.cost = cost;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }
    
    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Item [cost=" + cost + ", id=" + id + ", itemName=" + itemName + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(cost);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
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
        Item other = (Item) obj;
        if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (itemName == null) {
            if (other.itemName != null)
                return false;
        } else if (!itemName.equals(other.itemName))
            return false;
        return true;
    }
}
