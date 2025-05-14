package utils;

import model.Enum.PetGender;
import model.Enum.PetType;

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

    public static PetGender sexvalid(Scanner sc) {
        try {
            System.out.print("Digite um número: ");
            int numValido = sc.nextInt();
            switch (numValido) {
                case 1:
                    return PetGender.masculino;
                case 2:
                    return PetGender.feminino;
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
            if (numValido <= 0 || numValido > 70) {
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

    public static boolean isValidName(String name) {
        return name != null && name.matches("^[A-Za-zÀ-ÿ\\s]{2,30}$");
    }

    public static boolean isValidCity(String city) {
        return city != null && city.matches("^[A-Za-zÀ-ÿ\\s]{2,50}$");
    }

    public static boolean isValidAgeRange(int minAge, int maxAge) {
        if (minAge > maxAge) {
            System.out.println("A idade mínima não pode ser maior que a idade máxima.");
            return false;
        }

        if (minAge < 0 || maxAge < 0 || minAge > 20 || maxAge > 20) {
            System.out.println("As idades devem estar entre 0 e 20.");
            return false;
        }

        return true;
    }

    public static boolean isValidWeightRange(double minWeight, double maxWeight) {
        if (minWeight > maxWeight) {
            System.out.println("O peso mínimo não pode ser maior que o peso máximo.");
            return false;
        }

        if (minWeight < 0 || maxWeight < 0 || minWeight > 70 || maxWeight > 70) {
            System.out.println("Os pesos devem estar entre 0 e 70.");
            return false;
        }

        return true;
    }

    public static boolean isValidInteger(String input) {
        if (input == null || input.isEmpty()) return false;
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
