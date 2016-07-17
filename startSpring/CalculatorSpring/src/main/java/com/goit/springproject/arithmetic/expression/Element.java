package com.goit.springproject.arithmetic.expression;

public class Element {

    public enum Category {
        OPERATOR, NUMBER, DATE
    }

    private Category category;
    private String value;
    private int operatorPriority;

    public Element(Category category, String value) {
        this.category = category;
        this.value = value;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getOperatorPriority() {
        return operatorPriority;
    }

    public void setOperatorPriority(int operatorPriority) {
        this.operatorPriority = operatorPriority;
    }

    @Override
    public String toString() {
        return "Element{" +
                "category=" + category +
                ", value='" + value + '\'' +
                ", operatorPriority=" + operatorPriority +
                '}';
    }
}
