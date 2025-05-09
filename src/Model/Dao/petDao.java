package Model.Dao;

import Model.Entities.pet;
import Model.Entities.petEnum;
import Model.Entities.petType;

import java.util.List;

public interface petDao {
    void insert(pet obj);
    void update(pet obj);
    void deleteById(Integer id);
    pet findById(Integer id);
    pet findByName(String name);
    pet findByType(petType type);
    pet findByGender(petEnum gender);
    List<pet> findAll();
}