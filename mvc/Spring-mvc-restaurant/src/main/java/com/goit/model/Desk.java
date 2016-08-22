package com.goit.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "DESKS")
public class Desk {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID")
    private int id;

    @Column(name = "DESK_TITLE")
    private String deskTitle;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_OF_DESK")
    private DeskStatus deskStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeskTitle() {
        return deskTitle;
    }

    public void setDeskTitle(String deskTitle) {
        this.deskTitle = deskTitle;
    }

    public DeskStatus getDeskStatus() {
        return deskStatus;
    }

    public void setDeskStatus(DeskStatus deskStatus) {
        this.deskStatus = deskStatus;
    }

    @Override
    public String toString() {
        return "Desk{" +
                "id=" + id +
                ", deskTitle='" + deskTitle + '\'' +
                ", deskStatus=" + deskStatus +
                '}';
    }
}
