package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.VolunteerApplication;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcVolunteerApplicationDao implements VolunteerApplicationDao
{
    private final JdbcTemplate jdbcTemplate;
    public JdbcVolunteerApplicationDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public VolunteerApplication createApplication(VolunteerApplication volunteerApplication)
    {
        VolunteerApplication createVolunteerApplication = null;

        String sql = "INSERT INTO volunteer_information (first_name, last_name, phone_number, email_address," +
                " over_eighteen, approved, dander, pollen, mold, house_cleaners, other_allergies, animal_care, " +
                "grooming, cleaning_kennels, walking_dogs, cat_whisperer, customer_service, lift_over_thirty_pounds, " +
                "laundry, stocking_supplies, skills) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING application_id;";

        try
        {
            int createVolunteerApplicationId = jdbcTemplate.queryForObject(sql, int.class, volunteerApplication.getFirstName(),
                    volunteerApplication.getLastName(), volunteerApplication.getPhoneNumber(),
                    volunteerApplication.getEmailAddress(), volunteerApplication.isOverEighteen(),
                    volunteerApplication.getApproved(), volunteerApplication.isDander(), volunteerApplication.isPollen(),
                    volunteerApplication.isMold(), volunteerApplication.isHouseCleaners(), volunteerApplication.getOtherAllergies(),
                    volunteerApplication.isAnimalCare(), volunteerApplication.isGrooming(), volunteerApplication.isCleaningKennels(),
                    volunteerApplication.isWalkingDogs(), volunteerApplication.isCatWhisperer(), volunteerApplication.isCustomerService(),
                    volunteerApplication.isLiftOverThirtyPounds(), volunteerApplication.isLaundry(), volunteerApplication.isStockingSupplies(),
                    volunteerApplication.getSkills());

            createVolunteerApplication = getVolunteerApplicationById(createVolunteerApplicationId);
        }
        catch (CannotGetJdbcConnectionException e)
        {
            throw new DaoException("Unable to connect to server or database", e);
        }
        catch (DataIntegrityViolationException e)
        {
            throw new DaoException("Data integrity violation", e);
        }

        return createVolunteerApplication;
    }

    @Override
    public List<VolunteerApplication> getAllVolunteerApplications()
    {
       String sql = "SELECT * from volunteer_information;";
       SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

       List<VolunteerApplication> volunteerApplications = new ArrayList<>();

        while(results.next()){
            VolunteerApplication volunteerApplication;
            volunteerApplication = mapRowToVolunteerApplication(results);

           volunteerApplications.add(volunteerApplication);
        }
        return volunteerApplications;
   }

    @Override
    public VolunteerApplication getVolunteerApplicationById(int id)
    {
        VolunteerApplication volunteerApplication = null;
        String sql = "SELECT first_name, last_name, phone_number, email_address, over_eighteen, approved, dander, " +
                "pollen, mold, house_cleaners, other_allergies, animal_care, grooming, cleaning_kennels, " +
                "walking_dogs, cat_whisperer, customer_service, lift_over_thirty_pounds, laundry, stocking_supplies, " +
                "skills " +
                "FROM volunteer_information WHERE application_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                volunteerApplication = mapRowToVolunteerApplicationWithoutId(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return volunteerApplication;
    }

    @Override
    public VolunteerApplication updateVolunteerApplication(int id, VolunteerApplication volunteerApplication)
    {
        VolunteerApplication updateVolunteerApplication = null;
        System.out.println(volunteerApplication);

        String sql ="UPDATE volunteer_information " +
                    "SET first_name = ?, last_name = ?, phone_number = ?, email_address = ?, " +
                    "over_eighteen = ?, approved = ?, skills = ?, mold = ?, house_cleaners = ?, " +
                    "other_allergies = ?, animal_care = ?, grooming = ?, cleaning_kennels = ?, walking_dogs = ?, " +
                    "cat_whisperer = ?, customer_service = ?, lift_over_thirty_pounds = ?, laundry = ?, " +
                    "stocking_supplies = ?, dander = ?, pollen = ? WHERE application_id = ?;";

        try {

            int rowsAffected = jdbcTemplate.update(sql, volunteerApplication.getFirstName(), volunteerApplication.getLastName(),
                    volunteerApplication.getPhoneNumber(), volunteerApplication.getEmailAddress(), volunteerApplication.isOverEighteen(),
                    volunteerApplication.getApproved(), volunteerApplication.getSkills(), volunteerApplication.isMold(),
                    volunteerApplication.isHouseCleaners(), volunteerApplication.getOtherAllergies(), volunteerApplication.isAnimalCare(),
                    volunteerApplication.isGrooming(), volunteerApplication.isCleaningKennels(), volunteerApplication.isWalkingDogs(),
                    volunteerApplication.isCatWhisperer(), volunteerApplication.isCustomerService(), volunteerApplication.isLiftOverThirtyPounds(),
                    volunteerApplication.isLaundry(), volunteerApplication.isStockingSupplies(), volunteerApplication.isDander(),
                    volunteerApplication.isPollen(), id);

//            int rowsAffected = jdbcTemplate.update(sql, int.class, volunteerApplication.getFirstName(),
//                    volunteerApplication.getLastName(), volunteerApplication.getPhoneNumber(),
//                    volunteerApplication.getEmailAddress(), volunteerApplication.isOverEighteen(),
//                    "approved", volunteerApplication.getOtherAllergies(), volunteerApplication.getSkills(), id);

            if (rowsAffected == 0)
            {
                throw new DaoException("Zero rows affected, expected at least one");
            }
            else
            {
                updateVolunteerApplication = getVolunteerApplicationById(volunteerApplication.getApplicationId());
            }
        }
        catch (CannotGetJdbcConnectionException e)
        {
            throw new DaoException("Unable to connect to server or database", e);
        }
        catch (DataIntegrityViolationException e)
        {
            throw new DaoException("Data integrity violation", e);
        }
        return updateVolunteerApplication;
    }

    private VolunteerApplication mapRowToVolunteerApplication(SqlRowSet results)
    {
        VolunteerApplication volunteerApplication = new VolunteerApplication();

        volunteerApplication.setApplicationId(results.getInt("application_id"));
        volunteerApplication.setFirstName(results.getString("first_name"));
        volunteerApplication.setLastName(results.getString("last_name"));
        volunteerApplication.setPhoneNumber(results.getString("phone_number"));
        volunteerApplication.setEmailAddress(results.getString("email_address"));
        volunteerApplication.setOverEighteen(results.getBoolean("over_eighteen"));
        volunteerApplication.setDander(results.getBoolean("dander"));
        volunteerApplication.setPollen(results.getBoolean("pollen"));
        volunteerApplication.setMold(results.getBoolean("mold"));
        volunteerApplication.setHouseCleaners(results.getBoolean("house_cleaners"));
        volunteerApplication.setOtherAllergies(results.getString("other_allergies"));
        volunteerApplication.setAnimalCare(results.getBoolean("animal_care"));
        volunteerApplication.setGrooming(results.getBoolean("grooming"));
        volunteerApplication.setCatWhisperer(results.getBoolean("cat_whisperer"));
        volunteerApplication.setCleaningKennels(results.getBoolean("cleaning_kennels"));
        volunteerApplication.setCustomerService(results.getBoolean("customer_service"));
        volunteerApplication.setLaundry(results.getBoolean("laundry"));
        volunteerApplication.setLiftOverThirtyPounds(results.getBoolean("lift_over_thirty_pounds"));
        volunteerApplication.setStockingSupplies(results.getBoolean("stocking_supplies"));
        volunteerApplication.setWalkingDogs(results.getBoolean("walking_dogs"));
        volunteerApplication.setSkills(results.getString("skills"));

        return volunteerApplication;
    }

    private VolunteerApplication mapRowToVolunteerApplicationWithoutId(SqlRowSet results)
    {
        VolunteerApplication volunteerApplication = new VolunteerApplication();

        volunteerApplication.setFirstName(results.getString("first_name"));
        volunteerApplication.setLastName(results.getString("last_name"));
        volunteerApplication.setPhoneNumber(results.getString("phone_number"));
        volunteerApplication.setEmailAddress(results.getString("email_address"));
        volunteerApplication.setOverEighteen(results.getBoolean("over_eighteen"));
        volunteerApplication.setDander(results.getBoolean("dander"));
        volunteerApplication.setPollen(results.getBoolean("pollen"));
        volunteerApplication.setMold(results.getBoolean("mold"));
        volunteerApplication.setHouseCleaners(results.getBoolean("house_cleaners"));
        volunteerApplication.setOtherAllergies(results.getString("other_allergies"));
        volunteerApplication.setAnimalCare(results.getBoolean("animal_care"));
        volunteerApplication.setGrooming(results.getBoolean("grooming"));
        volunteerApplication.setCatWhisperer(results.getBoolean("cat_whisperer"));
        volunteerApplication.setCleaningKennels(results.getBoolean("cleaning_kennels"));
        volunteerApplication.setCustomerService(results.getBoolean("customer_service"));
        volunteerApplication.setLaundry(results.getBoolean("laundry"));
        volunteerApplication.setLiftOverThirtyPounds(results.getBoolean("lift_over_thirty_pounds"));
        volunteerApplication.setStockingSupplies(results.getBoolean("stocking_supplies"));
        volunteerApplication.setWalkingDogs(results.getBoolean("walking_dogs"));
        volunteerApplication.setSkills(results.getString("skills"));

        return volunteerApplication;
    }
}
