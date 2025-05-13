package model.Dao;

import model.entities.Pet;
import model.Enum.PetGender;
import model.Enum.PetType;

import java.util.List;

public interface PetDao {
    void insert(Pet obj);
    void update(Pet obj);
    void deleteById(Integer id);
    Pet findById(Integer id);
    Pet findByName(String name);
    Pet findByType(PetType type);
    Pet findByGender(PetGender gender);
    List<Pet> findAll();
    Pet findByCity(String city);
    Pet findByAge(Integer age);
    Pet findByWeight(Double weight);
}