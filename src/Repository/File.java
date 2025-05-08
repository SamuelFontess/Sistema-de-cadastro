package Repository;

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

    }
}