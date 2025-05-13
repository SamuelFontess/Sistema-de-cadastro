package services;

import model.Dao.PetDaoJDBC;
import model.entities.Pet;
import model.entities.PetAddress;
import utils.Validator;
import db.DB;

import java.util.Scanner;

public class CadastroPet {
    public static void createPet(){
        Scanner sc = new Scanner(System.in);

        PetDaoJDBC petDaoJDBC = new PetDaoJDBC(DB.getConnection());

        Pet pet = new Pet();
        PetAddress petAddress = new PetAddress();

        System.out.println("digite o nome do pet: ");
        pet.setPetName(sc.nextLine());

        System.out.println("digite o sobrenome do pet: ");
        pet.setPetSurname(sc.nextLine());

        System.out.println("digite o tipo do pet: 1 = cachorro | 2 = gato ");
        pet.setPetType(Validator.typevalid(sc));
        sc.nextLine();

        System.out.println("digite o sexo do pet: 1 = masculino | 2 = feminino ");
        pet.setPetGender(Validator.sexvalid(sc));
        sc.nextLine();

        System.out.println("digite o endereço do pet: ");
        System.out.println("rua onde foi encontrado: ");
        petAddress.setStreet(sc.nextLine());

        System.out.print("Número: ");
        petAddress.setNumber(sc.nextInt());
        sc.nextLine();


        System.out.print("cidade onde foi encontrado: ");
        petAddress.setCity(sc.nextLine());

        pet.setPetAddress(petAddress);

        System.out.println("digite a idade do pet: ");
        pet.setPetAge(Validator.agevalid(sc));
        sc.nextLine();

        System.out.println("digite o peso do pet: ");
        pet.setPetWeight(Validator.weightvalid(sc));
        sc.nextLine();

        System.out.println("digite a raça do pet: ");
        pet.setPetBreed(sc.nextLine());
        petDaoJDBC.insert(pet);

        System.out.println("pet cadastrado com sucesso!");
        sc.close();
    }
}
