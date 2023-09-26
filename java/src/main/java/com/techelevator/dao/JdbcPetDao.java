package com.techelevator.dao;

import com.techelevator.model.Pet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

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
        String sql = "SELECT * from pet_information;";
        SqlRowSet results = template.queryForRowSet(sql);

        List<Pet> pets = new ArrayList<>();
        while(results.next()) {
            Pet pet = new Pet();
            pet = mapRowToPet(results);

            pets.add(pet);
        }
        return pets;
    }

    private Pet mapRowToPet(SqlRowSet results){
        Pet pet = new Pet();
        pet.setAdopted(results.getBoolean("adopted"));
        pet.setAge(results.getInt("pet_age"));
        pet.setGender(results.getString("pet_gender"));
        pet.setGoodWithKids(results.getBoolean("good_with_kids"));
        pet.setGoodWithOtherAnimals(results.getBoolean("good_with_other_animals"));
        pet.setId(results.getInt("pet_id"));
        pet.setImage(results.getString("pet_picture"));
        pet.setName(results.getString("pet_name"));
        pet.setPersonalityTraits(results.getString("personality_traits"));
        pet.setSpecialNeeds(results.getString("pet_special_needs"));
        pet.setType(results.getString("pet_type"));
        return pet;
    }
}
