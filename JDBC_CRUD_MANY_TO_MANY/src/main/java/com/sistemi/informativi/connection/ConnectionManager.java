package com.sistemi.informativi.connection;

import java.sql.*;

public class ConnectionManager implements DBParameters{

    private static Connection connection;

    /**
     *
     * @return connection che fa riferimento ad una singola istanza (Pattern Singleton)
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if(connection == null){
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbUrl,dbUser,dbPass);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException{
        connection.close();
    }

    /**
     *
     * @param sql
     * @return PreparedStatement
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    public static PreparedStatement getPreparedStatement(String sql) throws SQLException, ClassNotFoundException {

        return getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

    }

    /**
     *
     * @param sql
     * @return ritorna un resulset
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static ResultSet getResulset(String sql) throws SQLException, ClassNotFoundException {

        return getConnection().createStatement().executeQuery(sql);

    }

}
