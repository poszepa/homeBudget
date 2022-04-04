package homeBudget.DAO;

import homeBudget.utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BazaDanychDao {
    private final String SHOW_ALL_DB = "SELECT * FROM NazwyBazDanych.nazwy_baz_danych;";

    public List<String> bazaDanychList() {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SHOW_ALL_DB);
            List<String> list = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getString("nazwy_baz"));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

