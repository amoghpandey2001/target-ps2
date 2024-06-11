package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Method to save an order
    public Order createOrder(Order order) {

        return orderRepository.save(order);
    }

    // Method to retrieve an order by ID
    public Optional<Order> getOrderById(String orderId) {
        return orderRepository.findById(orderId);
    }

    // Method to retrieve all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Method to update an existing order
    public Order updateOrder(String orderId, Order updatedOrder) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order existingOrder = optionalOrder.get();
            // Update the fields of the existing order with the fields of the updated order
            existingOrder.setAmount(updatedOrder.getAmount());
            existingOrder.setTransactionId(updatedOrder.getTransactionId());
            existingOrder.setStatus(updatedOrder.isStatus());
            existingOrder.setBank(updatedOrder.getBank());
            // Save the updated order
            return orderRepository.save(existingOrder);
        } else {
            // Handle the case where the order with the specified ID does not exist
            return null; // Or throw an exception
        }
    }

    // Method to delete an order by ID
    public void deleteOrder(String orderId) {
        orderRepository.deleteById(orderId);
    }
}

