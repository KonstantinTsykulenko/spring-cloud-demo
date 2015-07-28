package com.smartling.inventory.app;

import com.smartling.inventory.app.entity.InventoryItem;
import com.smartling.inventory.app.repository.InventoryItemRepository;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class InventoryApp
{
    @Autowired
    private InventoryItemRepository repository;

    public static void main(String... args)
    {
        SpringApplication.run(InventoryApp.class, args);
    }

    @Bean
    public CommandLineRunner runner()
    {
        return args->IntStream.range(0, 10).forEach(i->repository.save(new InventoryItem("item" + i, 1L)));
    }
}
