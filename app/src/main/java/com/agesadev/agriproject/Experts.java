package com.agesadev.agriproject;

public class Experts {
    private String eName,region, contact;
    String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

//    public Experts() {
//    }

    public Experts(String eName, String region, String contact) {
        this.eName = eName;
        this.region = region;
        this.contact = contact;

    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
