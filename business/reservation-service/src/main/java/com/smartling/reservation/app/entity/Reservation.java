package com.smartling.reservation.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reservation
{
    @Id
    @GeneratedValue
    private Long id;

    private String itemName;

    private Long quantity;

    public Reservation()
    {
    }

    public Reservation(String itemName, Long quantity)
    {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getItemName()
    {
        return itemName;
    }

    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }

    public Long getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Long quantity)
    {
        this.quantity = quantity;
    }
}
