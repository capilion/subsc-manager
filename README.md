# Subsc Manager（サブスク・固定費管理アプリ）

Java / Spring Boot を用いた、サブスクリプション（月額・年額サービス）および固定費を一元管理・集計するWebアプリケーションです。

## 技術スタック
- **Java**: 25 (LTS)
- **Framework**: Spring Boot 4.x (Spring Web MVC, Spring Data JPA, Validation, Thymeleaf)
- **Database**: H2 Database (In-Memory / File)
- **Build Tool**: Maven (`mvnw` 同梱)
- **Test**: JUnit 5

## 主な機能・開発構成
- [ ] **ドメインモデル・集計ロジック**: 支払いサイクル（月額・年額）に応じた月額換算およびカテゴリ別集計（Stream API / JUnit 5）
- [ ] **REST API**: サブスクリプション情報の登録・取得・更新・削除（Controller / Service 層）
- [ ] **データ永続化**: Spring Data JPA + H2 Database によるデータ管理（Repository 層）
- [ ] **Web UI**: Thymeleaf を用いた管理画面

## 実行方法（テスト・起動）

### テストの実行
```powershell
.\mvnw.cmd test
```

### アプリケーションの起動
```powershell
.\mvnw.cmd spring-boot:run
```
