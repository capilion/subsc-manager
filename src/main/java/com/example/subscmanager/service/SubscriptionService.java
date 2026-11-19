package com.example.subscmanager.service;

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
    private final SubscriptionManager manager = new SubscriptionManager();

    public SubscriptionService() {
        manager.add(new Subscription("amazon", 500, BillingCycle.MONTHLY, "買い物"));
        manager.add(new Subscription("rakuten", 11000, BillingCycle.YEARLY, "買い物"));
        manager.add(new Subscription("netflix", 1500, BillingCycle.MONTHLY, "エンタメ"));
    }

    public void add(Subscription subscription) {
        manager.add(subscription);
    }

    public List<Subscription> getAll() {
        return manager.getAll();
    }

    public int getTotalMonthlyPrice() {
        return manager.getTotalMonthlyPrice();
    }

    public Map<String, Integer> getMonthlyPriceByCategory() {
        return manager.getMonthlyPriceByCategory();
    }
}
