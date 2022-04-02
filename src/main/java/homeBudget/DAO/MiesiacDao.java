package homeBudget.DAO;

import homeBudget.model.Miesiac;
import homeBudget.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MiesiacDao {
    private final String FIND_ALL_MONTHS_QUERY = "SELECT * FROM miesiace.miesiac;";

    public List<Miesiac> miesiacList(){
        try(Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_MONTHS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            List<Miesiac> miesiacArrayList = new ArrayList<>();
            while (resultSet.next()) {
                Miesiac miesiac = new Miesiac(
                        resultSet.getInt(1),
                        resultSet.getString("nazwa_miesiaca")
                );
                miesiacArrayList.add(miesiac);
            }
            return miesiacArrayList;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
