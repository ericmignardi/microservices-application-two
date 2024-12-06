package com.ericmignardi.inventory;

import com.ericmignardi.inventory.model.Inventory;
import com.ericmignardi.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@RequiredArgsConstructor
public class InventoryServiceApplication implements CommandLineRunner {

	private final InventoryRepository inventoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Inventory inventory = Inventory.builder()
				.quantity(100)
				.skuCode("iPhone 16")
				.build();
		Inventory inventory1 = Inventory.builder()
				.quantity(100)
				.skuCode("Pixel 8")
				.build();
		Inventory inventory2 = Inventory.builder()
				.quantity(100)
				.skuCode("Galaxy 24")
				.build();
		inventoryRepository.save(inventory);
		inventoryRepository.save(inventory1);
		inventoryRepository.save(inventory2);
	}
}