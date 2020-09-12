package ru.live.kamaz_cs;

import java.sql.*;
import java.util.Scanner;

public class TableOfOrders {

    private static final String DB_CONNECTION = "jdbc:mysql://localhost/HomeWork3_Orders?useUnicode=true&serverTimezone=UTC&" +
            "useSSL=true&verifyServerCertificate=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";
    private int numberOfOrder = 1;

    private static Connection conn;
    private static PreparedStatement ps;


    public void start() throws SQLException {
        Scanner sc = new Scanner(System.in);
        try {
            conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            createTableOfOrders();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTableOfOrders() throws SQLException {
        Statement st = conn.createStatement();
        try {
            st.execute("drop table if exists Orders");
            st.execute("create table Orders(numberOfOrder int not null auto_increment primary key, nameOfClient varchar(20) not null, " +
                    "nameOfProduct varchar(20) not null, count int, price double not null, totalPrice double not null)");
        } finally {
            st.close();
        }
    }

    public void createOrderOfClient(int idOfClient, int idOfProduct, int count) throws SQLException {
        double totalPrice = count * getPriceOfProduct(idOfProduct);
        try {
            ps = conn.prepareStatement("insert into Orders (nameOfClient, nameOfProduct, count, price, totalPrice) " +
                    "values (?, ?, ?, ?, ?)");
            try {
                ps.setString(1, getNameOfClient(idOfClient));
                ps.setString(2, getNameOfProduct(idOfProduct));
                ps.setInt(3, count);
                ps.setDouble(4, getPriceOfProduct(idOfProduct));
                ps.setDouble(5, totalPrice);
                ps.executeUpdate();
            } finally {
                ps.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private String getNameOfClient(int id) throws SQLException {
        String b = null;
        PreparedStatement ps = conn.prepareStatement("select name from Clients where id = ?");
        ps.setInt(1, id);
        try {
            ResultSet rs = ps.executeQuery();
            try {
                ResultSetMetaData md = rs.getMetaData();
                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        b = rs.getString(i);
                    }
                }
            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }
        return b;
    }

    private String getNameOfProduct(int id) throws SQLException {
        String a = null;
        PreparedStatement ps = conn.prepareStatement("select name from Products where id = ?");
        ps.setInt(1, id);
        try {
            ResultSet rs = ps.executeQuery();
            try {
                ResultSetMetaData md = rs.getMetaData();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        a = rs.getString(i);
                    }
                }
            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }
        return a;
    }

    private double getPriceOfProduct(int id) throws SQLException {
        double b = 0;
        PreparedStatement ps = conn.prepareStatement("select price from Products where name = ?");
        ps.setString(1, getNameOfProduct(id));
        try {
            ResultSet rs = ps.executeQuery();
            try {
                ResultSetMetaData md = rs.getMetaData();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        b = rs.getDouble(i);
                    }
                }
            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }
        return b;
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

}
