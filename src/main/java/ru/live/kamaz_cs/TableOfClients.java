package ru.live.kamaz_cs;

import java.sql.*;

public class TableOfClients {

    private static final String DB_CONNECTION = "jdbc:mysql://localhost/HomeWork3_Orders?useUnicode=true&serverTimezone=UTC&" +
            "useSSL=true&verifyServerCertificate=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    private static Connection conn;
    private static PreparedStatement ps;

    public void start() throws SQLException {
        try {
            conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTable() throws SQLException {
        Statement st = conn.createStatement();
        try {
            st.execute("drop table if exists Clients");
            st.execute("create table Clients (id int not null auto_increment primary key, name varchar(20) not null, " +
                    "surname varchar(30), sex varchar(7), city varchar(50) not null)");
        } finally {
            st.close();
        }
    }

    public void addClients(Client cl) throws SQLException {
        try {
            ps = conn.prepareStatement("insert into Clients (name, surname, city, sex) " +
                    "values (?, ?, ?, ?)");
            try {
                ps.setString(1, cl.getName());
                ps.setString(2, cl.getSurname());
                ps.setString(3, cl.getSex());
                ps.setString(4, cl.getCityOfResidence());
                ps.executeUpdate();
            } finally {
                ps.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

}
