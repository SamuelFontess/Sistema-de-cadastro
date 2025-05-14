package model.entities;

import model.Enum.PetGender;
import model.Enum.PetType;

public class Pet {
    private String petName;
    private String petSurname;
    private PetType petType;
    private PetGender petGender;
    private PetAddress petAddress;
    private float petAge;
    private float petWeight;
    private String petBreed;
    private int id;

    public Pet() {
    }

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public float getPetWeight() {
        return petWeight;
    }

    public void setPetWeight(float petWeight) {
        this.petWeight = petWeight;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetSurname() {
        return petSurname;
    }

    public void setPetSurname(String petSurname) {
        this.petSurname = petSurname;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public PetGender getPetGender() {
        return petGender;
    }

    public void setPetGender(PetGender petGender) {
        this.petGender = petGender;
    }

    public PetAddress getPetAddress() {
        return petAddress;
    }

    public void setPetAddress(PetAddress petAddress) {
        this.petAddress = petAddress;
    }

    public float getPetAge() {
        return petAge;
    }

    public void setPetAge(float petAge) {
        this.petAge = petAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", petName='" + petName + '\'' +
                ", petSurname='" + petSurname + '\'' +
                ", petType=" + petType +
                ", petGender=" + petGender +
                ", petAddress=" + petAddress +
                ", petAge=" + petAge +
                ", petWeight=" + petWeight +
                ", petBreed='" + petBreed + '\'' +
                '}';
    }
}
