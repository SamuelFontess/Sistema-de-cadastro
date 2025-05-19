package services;

import db.DB;
import db.TransactionManager;
import model.Dao.PetDao;
import model.Dao.PetDaoJDBC;
import model.entities.Pet;
import utils.Validator;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class DeletarPet {
    public static void deletarPet() {
        Scanner sc = new Scanner(System.in);
        Connection conn = DB.getConnection();

        try {
            TransactionManager.executeTransaction(conn, connection -> {
                PetDao petDao = new PetDaoJDBC(connection);
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

                Pet pet = null;
                int id = -1;

                while (true) {
                    System.out.print("\nDigite o ID do pet que deseja deletar: ");
                    String input = sc.nextLine();

                    if (Validator.isValidInteger(input)) {
                        id = Integer.parseInt(input);
                        pet = petDao.findById(id);
                        if (pet != null) break;
                        else System.out.println("Nenhum pet encontrado com esse ID.");
                    } else {
                        System.out.println("ID inválido. Digite um número inteiro.");
                    }
                }

                System.out.printf("Tem certeza que deseja deletar o pet '%s %s'? (s/n): ",
                        pet.getPetName(), pet.getPetSurname());

                String confirm;
                while (true) {
                    confirm = sc.nextLine().trim().toLowerCase();
                    if (confirm.equals("s")) {
                        petDao.deleteById(id);
                        System.out.println("Pet deletado com sucesso!");
                        break;
                    } else if (confirm.equals("n")) {
                        System.out.println("Operação cancelada.");
                        break;
                    } else {
                        System.out.print("Por favor, digite 's' para sim ou 'n' para não: ");
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("Erro ao deletar o pet: " + e.getMessage());
        } finally {
            DB.closeConnection();
            sc.close();
        }
    }
}
