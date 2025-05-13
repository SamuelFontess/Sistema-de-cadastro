package main.java;

import services.CadastroPet;
import services.PrintMenu;
import java.util.Scanner;  // Importar o Scanner

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PrintMenu pm = new PrintMenu(scanner);
        int option;

        do {
            option = pm.printarMenuPrincipal();

            switch (option) {
                case 1:
                    CadastroPet.createPet();
                    System.exit(0);
                    break;
                case 2:
                    System.out.println("2. Listar pets por algum critério (nome, tipo, gênero, (idade, peso, cidade - implementar)");

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

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