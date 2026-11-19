package com.example.subscmanager.controller;

import com.example.subscmanager.domain.Subscription;
import com.example.subscmanager.service.SubscriptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * サブスクリプション管理に関するREST APIエンドポイントを提供するコントローラクラス。
 */
@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {
    private final SubscriptionService service;

    public SubscriptionController(SubscriptionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Subscription> getAll() {
        return service.getAll();
    }

    @PostMapping
    public void add(@RequestBody Subscription subscription) {
        service.add(subscription);
    }

    @GetMapping("/total")
    public int getTotalMonthlyPrice() {
        return service.getTotalMonthlyPrice();
    }

    @GetMapping("/category")
    public Map<String, Integer> getMonthlyPriceByCategory() {
        return service.getMonthlyPriceByCategory();
    }
}
