package com.example.db;

import org.sql2o.Connection;

import java.util.List;

public class TaskDB {
    private int id;
    private String description;

    public TaskDB(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object otherTaskDB) {
        if (!(otherTaskDB instanceof TaskDB)) {
            return false;
        } else {
            TaskDB newTaskDB = (TaskDB) otherTaskDB;
            return this.getDescription().equals(newTaskDB.getDescription()) &&
                    this.getId() == newTaskDB.getId();
        }
    }

    public static List<TaskDB> all() {
        String sql = "SELECT id, description FROM tasks";
        try (Connection connection = DB.sql2o.open()) {
            return connection.createQuery(sql).executeAndFetch(TaskDB.class);
        }
    }

    public void save() {
        try (Connection connection = DB.sql2o.open()) {
            String sql = "INSERT INTO TASKS (DESCRIPTION) VALUES (:description)";
            this.id = (int) connection.createQuery(sql, true)
                    .addParameter("description", this.description)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static TaskDB find(int id) {
        try (Connection connection = DB.sql2o.open()) {
            String sql = "SELECT * FROM TASKS WHERE ID=:id";
            TaskDB taskDB = connection.createQuery(sql)
                    .addParameter("ID", id)
                    .executeAndFetchFirst(TaskDB.class);
            return taskDB;
        }
    }

}
