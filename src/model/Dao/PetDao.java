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
    List<Pet> findByType(String tipoPet);
    List<Pet> findByGender(String gender);
    List<Pet> findAll();
    Pet findByCity(String city);
    List<Pet> findByAge(int minAge, int maxAge);
    List<Pet> findByWeight(double minWeight, double maxWeight);
}