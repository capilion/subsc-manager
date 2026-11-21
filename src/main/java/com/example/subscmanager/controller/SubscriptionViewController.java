package com.example.subscmanager.controller;

import com.example.subscmanager.domain.BillingCycle;
import com.example.subscmanager.domain.Subscription;
import com.example.subscmanager.service.SubscriptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * サブスクリプション管理画面（HTML）の表示およびフォーム送信を処理するコントローラクラス。
 */
@Controller
@RequestMapping("/subscriptions")
public class SubscriptionViewController {
    private final SubscriptionService service;

    public SubscriptionViewController(SubscriptionService service) {
        this.service = service;
    }

    public String showsubcriptions(Model model) {
        model.addAttribute("subscriptions", service.getAll());
        model.addAttribute("totalMonthlyPrice", service.getTotalMonthlyPrice());
        model.addAttribute("categoryTotals", service.getMonthlyPriceByCategory());
        return "subscriptions";
    }
}
