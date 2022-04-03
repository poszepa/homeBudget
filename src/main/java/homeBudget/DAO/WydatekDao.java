package homeBudget.DAO;

import homeBudget.model.Wydatek;
import homeBudget.utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WydatekDao {


    public Wydatek addWydatek(Wydatek wydatek, String nazwaTabeli) {
        String ADD_WYDATEK_QUERY = "INSERT INTO " + nazwaTabeli + " (nazwaWydatku, opisWydatku, kwotaWydatku, dataDodania) VALUES (? , ?, ?, CURRENT_TIMESTAMP);";
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD_WYDATEK_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, wydatek.getNazwaWydatku());
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

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<String> nazwaWydatkow(String nazwaBazy) {
        String ADD_WYDATEK_QUERY = "SHOW TABLES FROM " + nazwaBazy + ";";
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD_WYDATEK_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.executeQuery();
            List<String> stringList = new ArrayList<>();
            while (resultSet.next()) {
                String nazwaKategorii = resultSet.getString(1);
                stringList.add(nazwaKategorii);
            }
            return stringList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Wydatek> getWydatekList(String nazwaBazy) {
        List<Wydatek> wydatekArrayList = new ArrayList<>();
        String LIST_WYDATKOW = "SELECT * FROM " + nazwaBazy + " ORDER BY dataDodania;";
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(LIST_WYDATKOW);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Wydatek wydatek = new Wydatek(
                        resultSet.getInt("id"),
                        resultSet.getString("nazwaWydatku"),
                        resultSet.getString("opisWydatku"),
                        resultSet.getDouble("kwotaWydatku"),
                        resultSet.getString("dataDodania")
                );
                wydatekArrayList.add(wydatek);
            }
            return wydatekArrayList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Double> sumaWydatkow(String nazwaBazy) {
        List<String> nazwyWydatkow = nazwaWydatkow(nazwaBazy);
        System.out.println(nazwaBazy);
        System.out.println(nazwyWydatkow);
        List<Double> sumaWydatkow = new ArrayList<>();
        if(nazwyWydatkow.size() == 0) {
            return null;
        }
        for (int i = 0; i < nazwyWydatkow.size(); i++) {
            double sum = 0;
            try (Connection connection = DbUtil.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + nazwaBazy + "." + nazwyWydatkow.get(i) + ";");
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    sum += (resultSet.getDouble(4));
                }
                sumaWydatkow.add(sum);
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return sumaWydatkow;

    }

    public Wydatek findWydatekById(int idWydatku, String nazwaBazy, String kategoria) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + nazwaBazy + "." + kategoria +" WHERE id= " + idWydatku +";");
            ResultSet resultSet = statement.executeQuery();
            Wydatek wydatek = new Wydatek();
            while (resultSet.next()) {
                wydatek.setId(resultSet.getInt("id"));
                wydatek.setNazwaWydatku(resultSet.getString("nazwaWydatku"));
                wydatek.setOpisWydatku(resultSet.getString("opisWydatku"));
                wydatek.setKwotaWydatku(resultSet.getDouble("kwotaWydatku"));
                wydatek.setDataDodania(resultSet.getString("dataDodania"));
            }
            return wydatek;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}





