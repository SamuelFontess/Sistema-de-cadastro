package services;

import db.DB;
import model.Dao.PetDao;
import model.Dao.PetDaoJDBC;
import model.entities.Pet;
import utils.Validator;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class DeletarPet {
    public static void deletarPet(){
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

        pets.forEach(pet -> System.out.printf("%-3d| %-14s| %-10s| %s%n",  //lambda pra printar cada elemento da lista
                pet.getId(),
                pet.getPetName() + " " + pet.getPetSurname(),
                pet.getPetType(),
                pet.getPetGender()));

        int id;
        while (true) {
            System.out.print("\nDigite o ID do pet que deseja deletar: ");
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

        System.out.print("Tem certeza que deseja deletar o pet '"
                + pet.getPetName() + " " + pet.getPetSurname() + "'? (s/n): "); //verificação antes de apagar

        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("s")) {
            try {
                petDao.deleteById(id);
                System.out.println("Pet deletado com sucesso!");
            } catch (Exception e) {
                System.out.println("Erro ao deletar o pet: " + e.getMessage());
            }
        } else {
            System.out.println("Operação cancelada.");
        }

        sc.close();
    }
}
