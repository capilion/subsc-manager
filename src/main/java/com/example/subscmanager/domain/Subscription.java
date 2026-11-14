package com.example.subscmanager.domain;

/**
 * サブスクリプションの契約情報を表すドメインモデル。
 */
public class Subscription {
    private String name;
    private int price;
    private BillingCycle cycle;
    private String category;

    public Subscription(String name, int price, BillingCycle cycle, String category) {
        if (price < 0) {
            throw new IllegalArgumentException("金額がマイナスです");
        }
        this.name = name;
        this.price = price;
        this.cycle = cycle;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public BillingCycle getCycle() {
        return cycle;
    }

    public String getCategory() {
        return category;
    }

    public int getMonthlyPrice() {
        return cycle.toMonthlyAmount(price);
    }
}
