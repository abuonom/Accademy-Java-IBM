package com.sistemi.informativi.dao;

import com.sistemi.informativi.connection.ConnectionManager;
import com.sistemi.informativi.dto.StudentDTO;
import com.sistemi.informativi.sql.SqlScript;
import com.sistemi.informativi.vo.StudentVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {
    PreparedStatement ps;
    @Override
    public void addStudent(StudentDTO studentDTO) throws SQLException, ClassNotFoundException {

        /*
        Inizializzazione di un PreparedStatement tramite invocazione alla Classe ConnectionManager
        Quando il Main invocherà questo metodo gli passerà in input il seguente script sql anonimo:
        "Insert into student() values (???)"
         */
        ps = ConnectionManager.getPreparedStatement(SqlScript.sqlStudentInsert);
        ps.setString(1,studentDTO.getFirstName());
        ps.setString(2,studentDTO.getLastName());
        ps.setInt(3,studentDTO.getAge());
        ps.executeUpdate();
    }

    @Override
    public void updateStudent(StudentDTO studentDTO, int id) throws SQLException, ClassNotFoundException {

        //"update student set first_name=?,last_name=?,age=? where id=?"
        PreparedStatement ps = ConnectionManager.getPreparedStatement(SqlScript.sqlStudentUpdate);
        ps.setString(1, studentDTO.getFirstName());
        ps.setString(2, studentDTO.getLastName());
        ps.setInt(3, studentDTO.getAge());
        ps.setInt(4, id);
        // script sql concreto
        ps.executeUpdate();

    }

    @Override
    public void removeStudent(int id) throws SQLException, ClassNotFoundException {

        // delete from student where id=?
        PreparedStatement ps = ConnectionManager.getPreparedStatement(SqlScript.sqlStudentDelete);
        ps.setInt(1, id);
        // script concreto

        ps.executeUpdate();

    }

    @Override
    public ArrayList<StudentVO> getStudents() throws SQLException, ClassNotFoundException {

        /*
        Inizializza una struttura dati, con tante locazioni quanti sono i record
        recuperati dal database nella query di ricerca

        Nativamente le reference contenute nelle locazioni di memoria di un Resultset
        non referenziano Oggetti Serializable.
        Viene considerata una best practice lavorare anche in lettura con Oggetti
        Setializable.
         */
        ArrayList<StudentVO> students = new ArrayList<>();
        ResultSet rs = ConnectionManager.getResulset(SqlScript.sqlStudentSelect);

        while(rs.next()) {
            /*
            Estraiamo il contenuto di ogni Oggetto nel RS (non serializzabile)
            e lo copiamo in un Oggetto VO (serializzabile)
             */

            StudentVO studentVO = new StudentVO(
                    rs.getInt("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getInt("age"));

            students.add(studentVO);
        }

        return students;
    }
}
