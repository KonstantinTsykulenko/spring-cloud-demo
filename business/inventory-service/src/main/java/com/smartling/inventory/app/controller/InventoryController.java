package com.smartling.inventory.app.controller;

import com.smartling.inventory.app.entity.InventoryItem;
import com.smartling.inventory.app.repository.InventoryItemRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.slf4j.LoggerFactory.*;

@RestController
public class InventoryController
{
    private static Logger logger = getLogger(InventoryController.class);

    @Autowired
    private InventoryItemRepository repository;

    @RequestMapping(value = "/inventoryItems", method = RequestMethod.GET)
    public ResponseEntity<Iterable<InventoryItem>> getInventoryItems()
    {
        logger.info("Listing inventory items");
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/inventoryItems/{itemName}/reserve", method = RequestMethod.POST)
    public ResponseEntity<InventoryItem> reserveInventory(@PathVariable("itemName") String itemName, @RequestParam("qty") Long quantity)
    {
        logger.info("Reserving inventory item");
        InventoryItem inventoryItem = repository.findByName(itemName);
        inventoryItem.setReserved(quantity + inventoryItem.getReserved());
        repository.save(inventoryItem);
        return new ResponseEntity<>(inventoryItem, HttpStatus.OK);
    }
}
