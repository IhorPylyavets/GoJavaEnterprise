package com.example;

import com.example.db.DB;
import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


public class DatabaseRule extends ExternalResource {
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/spark_test", "user", "12345");
    }

    protected void after() {
        try (Connection connection = DB.sql2o.open()) {
            String deleteTasksQuery = "DELETE FROM TASKS *;";
            connection.createQuery(deleteTasksQuery).executeUpdate();
        }
    }
}
