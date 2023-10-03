package com.techelevator.controller;

import com.techelevator.dao.VolunteerApplicationDao;
import com.techelevator.model.User;
import com.techelevator.model.VolunteerApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class VolunteerController
{
    @Autowired
    VolunteerApplicationDao dao;

    @RequestMapping(path="/apply", method = RequestMethod.POST)
    public VolunteerApplication submitApplication(@RequestBody VolunteerApplication application){
        return dao.createApplication(application);
        // you need to have the right DAO methods to insert application
        // into the database
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/applications", method = RequestMethod.GET)
    public List<VolunteerApplication> getAllApplications(){
        return dao.getAllVolunteerApplications();
    }



    @RequestMapping(path="/updateapplication/{id}", method = RequestMethod.PUT)
    public VolunteerApplication updateApplication(@PathVariable int id, @RequestBody VolunteerApplication application){
        return dao.updateVolunteerApplication(id, application);
    }
}
