package com.example.persistpojojson.controller;

import com.example.persistpojojson.entity.Order;
import com.example.persistpojojson.model.InputRequest;
import com.example.persistpojojson.model.ApiResponse;
import com.example.persistpojojson.model.OutputRequest;
import com.example.persistpojojson.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/persist")
@RequiredArgsConstructor
public class HelloController {

    private final OrderRepository orderRepository;

    @PostMapping
    public ResponseEntity<ApiResponse> persist(@RequestBody InputRequest apiRequest) {
        Order order = Order.builder()
                .apiRequest(apiRequest)
                .build();
        Order saved = orderRepository.save(order);
        ApiResponse apiResponse = ApiResponse.builder()
                .order(saved)
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> fetch(@RequestBody OutputRequest outputRequest) {
        Optional<Order> optionalOrder = orderRepository.findById(outputRequest.getOrderId());
        ApiResponse apiResponse = ApiResponse.builder()
                .order(optionalOrder.orElse(null))
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
