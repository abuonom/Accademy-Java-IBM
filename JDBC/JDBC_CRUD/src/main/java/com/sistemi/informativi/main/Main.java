package com.sistemi.informativi.main;

import java.sql.*;

public class Main {

    private static final String dbDriver = "com.mysql.cj.jdbc.Driver";
    private static final String dbUrl = "jdbc:mysql://localhost:3306/openjob";
    private static final String dbUser = "root";
    private static final String dbPassword = "";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String sqlStudentInsert = "insert into student(first_name,last_name,age) values(?,?,?)";
        String sqlStudentUpdate = "update student set first_name=?,last_name=?,age=? where id=?";
        String sqlStudentRead = "select * from student";

        //Step 1: Indicazione del driver di connessione
        Class.forName(dbDriver);

        //Step 2: apertura connessione al database
        Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPassword);

        //Step 3: Operazioni di crud
        /*
            3.1 Inserimento nella tabella student del database openjob.
            Il metodo prepareStatement accetta in input uno script anonimo
            con dei parametri indefiniti (placeholder) che successivamente vengono concretizzati
         */
        PreparedStatement preparedStatement = con.prepareStatement(sqlStudentInsert);
        /*
        L'API PreparedStatement contiene un metodo di set per ogni possibile
        tipo dei campi di un database relazionale
         */
        preparedStatement.setString(1,"Giovanni");
        preparedStatement.setString(2,"Carlini");
        preparedStatement.setString(3,"28");
        preparedStatement.executeUpdate();

        //Step 3.2 Update nella tabella
        preparedStatement = con.prepareStatement(sqlStudentUpdate);
        preparedStatement.setString(1,"Giada");
        preparedStatement.setString(2,"Proto");
        preparedStatement.setInt(3,29);
        preparedStatement.setInt(4,1);
        preparedStatement.executeUpdate();

        //Step 3.3 Read della tabella
        preparedStatement = con.prepareStatement(sqlStudentRead);

        //Step 3.4 LETTURA INTEGRALE
        preparedStatement = con.prepareStatement("select * from student");
        //Struttura dati speculare alla tabella che viene recuperata, ogni riga diventa un Object
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()){
            System.out.println(rs.getInt("id") + " " +
                    rs.getString("first_name") + " " + rs.getString("last_name") + " " + rs.getInt("age"));
        }

    }
}