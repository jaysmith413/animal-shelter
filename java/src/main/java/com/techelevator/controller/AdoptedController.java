package com.techelevator.controller;

import com.techelevator.dao.AdoptedDao;
import com.techelevator.model.Adopted;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class AdoptedController {
    private AdoptedDao dao;
    public AdoptedController(AdoptedDao dao){
        this.dao = dao;
    }

    @RequestMapping(path="/adopted", method = RequestMethod.GET)
    public List<Adopted> getAdoptedPets(){
        return dao.getAdoptedPets();
    }
}
