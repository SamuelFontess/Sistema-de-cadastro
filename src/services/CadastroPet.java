package services;

import db.DB;
import db.TransactionManager;
import model.Dao.PetDaoJDBC;
import model.entities.Pet;
import model.entities.PetAddress;
import utils.Validator;

import java.sql.Connection;
import java.util.Scanner;

public class CadastroPet {
    public static void createPet() {
        Scanner sc = new Scanner(System.in);

        Pet pet = new Pet();
        PetAddress petAddress = new PetAddress();

        System.out.println("Digite o nome do pet: ");
        String nome = sc.nextLine();
        while (!Validator.isValidName(nome)) {
            System.out.println("Nome inválido. Digite somente letras: ");
            nome = sc.nextLine();
        }
        pet.setPetName(nome);

        System.out.println("Digite o sobrenome do pet: ");
        String sobrenome = sc.nextLine();
        while (!Validator.isValidName(sobrenome)) {
            System.out.println("Sobrenome inválido. Digite somente letras: ");
            sobrenome = sc.nextLine();
        }
        pet.setPetSurname(sobrenome);

        System.out.println("Digite o tipo do pet: 1 = cachorro | 2 = gato ");
        pet.setPetType(Validator.typevalid(sc));

        System.out.println("Digite o sexo do pet: 1 = masculino | 2 = feminino ");
        pet.setPetGender(Validator.sexvalid(sc));

        System.out.println("Digite o endereço do pet:");
        System.out.println("Rua onde foi encontrado: ");
        String rua = sc.nextLine();
        while (rua.isBlank()) {
            System.out.println("Digite novamente: ");
            rua = sc.nextLine();
        }
        petAddress.setStreet(rua);

        petAddress.setNumber(Validator.houseNumberValid(sc));

        System.out.println("Cidade onde foi encontrado: ");
        String cidade = sc.nextLine();
        while (!Validator.isValidCity(cidade)) {
            System.out.println("Cidade inválida: ");
            cidade = sc.nextLine();
        }
        petAddress.setCity(cidade);

        pet.setPetAddress(petAddress);

        pet.setPetAge(Validator.agevalid(sc));

        pet.setPetWeight(Validator.weightvalid(sc));

        System.out.println("Digite a raça do pet: ");
        String raca = sc.nextLine();
        while (raca.isBlank()) {
            System.out.println("Digite novamente: ");
            raca = sc.nextLine();
        }
        pet.setPetBreed(raca);

        Connection conn = DB.getConnection();

        TransactionManager.executeTransaction(conn, connection -> {
            PetDaoJDBC petDaoJDBC = new PetDaoJDBC(connection);
            petDaoJDBC.insert(pet);
        });

        System.out.println("Pet cadastrado com sucesso!");
        sc.close();
    }
}