package homeBudget.DAO;

import homeBudget.model.Miesiac;
import homeBudget.model.Rok;
import homeBudget.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class RokDao {

    private final String FIND_ALL_YEAR_QUERY = "SELECT * FROM miesiace.rok;;";

    public List<Rok> yearList(){
        try(Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_YEAR_QUERY);
            ResultSet resultSet = statement.executeQuery();
            List<Rok> rokList = new ArrayList<>();
            while (resultSet.next()) {
                Rok rok = new Rok(
                        resultSet.getInt(1),
                        resultSet.getInt("rok")
                );
                rokList.add(rok);
            }
            return rokList;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
