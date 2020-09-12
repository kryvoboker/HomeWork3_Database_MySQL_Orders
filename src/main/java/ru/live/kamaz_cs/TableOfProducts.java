package ru.live.kamaz_cs;

import java.sql.*;

public class TableOfProducts {

    private static final String DB_CONNECTION = "jdbc:mysql://localhost/HomeWork3_Orders?useUnicode=true&serverTimezone=UTC&" +
            "useSSL=true&verifyServerCertificate=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";
    private int id = 10000;

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
            st.execute("drop table if exists Products");
            st.execute("create table Products (id int not null primary key, name varchar(30) not null, model varchar(20)," +
                    "material varchar(30), weight varchar(10), price double not null)");
        } finally {
            st.close();
        }
    }

    public void addPhoneInTable(Phone ph) throws SQLException {
        try {
            ps = conn.prepareStatement("insert into Products (id, name, model, weight, price) " +
                    "values (?, ?, ?, ?, ?)");
            try {
                ps.setInt(1, id);
                ps.setString(2, ph.getName());
                ps.setString(3, ph.getModel());
                ps.setString(4, ph.getWeight());
                ps.setDouble(5, ph.getPrice());
                ps.executeUpdate();
            } finally {
                ps.close();
                id += 1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addTableInTable(Table tb) throws SQLException {
        try {
            ps = conn.prepareStatement("insert into Products (id, name, model, material, weight, price) " +
                    "values (?, ?, ?, ?, ?, ?)");
            try {
                ps.setInt(1, id);
                ps.setString(2, tb.getName());
                ps.setString(3, tb.getModel());
                ps.setString(4, tb.getMaterial());
                ps.setString(5, tb.getWeight());
                ps.setDouble(6, tb.getPrice());
                ps.executeUpdate();
            } finally {
                ps.close();
                id += 1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addClothesInTable(Clothes cl) throws SQLException {
        try {
            ps = conn.prepareStatement("insert into Products (id, name, model, material, weight, price) " +
                    "values (?, ?, ?, ?, ?, ?)");
            try {
                ps.setInt(1, id);
                ps.setString(2, cl.getName());
                ps.setString(3, cl.getModel());
                ps.setString(4, cl.getMaterial());
                ps.setString(5, cl.getWeight());
                ps.setDouble(6, cl.getPrice());
                ps.executeUpdate();
            } finally {
                ps.close();
                id += 1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

}


