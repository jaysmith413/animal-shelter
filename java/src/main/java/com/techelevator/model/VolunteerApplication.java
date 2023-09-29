package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VolunteerApplication {

    private String firstName;
    private String lastName;
    private String phoneNumber;

    private String emailAddress;

    private int applicationId;

    private boolean overEighteen;

    private String approved = "pending";



    private boolean dander;
    private boolean pollen;
    private boolean mold;
    private boolean houseCleaners;

    @JsonProperty("allergies")
    private String otherAllergies;

    private String skills;
    public boolean isDander() {
        return dander;
    }

    public void setDander(boolean dander) {
        this.dander = dander;
    }

    public boolean isPollen() {
        return pollen;
    }

    public void setPollen(boolean pollen) {
        this.pollen = pollen;
    }

    public boolean isMold() {
        return mold;
    }

    public void setMold(boolean mold) {
        this.mold = mold;
    }

    public boolean isHouseCleaners() {
        return houseCleaners;
    }

    public void setHouseCleaners(boolean houseCleaners) {
        this.houseCleaners = houseCleaners;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public boolean isOverEighteen() {
        return overEighteen;
    }

    public void setOverEighteen(boolean overEighteen) {
        this.overEighteen = overEighteen;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getAllergies() {
        return otherAllergies;
    }

    public void setAllergies(String otherAllergies) {
        this.otherAllergies = otherAllergies;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }


   public VolunteerApplication(){}

   public VolunteerApplication(int applicationId, boolean overEighteen, String approved){
        this.applicationId = applicationId;
        this.overEighteen = overEighteen;
        this.approved = approved;
   }

    @Override
    public String toString() {
        return "VolunteerApplication{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", emailAddress='" + emailAddress + '\'' +
                ", applicationId=" + applicationId +
                ", overEighteen=" + overEighteen +
                ", approved='" + approved + '\'' +
                ", otherAllergies='" + otherAllergies + '\'' +
                ", skills='" + skills + '\'' +
                '}';
    }
}
