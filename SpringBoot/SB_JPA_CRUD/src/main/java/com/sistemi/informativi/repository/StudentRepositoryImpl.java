package com.sistemi.informativi.repository;

import com.sistemi.informativi.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class StudentRepositoryImpl implements StudentRepository{

    /*
    L'Annotation @PersistenceContext rappresenta una annotation tramite
    la quale viene effettuata dependency injection delle API figli di EntityManager
     */
    @PersistenceContext
    private EntityManager em;


    @Override
    public void addStudent(Student student) {
        /*
        Hibernate traduce em.persist in uno script SQL per aggiungere l'object al db
        In particolare estrapola il contenuto dell'Oggetto in input, verifica se è
        un Entity JPA e traduce le variabili di istanza contenute nell'Oggetto nelle
        corrispondenti colonne della tabella, traduce in uno script di inster

        sqlHibernate = instert into student(first_name,last_name,age) values(contenuto oggetto)

         Grazie all'annotation @Transactional Hibernate comprende che c'è una
         connessione aperta verso il database per cui esegue lo script sql corrispondente
         al metodo persist dopo di che hibernate stesso chiude la connessione
         */
        em.persist(student);
    }

    @Override
    public Student getStudent(int id) {
        return null;
    }

    @Override
    public void updateStudent(Student student) {
        em.merge(student);
    }

    @Override
    public void deleteStudent(int id) {
        /*
        Hibernate traduce in select * form student where id=id passato
        in input al metodo
         */
        Student studentToRemove = em.find(Student.class, id);
        /*
        Hibernate traduce in delete from student where id=id passato in input
         */
        em.remove(studentToRemove);
    }

    @Override
    public List<Student> getAllStudents() {
        return em.createNamedQuery("Student.getStudent", Student.class)
                .getResultList();
    }

    @Override
    public List<Student> getStudentsByLastName(String lastName) {
        return em.createNamedQuery("Student.getStudentsByLastName", Student.class).setParameter("lastName", lastName).getResultList();
    }
}
