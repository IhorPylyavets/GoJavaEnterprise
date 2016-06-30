package com.goit;

/**
 * Created by vbevz on 6/29/2016.
 */
public interface Task <T> {

    void execute();
    T getResult();

}
