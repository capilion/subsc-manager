package com.example.subscmanager.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * サブスクリプションの契約情報を表すドメインモデル。
 */
@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;

    @Enumerated(EnumType.STRING)
    private BillingCycle cycle;

    private String category;

    protected Subscription() {

    }

    public Long getId() {
        return id;
    }

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
