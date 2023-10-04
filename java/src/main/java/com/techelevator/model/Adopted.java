package com.techelevator.model;

public class Adopted {
    //Variables
    private int id;
    private String name;
    private String type;
    private int age;
    private String gender;
    private String specialNeeds;
    private boolean adopted;
    private String personalityTraits;
    private String image;
    private boolean goodWithKids;
    private boolean goodWithOtherAnimals;
    //End Variables

    //Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
    public String getSpecialNeeds() {
        return specialNeeds;
    }
    public boolean isAdopted() {
        return adopted;
    }
    public String getPersonalityTraits() {
        return personalityTraits;
    }
    public String getImage() {
        return image;
    }
    public boolean isGoodWithKids() {
        return goodWithKids;
    }
    public boolean isGoodWithOtherAnimals() {
        return goodWithOtherAnimals;
    }
    //End Getters

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setSpecialNeeds(String specialNeeds) {
        this.specialNeeds = specialNeeds;
    }
    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }
    public void setPersonalityTraits(String personalityTraits) {
        this.personalityTraits = personalityTraits;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setGoodWithKids(boolean goodWithKids) {
        this.goodWithKids = goodWithKids;
    }
    public void setGoodWithOtherAnimals(boolean goodWithOtherAnimals) {
        this.goodWithOtherAnimals = goodWithOtherAnimals;
    }
    //End Setters
}
