package com.sistemi.informativi.main;

import com.sistemi.informativi.business.Choice;
import com.sistemi.informativi.business.ChoiceImpl;
import com.sistemi.informativi.dao.MockFrontEndCourseDAO;
import com.sistemi.informativi.dao.MockFrontEndCourseDAOImpl;
import com.sistemi.informativi.enumeration.Course;

public class Main {
    public static void main(String[] args) {
        /*
        Il Metodo MAIN potrà scegliere una voce dell'enum tramite
        l'invocazione di un metodo ed in base alla scelta il main riceverà
        le informazioni di interesse
         */

        ChoiceImpl choose = new ChoiceImpl();
        choose.choice(Course.BACKEND).forEach(System.out::println);
        System.out.println();
        choose.choice(Course.FRONTEND).forEach(System.out::println);
    }
}
