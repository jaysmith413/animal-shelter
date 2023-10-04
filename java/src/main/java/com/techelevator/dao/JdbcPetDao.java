package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Pet;
import com.techelevator.model.VolunteerApplication;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
// import Oracle.sql.BLOB

@Component
public class JdbcPetDao implements PetDao
{
    private JdbcTemplate template;

    public JdbcPetDao(DataSource dataSource)
    {
        template = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Pet> getAllPets()
    {
        String sql = "SELECT * from pet_information WHERE adopted = false;";
        SqlRowSet results = template.queryForRowSet(sql);

        List<Pet> pets = new ArrayList<>();
        while(results.next()) {
            Pet pet;
            pet = mapRowToPet(results);

            pets.add(pet);
        }
        return pets;
    }

    @Override
    public Pet addPet(Pet pet){
        Pet createdPet = null;

        String sql = "INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, " +
                "adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING pet_id;";

        try
        {
            int createdPetId = template.queryForObject(sql, int.class, pet.getName(), pet.getType(), pet.getAge(),
                    pet.getGender(), pet.getSpecialNeeds(), pet.isAdopted(), pet.getPetPicture(), pet.getPersonalityTraits(),
                    pet.isGoodWithKids(), pet.isGoodWithOtherAnimals());

            createdPet = getPetById(createdPetId);
        }
        catch (CannotGetJdbcConnectionException e)
        {
            throw new DaoException("Unable to connect to server or database", e);
        }
        catch (DataIntegrityViolationException e)
        {
            throw new DaoException("Data integrity violation", e);
        }

        return createdPet;
    }

    public Pet getPetById(int id) {
        Pet pet = null;
        String sql = "SELECT pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, " +
                "pet_picture, personality_traits, good_with_kids, good_with_other_animals " +
                "FROM pet_information WHERE pet_id = ?;";

        try {
            SqlRowSet results = template.queryForRowSet(sql, id);
            if (results.next()) {
                pet = mapRowToPetWithoutId(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return pet;
    }
    public Pet updatePet(int id, Pet pet){
        Pet updatedPet = null;


        String sql ="UPDATE pet_information " +
                "SET pet_name = ?, pet_type = ?, pet_age = ?, pet_gender = ?, " +
                "pet_special_needs = ?, adopted = ?, pet_picture = ?, personality_traits = ?, " +
                " good_with_kids = ?, good_with_other_animals = ? WHERE pet_id = ?;";

        try {
            int rowsAffected = template.update(sql, pet.getName(), pet.getType(),
                    pet.getAge(), pet.getGender(), pet.getSpecialNeeds(), pet.isAdopted(),
                    pet.getPetPicture(), pet.getPersonalityTraits(), pet.isGoodWithKids(),
                    pet.isGoodWithOtherAnimals(), id);

            if (rowsAffected == 0)
            {
                throw new DaoException("Zero rows affected, expected at least one");
            }
            else
            {
                updatedPet = getPetById(pet.getId());
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
        return updatedPet;
    }

    private Pet mapRowToPet(SqlRowSet results){
        Pet pet = new Pet();
        pet.setAdopted(results.getBoolean("adopted"));
        pet.setAge(results.getInt("pet_age"));
        pet.setGender(results.getString("pet_gender"));
        pet.setGoodWithKids(results.getBoolean("good_with_kids"));
        pet.setGoodWithOtherAnimals(results.getBoolean("good_with_other_animals"));
        pet.setId(results.getInt("pet_id"));
        pet.setPetPicture(results.getString("pet_picture"));
        pet.setName(results.getString("pet_name"));
        pet.setPersonalityTraits(results.getString("personality_traits"));
        pet.setSpecialNeeds(results.getString("pet_special_needs"));
        pet.setType(results.getString("pet_type"));
        return pet;
    }
    private Pet mapRowToPetWithoutId(SqlRowSet results){
        Pet pet = new Pet();
        pet.setAdopted(results.getBoolean("adopted"));
        pet.setAge(results.getInt("pet_age"));
        pet.setGender(results.getString("pet_gender"));
        pet.setGoodWithKids(results.getBoolean("good_with_kids"));
        pet.setGoodWithOtherAnimals(results.getBoolean("good_with_other_animals"));
        pet.setPetPicture(results.getString("pet_picture"));
        pet.setName(results.getString("pet_name"));
        pet.setPersonalityTraits(results.getString("personality_traits"));
        pet.setSpecialNeeds(results.getString("pet_special_needs"));
        pet.setType(results.getString("pet_type"));
        return pet;
    }
}
