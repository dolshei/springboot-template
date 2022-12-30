package com.template.springboot.dbTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionTest {

    // DB 연결 드라이버의 정의. mariaDB Driver
    private static final String DRIVER = "org.mariadb.jdbc.Driver";

    // DB 경로
    private static final String URL = "jdbc:mariadb://serverIP:port/springbootdb?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
    private static final String USER = "dbAccount";
    private static final String PASSWORD = "dbAccountPassword";

    @Test
    @DisplayName("DB 연결확인")
    public void testConnection() throws Exception {
        // DBMS 에게 DB 연결 드라이버의 위치를 알려주기 위한 메서드
        Class.forName(DRIVER);
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection : " + connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
