package com.mycompany.jdbcsena1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/platziblog?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SqlJDBC.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        try (Connection conexion = DriverManager.getConnection(url, "root", "");
             Statement instruccion = conexion.createStatement();
             ResultSet resultado = instruccion.executeQuery("SELECT * FROM usuarios")) {

            while (resultado.next()) {
                System.out.print("user_id: " + resultado.getInt("user_id") + " ");
                System.out.print("login: " + resultado.getString("login") + " ");
                System.out.print("password: " + resultado.getString("password") + " ");
                System.out.print("email: " + resultado.getString("email") + " ");
                System.out.print("nickname: " + resultado.getString("nickname"));
                System.out.println();
            }

        } catch (SQLException ex) {
            Logger.getLogger(SqlJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
