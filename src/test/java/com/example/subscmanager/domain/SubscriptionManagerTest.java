package com.example.subscmanager.domain;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * {@link SubscriptionManager} および関連ドメインモデルの単体テスト。
 */
class SubscriptionManagerTest {

    @Test
    void testSubscriptionManager() {
        SubscriptionManager manager = new SubscriptionManager();

        manager.add(new Subscription("amazon", 500, BillingCycle.MONTHLY, "買い物"));
        manager.add(new Subscription("rakuten", 11000, BillingCycle.YEARLY, "買い物"));
        manager.add(new Subscription("netflix", 1500, BillingCycle.MONTHLY, "エンタメ"));

        assertEquals(2916, manager.getTotalMonthlyPrice());

        Map<String, Integer> categoryMap = manager.getMonthlyPriceByCategory();
        assertEquals(1416, categoryMap.get("買い物"));
        assertEquals(1500, categoryMap.get("エンタメ"));
    }

    @Test
    void testNegativePriceThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Subscription("error", -500, BillingCycle.MONTHLY, "買い物");
        });
    }
}
