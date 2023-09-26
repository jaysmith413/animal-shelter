package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class VolunteerApplication {

    private String firstName;
    private String lastName;
    private int phoneNumber;

    private String emailAddress;

    private int applicationId;

    private boolean overEighteen;

    private String approved;

    private String allergies;

    private String skills;

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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
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
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
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


}
