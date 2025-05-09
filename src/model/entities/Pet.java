package model.entities;

public class Pet {
    private String petName;
    private String petSurname;
    private PetType petType;
    private PetEnum petGender;
    private PetAddress petAddress;
    private float petAge;
    private float petWeight;
    private String petBreed;
    private int id;

    public Pet() {
    }

    public Pet(String petName, String petSurname, String petBreed, float petWeight, float petAge, PetAddress petAddress, PetEnum petGender, PetType petType) {
        this.petName = petName;
        this.petSurname = petSurname;
        this.petBreed = petBreed;
        this.petWeight = petWeight;
        this.petAge = petAge;
        this.petAddress = petAddress;
        this.petGender = petGender;
        this.petType = petType;
        this.id = id;
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

    public PetEnum getPetGender() {
        return petGender;
    }

    public void setPetGender(PetEnum petGender) {
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
}
