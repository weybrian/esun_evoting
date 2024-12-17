# esun_evoting
線上投票系統

* WebServer+ApplicationServer

web server 採用 spring-boot-starter-web 預設的 tomcat，處理 http 請求、傳遞靜態資源

application server 處理業務邏輯 與 資料庫存取

tomcat 作為 servlet 容器，可執行 servlet 內的業務邏輯

* 資料庫

H2
