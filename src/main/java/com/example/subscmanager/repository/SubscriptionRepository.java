package com.example.subscmanager.repository;

import com.example.subscmanager.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * サブスクリプション契約情報のデータベース操作を担うリポジトリインターフェース。
 */
@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

}
