package main;

import services.CadastroPet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcao = 0;

        do {
            System.out.println("\n--- MENU PET ---");
            System.out.println("1. Cadastrar um novo pet");
            System.out.println("2. Alterar os dados do pet cadastrado");
            System.out.println("3. Deletar um pet cadastrado");
            System.out.println("4. Listar todos os pets cadastrados");
            System.out.println("5. Listar pets por critério (idade, nome, raça)");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            if (sc.hasNextLine()) {
                String entrada = sc.nextLine();
                try {
                    opcao = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Digite um número.");
                    opcao = -1;
                    continue;
                }
            } else {
                System.out.println("Nenhuma linha encontrada. Encerrando.");
                break;
            }

            switch (opcao) {
                case 1:
                CadastroPet.createPet();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 6);

        sc.close();
    }
}