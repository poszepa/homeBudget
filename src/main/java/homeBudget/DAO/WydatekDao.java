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

    public List<String> nazwaWydatkow(String nazwaBazy) {
        List<String> nazwyWydatkowBazy = new ArrayList<>();
        nazwyWydatkowBazy.add("dom");
        nazwyWydatkowBazy.add("kieszonkowe");
        nazwyWydatkowBazy.add("media");
        nazwyWydatkowBazy.add("oszczednosci");
        nazwyWydatkowBazy.add("podarunki");
        nazwyWydatkowBazy.add("podroze");
        nazwyWydatkowBazy.add("potrzeby_codzienne");
        nazwyWydatkowBazy.add("technologia");
        nazwyWydatkowBazy.add("transport");
        nazwyWydatkowBazy.add("ubezpieczenie");
        nazwyWydatkowBazy.add("zdrowie");
        nazwyWydatkowBazy.add("zobowiazania");
        return nazwyWydatkowBazy;
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
        List<Double> sumaWydatkow = new ArrayList<>();
        if (nazwyWydatkow.size() == 0) {
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

    public Wydatek findWydatekById(int idWydatku, String nazwaBazy, String kateogria) {
        String FIND_WYDATEK_BY_ID_QUERY = "SELECT * FROM " +nazwaBazy+"."+kateogria +"  WHERE id = ?;";
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_WYDATEK_BY_ID_QUERY);
            statement.setInt(1, idWydatku);
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
//UPDATE kwiecien2022.dom SET nazwaWydatku = 'dupa', opisWydatku = 'dupa', kwotaWydatku = 10.0 WHERE id = 1;
    public void editWydatekById(int idWydatku, String nazwaBazy, String kateogria, Wydatek wydatek) {
        System.out.println(nazwaBazy);
        System.out.println(kateogria);
        String UPDATE_BY_ID_QUERY = "UPDATE " + nazwaBazy+ "." + kateogria + " SET nazwaWydatku = ?, opisWydatku = ?, kwotaWydatku = ? WHERE id = ?;";
        try(Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID_QUERY);
            statement.setString(1, wydatek.getNazwaWydatku());
            statement.setString(2, wydatek.getOpisWydatku());
            statement.setDouble(3, wydatek.getKwotaWydatku());
            statement.setInt(4, idWydatku);
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void usunWydatekById(int idWydatku, String nazwaBazy, String kateogria) {
        String UPDATE_BY_ID_QUERY = "DELETE FROM " + nazwaBazy+ "." + kateogria + " WHERE id = ?;";
        try(Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID_QUERY);
            statement.setInt(1, idWydatku);
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}





