package homeBudget.DAO;

import homeBudget.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreatorDao {
    private final String CREATE_DB_QUERY = "CREATE DATABASE ? CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;\n";
    private final String CREATE_TABLE_QUERY = "CREATE TABLE wyplata(\n" +
            "    id INT AUTO_INCREMENT,\n" +
            "    wyplata DOUBLE,\n" +
            "    PRIMARY KEY (id)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE kieszonkowe(\n" +
            "    id INT AUTO_INCREMENT,\n" +
            "    nazwaWydatku VARCHAR(50),\n" +
            "    opisWydatku VARCHAR(50),\n" +
            "    kwotaWydatku DOUBLE,\n" +
            "    dataDodania DATE,\n" +
            "    PRIMARY KEY (id)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE zobowiazania(\n" +
            "                                   id INT AUTO_INCREMENT,\n" +
            "                                   nazwaWydatku VARCHAR(50),\n" +
            "                                   opisWydatku VARCHAR(50),\n" +
            "                                   kwotaWydatku DOUBLE,\n" +
            "                                   dataDodania DATE,\n" +
            "                                   PRIMARY KEY (id)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE potrzeby_codzienne(\n" +
            "                            id INT AUTO_INCREMENT,\n" +
            "                            nazwaWydatku VARCHAR(50),\n" +
            "                            opisWydatku VARCHAR(50),\n" +
            "                            kwotaWydatku DOUBLE,\n" +
            "                            dataDodania DATE,\n" +
            "                            PRIMARY KEY (id)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE podarunki(\n" +
            "                                   id INT AUTO_INCREMENT,\n" +
            "                                   nazwaWydatku VARCHAR(50),\n" +
            "                                   opisWydatku VARCHAR(50),\n" +
            "                                   kwotaWydatku DOUBLE,\n" +
            "                                   dataDodania DATE,\n" +
            "                                   PRIMARY KEY (id)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE dom(\n" +
            "                                   id INT AUTO_INCREMENT,\n" +
            "                                   nazwaWydatku VARCHAR(50),\n" +
            "                                   opisWydatku VARCHAR(50),\n" +
            "                                   kwotaWydatku DOUBLE,\n" +
            "                                   dataDodania DATE,\n" +
            "                                   PRIMARY KEY (id)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE ubezpieczenie(\n" +
            "                                   id INT AUTO_INCREMENT,\n" +
            "                                   nazwaWydatku VARCHAR(50),\n" +
            "                                   opisWydatku VARCHAR(50),\n" +
            "                                   kwotaWydatku DOUBLE,\n" +
            "                                   dataDodania DATE,\n" +
            "                                   PRIMARY KEY (id)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE technologia(\n" +
            "                                   id INT AUTO_INCREMENT,\n" +
            "                                   nazwaWydatku VARCHAR(50),\n" +
            "                                   opisWydatku VARCHAR(50),\n" +
            "                                   kwotaWydatku DOUBLE,\n" +
            "                                   dataDodania DATE,\n" +
            "                                   PRIMARY KEY (id)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE transport(\n" +
            "                                   id INT AUTO_INCREMENT,\n" +
            "                                   nazwaWydatku VARCHAR(50),\n" +
            "                                   opisWydatku VARCHAR(50),\n" +
            "                                   kwotaWydatku DOUBLE,\n" +
            "                                   dataDodania DATE,\n" +
            "                                   PRIMARY KEY (id)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE podroze(\n" +
            "                                   id INT AUTO_INCREMENT,\n" +
            "                                   nazwaWydatku VARCHAR(50),\n" +
            "                                   opisWydatku VARCHAR(50),\n" +
            "                                   kwotaWydatku DOUBLE,\n" +
            "                                   dataDodania DATE,\n" +
            "                                   PRIMARY KEY (id)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE media(\n" +
            "                                   id INT AUTO_INCREMENT,\n" +
            "                                   nazwaWydatku VARCHAR(50),\n" +
            "                                   opisWydatku VARCHAR(50),\n" +
            "                                   kwotaWydatku DOUBLE,\n" +
            "                                   dataDodania DATE,\n" +
            "                                   PRIMARY KEY (id)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE oszczednosci(\n" +
            "                                   id INT AUTO_INCREMENT,\n" +
            "                                   nazwaWydatku VARCHAR(50),\n" +
            "                                   opisWydatku VARCHAR(50),\n" +
            "                                   kwotaWydatku DOUBLE,\n" +
            "                                   dataDodania DATE,\n" +
            "                                   PRIMARY KEY (id)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE zdrowie(\n" +
            "                                   id INT AUTO_INCREMENT,\n" +
            "                                   nazwaWydatku VARCHAR(50),\n" +
            "                                   opisWydatku VARCHAR(50),\n" +
            "                                   kwotaWydatku DOUBLE,\n" +
            "                                   dataDodania DATE,\n" +
            "                                   PRIMARY KEY (id)\n" +
            ");";


    public void createDB(String dbName) {
        try(Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(CREATE_DB_QUERY);
            statement.setString(1, dbName);
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        try(Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(CREATE_TABLE_QUERY);
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
