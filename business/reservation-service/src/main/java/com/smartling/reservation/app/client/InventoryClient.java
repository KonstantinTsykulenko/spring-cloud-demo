package com.smartling.reservation.app.client;

import com.smartling.inventory.app.entity.InventoryItem;
import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("inventory-service")
public interface InventoryClient
{
    @RequestMapping(value = "/inventoryItems", method = RequestMethod.GET)
    List<InventoryItem> getInventory();

    @RequestMapping(value = "/inventoryItems/{itemName}/reserve", method = RequestMethod.POST)
    InventoryItem reserve(@PathVariable("itemName") String itemName, @RequestParam("qty") Long qty);
}
