package com.example.projektzespolowy.model;

public class CalendarListViewItem {
    private Long id;
    private String name;
    private boolean isWatered;


    public CalendarListViewItem(Long id, String name, boolean isWatered) {
        this.id = id;
        this.name = name;
        this.isWatered = isWatered;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWatered() {
        return isWatered;
    }

    public void setWatered(boolean watered) {
        isWatered = watered;
    }

    @Override
    public String toString() {
        return name;
    }
}
