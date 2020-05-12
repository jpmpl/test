/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Joao Paulo
 */
public class DBConnection {
    private static Connection m_conn;
    
    public static void Connect() {
        m_conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/sqlite/db/chinook.db";
            // create a connection to the database
            m_conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     
    public static void CloseConnection()
    {   
        try {
            if (m_conn != null) {
                m_conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static ResultSet ExecuteQuery(String selectSql)
    {
        ResultSet resultSet = null;
        try
        {
            Statement statement = m_conn.createStatement();
            resultSet = statement.executeQuery(selectSql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return resultSet;
        }
        return resultSet;
    }
}
