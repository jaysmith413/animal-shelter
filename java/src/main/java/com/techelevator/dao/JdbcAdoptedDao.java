package com.techelevator.dao;

import com.techelevator.model.Adopted;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcAdoptedDao implements AdoptedDao{

    private JdbcTemplate template;

    public JdbcAdoptedDao(DataSource dataSource)
    {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Adopted> getAdoptedPets()
    {
        String sql = "SELECT * FROM pet_information WHERE adopted = true;";
        SqlRowSet results = template.queryForRowSet(sql);

        List<Adopted> adopt = new ArrayList<>();
        while (results.next()){
            Adopted adopted;
            adopted = mapRowToAdopted(results);

            adopt.add(adopted);
        }
        return adopt;
    }

    private Adopted mapRowToAdopted(SqlRowSet results){
        Adopted adopted = new Adopted();
        adopted.setAdopted(results.getBoolean("adopted"));
        adopted.setAge(results.getInt("pet_age"));
        adopted.setGender(results.getString("pet_gender"));
        adopted.setGoodWithKids(results.getBoolean("good_with_kids"));
        adopted.setGoodWithOtherAnimals(results.getBoolean("good_with_other_animals"));
        adopted.setId(results.getInt("pet_id"));
        adopted.setImage(results.getString("pet_picture"));
        adopted.setName(results.getString("pet_name"));
        adopted.setPersonalityTraits(results.getString("personality_traits"));
        adopted.setSpecialNeeds(results.getString("pet_special_needs"));
        adopted.setType(results.getString("pet_type"));
        return adopted;
    }
}
