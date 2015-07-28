package com.smartling.inventory.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class InventoryItem
{
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Long count;

    private Long reserved = 0L;

    public InventoryItem()
    {
    }

    public InventoryItem(String name, Long count)
    {
        this.name = name;
        this.count = count;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getCount()
    {
        return count;
    }

    public void setCount(Long count)
    {
        this.count = count;
    }

    public Long getReserved()
    {
        return reserved;
    }

    public void setReserved(Long reserved)
    {
        this.reserved = reserved;
    }
}
