package com.sistemi.informativi.connection;

import java.sql.*;

public class ConnectionManager implements DbParameters{

    /*
    Apre la connessione
    restituisce Prepared Statement
    restituisce Statement
    chiude la connessione
     */

    private static Connection con;

    //Stabilisco una connessione col database e la ritorno
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (con==null){
            Class.forName(dbDriver);
            con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
        }
        return con;
    }

    //Restituisce PreparedStatement
    public static PreparedStatement getPreparedStatement(String sql) throws SQLException, ClassNotFoundException {

        return getConnection().prepareStatement(sql);

    }

    //Restituisce un resulset per leggere
    public static ResultSet getResulset(String sql) throws SQLException, ClassNotFoundException {

        return getConnection().createStatement().executeQuery(sql);

    }
}
