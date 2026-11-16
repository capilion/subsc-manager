package com.example.subscmanager.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 複数のサブスクリプション契約を管理し、集計処理を行うドメインサービス。
 */
public class SubscriptionManager {
    private final List<Subscription> subscriptions = new ArrayList<>();

    public void add(Subscription subscription) {
        this.subscriptions.add(subscription);
    }

    public List<Subscription> getAll() {
        return subscriptions;
    }

    public int getTotalMonthlyPrice() {
        return subscriptions.stream()
                .mapToInt(Subscription::getMonthlyPrice)
                .sum();
    }

    public Map<String, Integer> getMonthlyPriceByCategory() {
        return subscriptions.stream()
                .collect(Collectors.groupingBy(
                        Subscription::getCategory,

                        Collectors.summingInt(Subscription::getMonthlyPrice)));
    }
}
