package com.example.subscmanager.service;

import com.example.subscmanager.repository.SubscriptionRepository;
import com.example.subscmanager.domain.BillingCycle;
import com.example.subscmanager.domain.Subscription;
import com.example.subscmanager.domain.SubscriptionManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * サブスクリプション管理に関するビジネスロジックを提供するサービスクラス。
 */
@Service
public class SubscriptionService {
    private final SubscriptionRepository repository;

    public SubscriptionService(SubscriptionRepository repository) {
        this.repository = repository;
        repository.save(new Subscription("amazon", 500, BillingCycle.MONTHLY, "買い物"));
        repository.save(new Subscription("rakuten", 11000, BillingCycle.YEARLY, "買い物"));
        repository.save(new Subscription("netflix", 1500, BillingCycle.MONTHLY, "エンタメ"));
    }

    public void add(Subscription subscription) {
        repository.save(subscription);
    }

    public List<Subscription> getAll() {
        return repository.findAll();
    }

    private SubscriptionManager createManagerFromDb() {
        SubscriptionManager manager = new SubscriptionManager();
        for (Subscription sub : repository.findAll()) {
            manager.add(sub);
        }
        return manager;
    }

    public int getTotalMonthlyPrice() {
        return createManagerFromDb().getTotalMonthlyPrice();
    }

    public Map<String, Integer> getMonthlyPriceByCategory() {
        return createManagerFromDb().getMonthlyPriceByCategory();
    }
}
