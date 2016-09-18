package com.goit.dao;

import com.goit.model.Waiter;

public interface WaiterDao {

    Waiter findWaiterByFullName(String lastName, String firstName);

}
