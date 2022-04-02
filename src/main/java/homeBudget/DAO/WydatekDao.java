package homeBudget.DAO;

import homeBudget.model.Wydatek;
import homeBudget.utils.DbUtil;

import java.sql.*;

public class WydatekDao {

    private final String ADD_WYDATEK_QUERY = "INSERT INTO ? (nazwaWydatku, opisWydatku, kwotaWydatku, dataDodania) VALUES (? , ?, ?, CURRENT_TIMESTAMP);";

    public Wydatek addWydatek(Wydatek wydatek, String nazwaTabeli) {
        try(Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD_WYDATEK_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, nazwaTabeli);
            statement.setString(2,wydatek.getNazwaWydatku());
            statement.setString(3, wydatek.getOpisWydatku());
            statement.setDouble(4, wydatek.getKwotaWydatku());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                wydatek.setId(1);
                wydatek.setDataDodania(resultSet.getString("dataDodania"));
            }
            return wydatek;

        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
