package homeBudget.DAO;

import homeBudget.model.Wydatek;
import homeBudget.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
