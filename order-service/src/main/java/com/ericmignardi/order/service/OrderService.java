package com.ericmignardi.order.service;

import com.ericmignardi.order.client.InventoryClient;
import com.ericmignardi.order.dto.OrderRequest;
import com.ericmignardi.order.event.OrderPlacedEvent;
import com.ericmignardi.order.model.Order;
import com.ericmignardi.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    public void placeOrder(OrderRequest orderRequest) {
        var isInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if (isInStock) {
            Order order = Order.builder()
                    .orderNumber(UUID.randomUUID().toString())
                    .price(orderRequest.price())
                    .skuCode(orderRequest.skuCode())
                    .quantity(orderRequest.quantity())
                    .build();
            orderRepository.save(order);
            OrderPlacedEvent orderPlacedEvent = new OrderPlacedEvent(order.getOrderNumber());
            log.info("START - Sending OrderPlacedEvent {} to Kafka Topic orderPlaced", orderPlacedEvent);
            kafkaTemplate.send("orderPlaced", orderPlacedEvent);
            log.info("END - Received OrderPlacedEvent {} to Kafka Topic orderPlaced", orderPlacedEvent);
        } else {
            throw new RuntimeException("Product With SkuCode " + orderRequest.skuCode() + " Is Not In Stock");
        }
    }
}
