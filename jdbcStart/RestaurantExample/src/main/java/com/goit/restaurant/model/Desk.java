package com.goit.restaurant.model;

public class Desk {

    public enum DeskStatus {
        ORDERED("ORDERED"), FREE("FREE");

        private final String status;

        private DeskStatus(final String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return status;
        }
    }

    private int id;
    private String deskTitle;
    private DeskStatus deskStatus;

    public Desk() {
    }

    public Desk(int id, String deskTitle, DeskStatus deskStatus) {
        this.id = id;
        this.deskTitle = deskTitle;
        this.deskStatus = deskStatus;
    }

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
