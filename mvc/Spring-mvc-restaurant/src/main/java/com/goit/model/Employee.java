package com.goit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "EMPLOYEES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Employee implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "PHONE")
    private String phone;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "POSITION_ID")
    private Position position;

    @Column(name = "SALARY")
    private float salary;

    public Employee() {
    }

    public Employee(String lastName, String firstName, Date birthday, String phone, Position position, float salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.phone = phone;
        this.position = position;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isNew() {
        return (this.id == null);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phone='" + phone + '\'' +
                ", position=" + position +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (Float.compare(employee.salary, salary) != 0) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (birthday != null ? !birthday.equals(employee.birthday) : employee.birthday != null) return false;
        if (phone != null ? !phone.equals(employee.phone) : employee.phone != null) return false;
        return position != null ? position.equals(employee.position) : employee.position == null;

    }

    @Override
    public int hashCode() {
        int result = lastName != null ? lastName.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (salary != +0.0f ? Float.floatToIntBits(salary) : 0);
        return result;
    }
}
