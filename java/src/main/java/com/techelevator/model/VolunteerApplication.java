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

    private boolean animalCare;
    private boolean grooming;
    private boolean cleaningKennels;
    private boolean walkingDogs;
    private boolean catWhisperer;
    private boolean customerService;
    private boolean liftOverThirtyPounds;
    private boolean laundry;
    private boolean stockingSupplies;

    private String skills;



   public VolunteerApplication(){}

   public VolunteerApplication(int applicationId, boolean overEighteen, String approved){
        this.applicationId = applicationId;
        this.overEighteen = overEighteen;
        this.approved = approved;
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

    public String getOtherAllergies() {
        return otherAllergies;
    }

    public void setOtherAllergies(String otherAllergies) {
        this.otherAllergies = otherAllergies;
    }

    public boolean isAnimalCare() {
        return animalCare;
    }

    public void setAnimalCare(boolean animalCare) {
        this.animalCare = animalCare;
    }

    public boolean isGrooming() {
        return grooming;
    }

    public void setGrooming(boolean grooming) {
        this.grooming = grooming;
    }

    public boolean isCleaningKennels() {
        return cleaningKennels;
    }

    public void setCleaningKennels(boolean cleaningKennels) {
        this.cleaningKennels = cleaningKennels;
    }

    public boolean isWalkingDogs() {
        return walkingDogs;
    }

    public void setWalkingDogs(boolean walkingDogs) {
        this.walkingDogs = walkingDogs;
    }

    public boolean isCatWhisperer() {
        return catWhisperer;
    }

    public void setCatWhisperer(boolean catWhisperer) {
        this.catWhisperer = catWhisperer;
    }

    public boolean isCustomerService() {
        return customerService;
    }

    public void setCustomerService(boolean customerService) {
        this.customerService = customerService;
    }

    public boolean isLiftOverThirtyPounds() {
        return liftOverThirtyPounds;
    }

    public void setLiftOverThirtyPounds(boolean liftOverThirtyPounds) {
        this.liftOverThirtyPounds = liftOverThirtyPounds;
    }

    public boolean isLaundry() {
        return laundry;
    }

    public void setLaundry(boolean laundry) {
        this.laundry = laundry;
    }

    public boolean isStockingSupplies() {
        return stockingSupplies;
    }

    public void setStockingSupplies(boolean stockingSupplies) {
        this.stockingSupplies = stockingSupplies;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "VolunteerApplication{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", applicationId=" + applicationId +
                ", overEighteen=" + overEighteen +
                ", approved='" + approved + '\'' +
                ", dander=" + dander +
                ", pollen=" + pollen +
                ", mold=" + mold +
                ", houseCleaners=" + houseCleaners +
                ", otherAllergies='" + otherAllergies + '\'' +
                ", animalCare=" + animalCare +
                ", grooming=" + grooming +
                ", cleaningKennels=" + cleaningKennels +
                ", walkingDogs=" + walkingDogs +
                ", catWhisperer=" + catWhisperer +
                ", customerService=" + customerService +
                ", liftOverThirtyPounds=" + liftOverThirtyPounds +
                ", laundry=" + laundry +
                ", stockingSupplies=" + stockingSupplies +
                ", skills='" + skills + '\'' +
                '}';
    }
}
