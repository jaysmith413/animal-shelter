package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.model.Pet;
import com.techelevator.model.VolunteerApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PetController
{
    @Autowired
    PetDao dao;

    @RequestMapping(path = "/pets", method = RequestMethod.POST)
    public Pet addPet(@RequestBody Pet pet){
        //dao
        return dao.addPet(pet);
    }

    @RequestMapping(path="/pets", method = RequestMethod.GET)
    public List<Pet> getAllPets()
    {
        return dao.getAllPets();
    }



//    Alternative version?
//    @RequestMapping(path = "/pets", method = RequestMethod.POST)
//    public Pet addPet(@ModelAttribute Pet pet){
//        //dao
//        return dao.addPet(pet);
//    }

    @RequestMapping(path="/pets/{id}", method = RequestMethod.PUT)
    public Pet updatePet(@PathVariable int id, @RequestBody Pet pet){
        return dao.updatePet(id, pet);
    }
}
