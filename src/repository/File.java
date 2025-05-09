package repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File {
    public static void readFile(){
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\samuc\\IdeaProjects\\Sistema de Cadastro\\src\\Data\\formulario.txt"))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        /* ler as perguntas:

        1 - Qual o nome e sobrenome do pet?
2 - Qual o tipo do pet (Cachorro/Gato)
3 - Qual o sexo do animal?
4 - Qual endereço e bairro que ele foi encontrado?
5 - Qual a idade aproximada do pet?
6 - Qual o peso aproximado do pet?
7 - Qual a raça do pet??
         */

    }
}