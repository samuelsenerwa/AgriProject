package com.agesadev.agriproject.model;

public class Tips {
    private String name;
    private String description;

    public Tips(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Tip{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
