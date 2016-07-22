package com.goit.restaurant.model;

public class Employee {

    private int id;
    private String lastName;
    private String firstName;
    private String birthday;
    private String phone;
    private int positionId;
    private float salary;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", positionId=" + positionId +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Employee o = (Employee) obj;

        return (o.getLastName().equals(getLastName()) &&
                o.getFirstName().equals(getFirstName()) &&
                o.getBirthday().equals(getBirthday()) &&
                o.getPhone().equals(getPhone())/* &&
                o.getPositionId().intValue() .(getPositionId() &&
                o.getSalary().equals(getSalary()*/);
    }
}
