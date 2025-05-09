package Model.Dao;

import Model.Entities.*;
import db.DB;
import db.DbException;
import db.DbIntegrityException;
import Model.Entities.pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class petDaoJDBC implements petDao {
    private Connection conn;

    public petDaoJDBC(Connection connection) {
        this.conn = DB.getConnection();
    }

    private pet instantiatePet(ResultSet rs) throws SQLException {
        pet pet = new pet();
        petAddress address = new petAddress();

        pet.setId(rs.getInt("Id"));
        pet.setPetName(rs.getString("nome"));
        pet.setPetSurname(rs.getString("sobrenome"));
        pet.setPetType(petType.valueOf(rs.getString("tipo_pet")));
        pet.setPetGender(petEnum.valueOf(rs.getString("sexo")));
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
    public void insert(pet obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO cadastros " +
                            "(nome, sobrenome, tipo_pet, sexo, rua, numero_casa, cidade, idade, peso, raca) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

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
    public void update(pet obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE cadastros " +
                            "SET nome = ?, " +
                            "sobrenome = ?, " +
                            "tipo_pet = ?, " +
                            "sexo = ?, " +
                            "rua = ?, " +
                            "numero_casa = ?, " +
                            "cidade = ?, " +
                            "idade = ?, " +
                            "peso = ?, " +
                            "raca = ? " +
                            "WHERE id = ?");

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
            st = conn.prepareStatement(
                    "DELETE FROM cadastros WHERE id = ?");

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
    public pet findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT * FROM cadastros WHERE id = ?");

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                pet obj = instantiatePet(rs);
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
    public pet findByName(String name) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT * FROM cadastros WHERE nome = ?");

            st.setString(1, name);
            rs = st.executeQuery();

            if (rs.next()) {
                pet obj = instantiatePet(rs);
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
    public pet findByType(petType type) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT * FROM cadastros WHERE tipo_pet = ?");

            st.setString(1, type.toString().toLowerCase());
            rs = st.executeQuery();

            if (rs.next()) {
                pet obj = instantiatePet(rs);
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
    public pet findByGender(petEnum gender) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT * FROM cadastros WHERE sexo = ?");

            st.setString(1, gender.toString().toLowerCase());
            rs = st.executeQuery();

            if (rs.next()) {
                pet obj = instantiatePet(rs);
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
    public List<pet> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT * FROM cadastros ORDER BY nome");

            rs = st.executeQuery();

            List<pet> list = new ArrayList<>();

            while (rs.next()) {
                pet obj = instantiatePet(rs);
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
