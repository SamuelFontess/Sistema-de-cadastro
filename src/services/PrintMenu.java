package services;

import java.util.Scanner;

public class PrintMenu {

    private Scanner input;

    public PrintMenu(Scanner input) {
        this.input = input;
    }

    public int printarMenuPrincipal() {
        System.out.println("\n1. Cadastrar um novo pet");
        System.out.println("2. Listar pets por algum critério (nome, tipo (gato/cachorro), genero (masculino/feminino), idade, peso, cidade )");
        System.out.println("3. Deletar um pet cadastrado");
        System.out.println("4. Listar todos os pets cadastrados");
        System.out.println("5. Alterar os dados do pet cadastrados");
        System.out.println("6. Sair");

        return numberInRange(input);
    }

    public int printarMenuFiltrar() {
        System.out.println("escolha qual opção de filtro para listar");
        System.out.println("1 - Listar pets por nome");
        System.out.println("2 - Listar pets por tipo (gato/cachorro)");
        System.out.println("3 - Listar pets por genero (masculino/feminino)");
        System.out.println("4 - Listar pets por idade");
        System.out.println("5 - Listar pets por peso");
        System.out.println("6 - Listar pets por cidade");

        return numberInRange(input);
    }

    public static int numberInRange(Scanner input) {
        while (true) {
            System.out.print("Digite um número de 1 a 6: ");

            if (input.hasNextInt()) {
                int num = input.nextInt();
                input.nextLine();
                if (num >= 1 && num <= 6) {
                    return num;
                } else {
                    System.out.println("Número fora do intervalo. Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida. Digite apenas números.");
                input.nextLine();
            }
        }
    }
}
