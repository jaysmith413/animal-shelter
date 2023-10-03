package com.techelevator.dao;

import com.techelevator.model.Pet;

import java.util.List;

public interface PetDao
{
    List<Pet> getAllPets();

    Pet addPet(Pet pet);

    Pet getPetById(int id);

    Pet updatePet(int id, Pet pet);
}
