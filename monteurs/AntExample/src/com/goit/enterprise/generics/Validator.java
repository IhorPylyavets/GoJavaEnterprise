package com.goit.enterprise.generics;

public interface Validator<T> {
    boolean isValid(T result);
}
