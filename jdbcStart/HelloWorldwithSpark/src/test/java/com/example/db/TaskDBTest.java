package com.example.db;

import com.example.DatabaseRule;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskDBTest {

    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @Test
    public void all_emptyAtFirst() {
        assertEquals(TaskDB.all().size(), 0);
    }

    @Test
    public void equals_returnsTrueIfDescriptionsSame() {
        TaskDB firstTaskDB = new TaskDB("Mow the lawn");
        TaskDB secondTaskDB = new TaskDB("Mow the lawn");
        assertTrue(firstTaskDB.equals(secondTaskDB));
    }

    @Test
    public void save_returnsTrueIfDescriptionsSame() {
        TaskDB myTaskDB = new TaskDB("Mow the lawn");
        myTaskDB.save();
        assertTrue(TaskDB.all().get(0).equals(myTaskDB));
    }

    @Test
    public void save_assignsIdToObject() {
        TaskDB myTaskDB = new TaskDB("Mow the lawn");
        myTaskDB.save();
        TaskDB savedTaskDB = TaskDB.all().get(0);
        assertEquals(myTaskDB.getId(), savedTaskDB.getId());
    }

    @Test
    public void find_findsTaskInDataBase_true() {
        TaskDB myTaskDB = new TaskDB("Mow the lawn");
        myTaskDB.save();
        TaskDB savedTaskDB = TaskDB.find(myTaskDB.getId());
        assertTrue(myTaskDB.equals(savedTaskDB));
    }

}