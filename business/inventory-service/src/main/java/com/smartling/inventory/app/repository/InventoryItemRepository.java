package com.smartling.inventory.app.repository;

import com.smartling.inventory.app.entity.InventoryItem;
import org.springframework.data.repository.CrudRepository;

public interface InventoryItemRepository extends CrudRepository<InventoryItem, Long>
{
    InventoryItem findByName(String itemName);
}
