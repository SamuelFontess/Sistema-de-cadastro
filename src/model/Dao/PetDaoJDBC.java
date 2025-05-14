package model.Dao;

import model.Enum.PetGender;
import model.Enum.PetType;
import model.entities.*;
import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.entities.Pet;
import utils.QueryLoader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDaoJDBC implements PetDao {
    private Connection conn;

    public PetDaoJDBC(Connection connection) {
        this.conn = DB.getConnection();
    }

    private Pet instantiatePet(ResultSet rs) throws SQLException {
        Pet pet = new Pet();
        PetAddress address = new PetAddress();

        pet.setId(rs.getInt("Id"));
        pet.setPetName(rs.getString("nome"));
        pet.setPetSurname(rs.getString("sobrenome"));
        pet.setPetType(PetType.valueOf(rs.getString("tipo_pet")));
        pet.setPetGender(PetGender.valueOf(rs.getString("sexo")));
        pet.setPetAge(rs.getInt("idade"));
        pet.setPetWeight(rs.getFloat("peso"));
        pet.setPetBreed(rs.getString("raca"));

        address.setStreet(rs.getString("rua"));
        address.setNumber(rs.getInt("numero_casa"));
        address.setCity(rs.getString("cidade"));
        pet.setPetAddress(address);

        return pet;
    }


    @Override
    public void insert(Pet obj) {
        PreparedStatement st = null;
        try {
            String query = QueryLoader.getQuery("insert.new.user");
            st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getPetName());                      // nome
            st.setString(2, obj.getPetSurname());                   // sobrenome
            st.setString(3, obj.getPetType().toString());           // tipo_pet
            st.setString(4, obj.getPetGender().toString());         // sexo
            st.setString(5, obj.getPetAddress().getStreet());       // rua
            st.setInt(6, obj.getPetAddress().getNumber());          // numero da casa
            st.setString(7, obj.getPetAddress().getCity());         // cidade
            st.setFloat(8, obj.getPetAge());                        // idade
            st.setFloat(9, obj.getPetWeight());                     // peso
            st.setString(10, obj.getPetBreed());                    // raça

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
            } else {
                throw new DbException("Unexpected error! No rows affected!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Pet obj) {
        PreparedStatement st = null;
        try {
            String query = QueryLoader.getQuery("update.users");
            st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getPetName());
            st.setString(2, obj.getPetSurname());
            st.setString(3, obj.getPetType().toString());
            st.setString(4, obj.getPetGender().toString());
            st.setString(5, obj.getPetAddress().getStreet());
            st.setInt(6, obj.getPetAddress().getNumber());
            st.setString(7, obj.getPetAddress().getCity());
            st.setFloat(8, obj.getPetAge());
            st.setFloat(9, obj.getPetWeight());
            st.setString(10, obj.getPetBreed());
            st.setInt(11, obj.getId());

            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            String query = QueryLoader.getQuery("delete.user.by.id");
            st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            st.setInt(1, id);

            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Pet findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String query = QueryLoader.getQuery("find.user.by.id");
            st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Pet obj = instantiatePet(rs);
                return obj;
            }
            return null;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public Pet findByName(String name) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String query = QueryLoader.getQuery("find.user.by.name");
            st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, name.toLowerCase());
            rs = st.executeQuery();

            if (rs.next()) {
                return instantiatePet(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Pet> findByType(String tipoPet) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String query = QueryLoader.getQuery("find.user.by.type");
            st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, tipoPet);  // Passa a string diretamente, sem conversão
            rs = st.executeQuery();

            List<Pet> list = new ArrayList<>();

            while (rs.next()) {
                Pet obj = instantiatePet(rs);
                list.add(obj);
            }

            return list;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Pet> findByGender(String gender) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String query = QueryLoader.getQuery("find.user.by.gender");
            st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, gender);  // Passa a string diretamente (masculino ou feminino)
            rs = st.executeQuery();

            List<Pet> list = new ArrayList<>();

            while (rs.next()) {
                Pet obj = instantiatePet(rs);
                list.add(obj);
            }

            return list;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Pet> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String query = QueryLoader.getQuery("get.all.users");
            st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            rs = st.executeQuery();

            List<Pet> list = new ArrayList<>();

            while (rs.next()) {
                Pet obj = instantiatePet(rs);
                list.add(obj);
            }

            return list;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public Pet findByCity(String city) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String query = QueryLoader.getQuery("find.user.by.city");
            st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, city.toLowerCase());
            rs = st.executeQuery();

            if (rs.next()) {
                return instantiatePet(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Pet> findByAge(int minAge, int maxAge) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String query = QueryLoader.getQuery("find.user.by.age");
            st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            st.setInt(1, minAge);
            st.setInt(2, maxAge);
            rs = st.executeQuery();

            List<Pet> list = new ArrayList<>();

            while (rs.next()) {
                Pet obj = instantiatePet(rs);
                list.add(obj);
            }

            return list;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Pet> findByWeight(double minWeight, double maxWeight) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String query = QueryLoader.getQuery("find.user.by.weight");
            st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            st.setDouble(1, minWeight);
            st.setDouble(2, maxWeight);
            rs = st.executeQuery();

            List<Pet> list = new ArrayList<>();

            while (rs.next()) {
                Pet obj = instantiatePet(rs);
                list.add(obj);
            }

            return list;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

}
