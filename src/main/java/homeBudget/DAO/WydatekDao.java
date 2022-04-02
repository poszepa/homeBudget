package homeBudget.DAO;

import homeBudget.model.Wydatek;
import homeBudget.utils.DbUtil;

import java.sql.*;

public class WydatekDao {



    public Wydatek addWydatek(Wydatek wydatek, String nazwaTabeli) {
        String ADD_WYDATEK_QUERY = "INSERT INTO " + nazwaTabeli +" (nazwaWydatku, opisWydatku, kwotaWydatku, dataDodania) VALUES (? , ?, ?, CURRENT_TIMESTAMP);";
        try(Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD_WYDATEK_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1,wydatek.getNazwaWydatku());
            statement.setString(2, wydatek.getOpisWydatku());
            statement.setDouble(3, wydatek.getKwotaWydatku());
            System.out.println(nazwaTabeli);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                wydatek.setId(1);
            }
            return wydatek;

        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
