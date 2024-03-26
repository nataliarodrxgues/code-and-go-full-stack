package com.agencia.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.agencia.utils.Colors;

public class DatabaseConnection {
    private static final String url = "jdbc:mysql://localhost:3306/codeandgo_crud";
    private static final String user = "root";
    private static final String password = "161312";

    public static Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println(Colors.GREEN.get() + "Driver encontrado!" + Colors.RESET.get());

            connection = DriverManager.getConnection(url, user, password);
            System.out.println(Colors.GREEN.get() + "Conectado com sucesso!" + Colors.RESET.get());
        } catch (ClassNotFoundException e) {
            System.out.printf(Colors.RED.get() + "Driver não encontrado! Mensagem: " + e.getMessage() + Colors.RESET.get());
        } catch (SQLException e) {
            System.out.printf(Colors.RED.get() + "Não foi possível conectar ao banco! Mensagem: " + e.getMessage() + Colors.RESET.get());
        }
        return connection;
    }
}
