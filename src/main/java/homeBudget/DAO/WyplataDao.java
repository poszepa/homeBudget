package homeBudget.DAO;

import homeBudget.model.Wyplata;
import homeBudget.model.Wydatek;
import homeBudget.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WyplataDao {

    public Double getWyplata(String nazwaBazy) {
        String GET_WYPLATA_QUERY = "SELECT SUM(wyplata) AS SUMA FROM "+ nazwaBazy+".wyplata;";
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_WYPLATA_QUERY);
            ResultSet resultSet = statement.executeQuery();
            double wyplata = 0;
            while (resultSet.next()) {
                wyplata += resultSet.getDouble("SUMA");
            }
            return wyplata;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    public Wyplata addWyplata(Wyplata wyplata, String nazwaBazy) {
        String ADD_WYPLATA_QUERY = "INSERT INTO " + nazwaBazy + ".wyplata(wyplata, opis, data_dodania) VALUES(? ,? , CURRENT_TIMESTAMP);";
        try(Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD_WYPLATA_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setDouble(1,wyplata.getWyplata());
            statement.setString(2, wyplata.getOpis());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                wyplata.setId(id);
            }
            return wyplata;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    public List<Wyplata> findAllSalary(String nazwaBazy) {
        String FIND_ALL_SALARY_QUERY = "SELECT * FROM " + nazwaBazy + ".wyplata;";
        try(Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_SALARY_QUERY);
            ResultSet resultSet = statement.executeQuery();
            List<Wyplata> wyplataList = new ArrayList<>();
            while (resultSet.next()) {
                Wyplata wyplata = new Wyplata(
                        resultSet.getInt("id"),
                        resultSet.getDouble("wyplata"),
                        resultSet.getString("opis"),
                        resultSet.getString("data_dodania"));
                wyplataList.add(wyplata);
            }
            return wyplataList;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public Wyplata findSalaryById(int id, String nazwaBazy) {
        String FIND_SALARY_BY_ID = "SELECT * FROM " + nazwaBazy + ".wyplata WHERE id= ?;";
        try(Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_SALARY_BY_ID);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            Wyplata wyplata = new Wyplata();
            while (resultSet.next()) {
                wyplata.setId(resultSet.getInt("id"));
                wyplata.setWyplata(resultSet.getDouble("wyplata"));
                wyplata.setOpis(resultSet.getString("opis"));
                wyplata.setDataDodania(resultSet.getString("data_dodania"));
            }
            return wyplata;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    public void editSalary(Wyplata wyplata , String nazwaBazy) {
        String EDIT_SALARY_QUERY = "UPDATE " + nazwaBazy + ".wyplata SET wyplata = ?, opis = ? WHERE id = ?;";
        try(Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(EDIT_SALARY_QUERY);
            statement.setDouble(1, wyplata.getWyplata());
            statement.setString(2, wyplata.getOpis());
            statement.setInt(3, wyplata.getId());
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSalary(int id , String nazwaBazy) {
        String DELETE_SALARY_QUERY = "DELETE FROM " + nazwaBazy + ".wyplata WHERE id = ?;";
        try(Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_SALARY_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
