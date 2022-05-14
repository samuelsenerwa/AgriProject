package com.agesadev.agriproject.model;

public class Experts {
//    private String eName, region, contact;
//    String key;

    private String expertName;
    private String expertRole;
    private String region;
    private String key;
    private String email;
    private String contactPhone;

    public String getExpertName() {
        return expertName;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName;
    }

    public String getExpertRole() {
        return expertRole;
    }

    public void setExpertRole(String expertRole) {
        this.expertRole = expertRole;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @Override
    public String toString() {
        return "Experts{" +
                "expertName='" + expertName + '\'' +
                ", expertRole='" + expertRole + '\'' +
                ", region='" + region + '\'' +
                ", key='" + key + '\'' +
                ", email='" + email + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                '}';
    }
}
