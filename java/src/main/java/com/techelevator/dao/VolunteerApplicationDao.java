package com.techelevator.dao;

import com.techelevator.model.Pet;
import com.techelevator.model.VolunteerApplication;

import java.util.List;

public interface VolunteerApplicationDao {
    VolunteerApplication createApplication(VolunteerApplication volunteerApplication);

    List<VolunteerApplication> getAllVolunteerApplications();

    VolunteerApplication getVolunteerApplicationById(int id);

    VolunteerApplication updateVolunteerApplication(int id, VolunteerApplication volunteerApplication);

}
