package ru.neoflex.dao;

import java.sql.*;

public class MySqlConnector {

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testimony?useUnicode=true&serverTimezone=UTC", "root", "148192");
            System.out.println("Успешное поключение к базе данных");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка подключения " + e);
        }
        return connection;
    }

    public static ResultSet selectAllFrommBilling(String currentmonth) throws SQLException {
        Statement st = getConnection().createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * FROM billing_period WHERE currentmonth = \"" + currentmonth + "\"");
        return resultSet;
    }

    public static ResultSet selectAllFrommPriceGuide(int priceColdWater) throws SQLException {
        Statement st = getConnection().createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * FROM price_guide WHERE priceColdWater = \"" + priceColdWater + "\"");
        return resultSet;
    }

    public static ResultSet selectAllFrommHistory(String testimonyDate) throws SQLException {
        Statement st = getConnection().createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * FROM testimony_history WHERE currentmonth = \"" + testimonyDate + "\"");
        return resultSet;
    }
}


