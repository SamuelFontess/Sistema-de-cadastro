package services;

import db.DB;
import model.Dao.PetDao;
import model.Dao.PetDaoJDBC;
import model.entities.Pet;
import utils.Validator;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;


public class ListarPet {
    public static void ListarPet() {
        Scanner scanner = new Scanner(System.in);

        Connection conn = DB.getConnection();
        PetDao petDao = new PetDaoJDBC(conn);

        PrintMenu pm = new PrintMenu(scanner);
        int option;

        do {
            option = pm.printarMenuFiltrar();

            switch (option) {
                case 1:
                    System.out.print("Digite o nome do pet: ");
                    String nome = scanner.nextLine();

                    if (!Validator.isValidName(nome)) {
                        System.out.println("Nome inválido. Tente novamente.");
                        break;
                    }

                    Pet pet = petDao.findByName(nome);

                    if (pet != null) {
                        System.out.println("Pet encontrado: " + pet);
                    } else {
                        System.out.println("Nenhum pet encontrado com esse nome.");
                    }
                    System.exit(0);
                    break;

                case 2:
                    System.out.println("Escolha o tipo de pet:");
                    System.out.println("1 - Cachorro");
                    System.out.println("2 - Gato");
                    int tipoEscolha = scanner.nextInt();
                    scanner.nextLine();

                    String tipo_pet = "";
                    if (tipoEscolha == 1) {
                        tipo_pet = "cachorro";
                    } else if (tipoEscolha == 2) {
                        tipo_pet = "gato";
                    } else {
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                    }

                    List<Pet> petsPorTipo = petDao.findByType(tipo_pet);
                    if (!petsPorTipo.isEmpty()) {
                        System.out.println("Pets encontrados:");
                        petsPorTipo.forEach(System.out::println);
                    } else {
                        System.out.println("Nenhum pet encontrado com esse tipo.");
                    }
                    System.exit(0);
                    break;

                case 3:
                    System.out.println("Escolha o gênero do pet:");
                    System.out.println("1 - Masculino");
                    System.out.println("2 - Feminino");
                    int generoEscolha = scanner.nextInt();
                    scanner.nextLine();

                    String generoPet = "";
                    if (generoEscolha == 1) {
                        generoPet = "masculino";
                    } else if (generoEscolha == 2) {
                        generoPet = "feminino";
                    } else {
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                    }

                    List<Pet> petsPorGenero = petDao.findByGender(generoPet);
                    if (!petsPorGenero.isEmpty()) {
                        System.out.println("Pets encontrados:");
                        petsPorGenero.forEach(System.out::println);
                    } else {
                        System.out.println("Nenhum pet encontrado com esse gênero.");
                    }
                    System.exit(0);
                    break;

                case 4:
                    System.out.println("Digite a faixa etária para filtrar (faixa mínima e máxima):");
                    System.out.print("Idade mínima: ");
                    int idadeMinima = scanner.nextInt();

                    System.out.print("Idade máxima: ");
                    int idadeMaxima = scanner.nextInt();
                    scanner.nextLine();

                    if (!Validator.isValidAgeRange(idadeMinima, idadeMaxima)) {
                        break;
                    }

                    List<Pet> petsPorIdade = petDao.findByAge(idadeMinima, idadeMaxima);
                    if (!petsPorIdade.isEmpty()) {
                        System.out.println("Pets encontrados na faixa etária de " + idadeMinima + " a " + idadeMaxima + ":");
                        petsPorIdade.forEach(System.out::println);
                    } else {
                        System.out.println("Nenhum pet encontrado nessa faixa etária.");
                    }
                    System.exit(0);
                    break;

                case 5:
                    System.out.println("Digite a faixa de peso para filtrar (peso mínimo e máximo):");
                    System.out.print("Peso mínimo: ");
                    double pesoMinimo = scanner.nextDouble();

                    System.out.print("Peso máximo: ");
                    double pesoMaximo = scanner.nextDouble();
                    scanner.nextLine();

                    if (!Validator.isValidWeightRange(pesoMinimo, pesoMaximo)) {
                        break;
                    }

                    List<Pet> petsPorPeso = petDao.findByWeight(pesoMinimo, pesoMaximo);
                    if (!petsPorPeso.isEmpty()) {
                        System.out.println("Pets encontrados no intervalo de peso de " + pesoMinimo + " a " + pesoMaximo + ":");
                        petsPorPeso.forEach(System.out::println);
                    } else {
                        System.out.println("Nenhum pet encontrado nesse intervalo de peso.");
                    }
                    System.exit(0);
                    break;

                case 6:
                    System.out.print("Digite a cidade: ");
                    String cidade = scanner.nextLine();

                    if (!Validator.isValidCity(cidade)) {
                        System.out.println("Cidade inválida.");
                        break;
                    }

                    Pet petByCity = petDao.findByCity(cidade);
                    System.out.println(petByCity != null ? petByCity : "Nenhum pet encontrado com essa cidade.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 6);

        scanner.close();
    }
}
