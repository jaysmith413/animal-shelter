package com.techelevator.dao;

import com.techelevator.model.VolunteerApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcVolunteerApplicationDao {
    private JdbcTemplate template;
    public JdbcVolunteerApplicationDao(DataSource dataSource){
        template = new JdbcTemplate(dataSource);
    }

    //TODO:
    @Override
    public List<VolunteerApplication> getAllVolunteerApplications(){
       String sql = "SELECT * from volunteer_information;";
       SqlRowSet results = template.queryForRowSet(sql);
       List<VolunteerApplication> volunteerApplications = new ArrayList<>();
        while(results.next()){
            VolunteerApplication volunteerApplication = new VolunteerApplication();
            volunteerApplication = mapRowToVolunteerApplication(results);

           volunteerApplications.add(volunteerApplication);
        }
        return volunteerApplications;
   }
    private VolunteerApplication mapRowToVolunteerApplication(SqlRowSet results){
       VolunteerApplication volunteerApplication = new VolunteerApplication();
       volunteerApplication.setFirstName(results.getString());
    }
}
