package org.example.tests;

import org.example.db.DbUtils;
import org.junit.jupiter.api.AfterAll;

public abstract class BaseTest {

    // Константы для использования в API запросах


    @AfterAll
    static void tearDown() {
        DbUtils.closeConnection();
    }
}
