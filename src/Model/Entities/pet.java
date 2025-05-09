package Model.Entities;

public class pet {
    private String petName;
    private String petSurname;
    private petType petType;
    private petEnum petGender;
    private petAddress petAddress;
    private float petAge;
    private float petWeight;
    private String petBreed;
    private int id;

    public pet() {
    }

    public pet(String petName, String petSurname, String petBreed, float petWeight, float petAge, petAddress petAddress, petEnum petGender, petType petType) {
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

    public petType getPetType() {
        return petType;
    }

    public void setPetType(petType petType) {
        this.petType = petType;
    }

    public petEnum getPetGender() {
        return petGender;
    }

    public void setPetGender(petEnum petGender) {
        this.petGender = petGender;
    }

    public petAddress getPetAddress() {
        return petAddress;
    }

    public void setPetAddress(petAddress petAddress) {
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
