package services;

import db.DB;
import model.Dao.PetDao;
import model.Dao.PetDaoJDBC;
import model.entities.Pet;

import java.sql.Connection;
import java.util.List;

public class ListarAllPets {
    public static void ListarAllPets(){
        Connection conn = DB.getConnection();
        PetDao petDao = new PetDaoJDBC(conn);


        List<Pet> pets = petDao.findAll();

        System.out.println();
        System.out.println("Listando todos os pets cadastrados...");

        if(pets.isEmpty()){
            System.out.println("Nenhum pet cadastrado.");
        }else{
            pets.forEach(System.out::println);
        }
        System.out.println("Fim da listagem de todos os pets cadastrados.");
        System.out.println("-------------------------------------------");
    }
}
