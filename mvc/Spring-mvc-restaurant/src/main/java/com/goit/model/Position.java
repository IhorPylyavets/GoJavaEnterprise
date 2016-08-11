package com.goit.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "POSITIONS")
public class Position {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID")
    private int id;

    @Column(name = "POSITION_TITLE")
    private String positionTitle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", positionTitle='" + positionTitle + '\'' +
                '}';
    }
}

