package model.Dao;

import model.entities.Pet;
import model.entities.PetEnum;
import model.entities.PetType;

import java.util.List;

public interface PetDao {
    void insert(Pet obj);
    void update(Pet obj);
    void deleteById(Integer id);
    Pet findById(Integer id);
    Pet findByName(String name);
    Pet findByType(PetType type);
    Pet findByGender(PetEnum gender);
    List<Pet> findAll();
}