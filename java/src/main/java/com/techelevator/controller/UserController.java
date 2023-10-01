package com.techelevator.controller;
import com.techelevator.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserDao dao;

    // Get only approved users:
//
//    @RequestMapping(path = "/approvedUsers", method = RequestMethod.GET)
//    public List<User> getApprovedUsers(){
//        return dao.getApprovedUsers();
//    }

}
