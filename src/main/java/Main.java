package main.java;

import services.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PrintMenu pm = new PrintMenu(scanner);
        int option;

        do {
            option = pm.printarMenuPrincipal();  // printa o menu inicial do programa

            switch (option) {
                case 1:
                    CadastroPet.createPet();
                    System.exit(0);
                    break;
                case 2:
                    ListarPetFiltros.ListarPetFiltros();
                    break;
                case 3:
                    DeletarPet.deletarPet();
                    System.exit(0);
                    break;
                case 4:
                    ListarAllPets.ListarAllPets();
                    System.exit(0);
                    break;
                case 5:
                    AtualizaPet.atualizaPet();
                    break;
                case 6:
                    System.out.println("Fechando programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 6);

        scanner.close();
    }
}