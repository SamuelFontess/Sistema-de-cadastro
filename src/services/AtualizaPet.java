package services;

import db.DB;
import model.Dao.PetDao;
import model.Dao.PetDaoJDBC;
import model.entities.Pet;
import utils.Validator;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class AtualizaPet {
    public static void atualizaPet() {

        Scanner sc = new Scanner(System.in);

        Connection conn = DB.getConnection();
        PetDao petDao = new PetDaoJDBC(conn);

        List<Pet> pets = petDao.findAll();

        if (pets.isEmpty()) {
            System.out.println("Nenhum pet cadastrado.");
            return;
        }

        System.out.println("Lista de pets cadastrados:");
        System.out.println("ID |     Nome      | Tipo      | Gênero");
        System.out.println("-------------------------------------------");
        pets.forEach(pet -> System.out.printf("%-3d| %-14s| %-10s| %s%n",
                pet.getId(),
                pet.getPetName() + " " + pet.getPetSurname(),
                pet.getPetType(),
                pet.getPetGender()));

        int id;
        while (true) {
            System.out.print("\nDigite o ID do pet que deseja atualizar: ");
            String input = sc.nextLine();

            if (Validator.isValidInteger(input)) {
                id = Integer.parseInt(input);
                break;
            } else {
                System.out.println("ID inválido. Digite um número inteiro.");
            }
        }

        Pet pet = petDao.findById(id);
        if (pet == null) {
            System.out.println("Nenhum pet encontrado com esse ID.");
            return;
        }

        System.out.println("Informações atuais do pet:");
        System.out.printf("Nome: %s%n", pet.getPetName());
        System.out.printf("Sobrenome: %s%n", pet.getPetSurname());
        System.out.printf("Tipo: %s%n", pet.getPetType());
        System.out.printf("Sexo: %s%n", pet.getPetGender());
        System.out.printf("Idade: %d%n", pet.getPetAge());
        System.out.printf("Peso: %.2f%n", pet.getPetWeight());
        System.out.printf("Raça: %s%n", pet.getPetBreed());
        System.out.printf("Endereço: Rua %s, Nº %d, %s%n",
                pet.getPetAddress().getStreet(),
                pet.getPetAddress().getNumber(),
                pet.getPetAddress().getCity());

        System.out.println("\nDigite as novas informações (deixe em branco para manter):");

        System.out.print("Novo nome: ");
        String nome = sc.nextLine();
        if (!nome.isBlank()) pet.setPetName(nome);

        System.out.print("Novo sobrenome: ");
        String sobrenome = sc.nextLine();
        if (!sobrenome.isBlank()) pet.setPetSurname(sobrenome);

        System.out.println("Escolha o tipo do pet:");
        System.out.println("1 - CACHORRO");
        System.out.println("2 - GATO");
        pet.setPetType(Validator.typevalid(sc));

        System.out.println("Escolha o sexo do pet:");
        System.out.println("1 - MASCULINO");
        System.out.println("2 - FEMININO");
        pet.setPetGender(Validator.sexvalid(sc));

        System.out.print("Nova idade: ");
        String idadeInput = sc.nextLine();
        if (!idadeInput.isBlank()) {
            Scanner tempScanner = new Scanner(idadeInput);
            float idade = Validator.agevalid(tempScanner);
            if (idade > 0) {
                pet.setPetAge(idade);
            }
        }

        System.out.print("Novo peso: ");
        String pesoInput = sc.nextLine();
        if (!pesoInput.isBlank()) {
            Scanner tempScanner = new Scanner(pesoInput);
            float peso = Validator.weightvalid(tempScanner);
            if (peso > 0) {
                pet.setPetWeight(peso);
            }
        }

        System.out.print("Nova raça: ");
        String raca = sc.nextLine();
        if (!raca.isBlank()) pet.setPetBreed(raca);

        System.out.print("Nova rua: ");
        String rua = sc.nextLine();
        if (!rua.isBlank()) pet.getPetAddress().setStreet(rua);

        System.out.print("Novo número da casa: ");
        String numeroInput = sc.nextLine();
        if (!numeroInput.isBlank()) {
            Scanner tempScanner = new Scanner(numeroInput);
            int numero = Validator.houseNumberValid(tempScanner);
            if (numero > 0) {
                pet.getPetAddress().setNumber(numero);
            }
        }

        System.out.print("Nova cidade: ");
        String cidade = sc.nextLine();
        if (!cidade.isBlank()) {
            if (Validator.isValidCity(cidade)) {
                pet.getPetAddress().setCity(cidade);
            } else {
                System.out.println("Nome de cidade inválido.");
            }
        }

        try {
            petDao.update(pet);
            System.out.println("\nPet atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o pet: " + e.getMessage());
        }
    }
}