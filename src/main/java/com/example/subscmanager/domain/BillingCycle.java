package com.example.subscmanager.domain;

/**
 * サブスクリプションの支払いサイクル（月額・年額）を表す列挙型。
 */
public enum BillingCycle {
    MONTHLY, YEARLY;

    /**
     * 指定された金額を1ヶ月あたりの金額に換算して返します。
     *
     * @param price 契約金額
     * @return 月額換算された金額
     */
    public int toMonthlyAmount(int price) {
        switch (this) {
            case MONTHLY:
                return price;
            case YEARLY:
                return price / 12;
            default:
                return 0;
        }
    }
}
