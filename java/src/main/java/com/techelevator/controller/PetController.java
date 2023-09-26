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

    @RequestMapping(path="/pets", method = RequestMethod.GET)
    public List<Pet> getAllPets()
    {
        return dao.getAllPets();
    }

    @RequestMapping(path="/apply", method = RequestMethod.POST)
    public void submitApplication(@RequestBody VolunteerApplication application){
        System.out.println(application);
        // you need to have the right DAO methods to insert application
        // into the database
    }
}
