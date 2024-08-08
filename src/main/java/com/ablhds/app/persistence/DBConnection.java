package com.ablhds.app.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton para conexão com BD
 */
public class DBConnection {
    private static String driverPath;
    private static String connectionString;

    private static Connection conn = null;

    /**
     * Construtor vazio para obrigar a criar objeto com get()
     */
    private DBConnection() {
    }

    /**
     * Cria o objeto, garantindo que ele é único
     *
     * @return DBConnection
     * @throws SQLException Exceção em caso de problemas na conexão com o BD
     */
    public static synchronized Connection get() throws SQLException {

        if (conn == null || conn.isClosed())
            conn = DriverManager.getConnection(connectionString, "", "");

        return conn;
    }

    /**
     * Inicializa o objeto com os dados da conexão e carrega o driver JDBC para memória
     *
     * @param driver  Path do driver JDBC
     * @param strConn Sgtring de conexão com o BD
     * @throws ClassNotFoundException Exceção em caso de problemas no carregamento do driver
     */
    public static void setup(String driver, String strConn) throws ClassNotFoundException {
        DBConnection.driverPath = driver;
        DBConnection.connectionString = strConn;

        Class.forName(driverPath);
    }

    /**
     * Fecha a conexão com o BD
     */
    public static synchronized void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            // Nada a fazer
        }
    }
}
