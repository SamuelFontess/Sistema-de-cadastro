package Services;

import Model.Dao.petDaoJDBC;
import Model.Entities.pet;
import Model.Entities.petAddress;
import Utils.validator;
import Model.Dao.petDao;
import db.DB;

import java.util.Scanner;

public class cadastropet {
    public static void createPet(){
        Scanner sc = new Scanner(System.in);

        petDaoJDBC petDaoJDBC = new petDaoJDBC(DB.getConnection());

        pet pet = new pet();
        petAddress petAddress = new petAddress();

        System.out.println("digite o nome do pet: ");
        pet.setPetName(sc.nextLine());

        System.out.println("digite o sobrenome do pet: ");
        pet.setPetSurname(sc.nextLine());

        System.out.println("digite o tipo do pet: 1 = cachorro | 2 = gato ");
        pet.setPetType(validator.typevalid(sc));
        sc.nextLine();

        System.out.println("digite o sexo do pet: 1 = masculino | 2 = feminino ");
        pet.setPetGender(validator.sexvalid(sc));
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
        pet.setPetAge(validator.agevalid(sc));
        sc.nextLine();

        System.out.println("digite o peso do pet: ");
        pet.setPetWeight(validator.weightvalid(sc));
        sc.nextLine();

        System.out.println("digite a raça do pet: ");
        pet.setPetBreed(sc.nextLine());
        petDaoJDBC.insert(pet);

        System.out.println("pet cadastrado com sucesso!");
        sc.close();



    }
}
