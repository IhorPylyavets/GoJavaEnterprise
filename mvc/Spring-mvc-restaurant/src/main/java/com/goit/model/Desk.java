package com.goit.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DESKS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Desk implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DESK_TITLE")
    private String deskTitle;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_OF_DESK")
    private DeskStatus deskStatus;

    public Desk() {
    }

    public Desk(String deskTitle) {
        this.deskTitle = deskTitle;
        this.deskStatus = DeskStatus.FREE;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public boolean isNew() {
        return (this.id == null);
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
