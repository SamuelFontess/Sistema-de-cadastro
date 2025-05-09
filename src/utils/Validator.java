package utils;

import model.entities.PetEnum;
import model.entities.PetType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
    public static PetType typevalid(Scanner sc) {
        try {
            System.out.print("Digite um número: ");
            int numValido = sc.nextInt();
            switch (numValido) {
                case 1:
                    return PetType.cachorro;
                case 2:
                    return PetType.gato;
                default:
                    throw new IllegalArgumentException("Número inválido. Use 1 para cachorro ou 2 para gato.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Digite um número valido.");
            sc.nextLine();
            return typevalid(sc);
        }
    }

    public static PetEnum sexvalid(Scanner sc) {
        try {
            System.out.print("Digite um número: ");
            int numValido = sc.nextInt();
            switch (numValido) {
                case 1:
                    return PetEnum.masculino;
                case 2:
                    return PetEnum.feminino;
                default:
                    throw new IllegalArgumentException("Número inválido. Use 1 para cachorro ou 2 para gato.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Digite um número valido.");
            sc.nextLine();
            return sexvalid(sc);
        }
    }

    public static float agevalid(Scanner sc) {
        try {
            float idade = sc.nextFloat();
            if (idade <= 0 || idade > 20) {
                throw new IllegalArgumentException("Idade inválida. Deve estar entre 1 e 20.");
            }
            return idade;
        } catch (NumberFormatException e) {
            System.out.println("Erro: Entrada inválida! Digite um número.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public static float weightvalid(Scanner sc) {
        try {
            float numValido = sc.nextFloat();
            if (numValido <= 0 || numValido > 60) {
                throw new IllegalArgumentException("Peso inválido. Deve ser maior que 0kg e menor ou igual a 60kg.");
            }
            return numValido;
        } catch (NumberFormatException e) {
            System.out.println("Erro: Entrada inválida! Digite um número.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
