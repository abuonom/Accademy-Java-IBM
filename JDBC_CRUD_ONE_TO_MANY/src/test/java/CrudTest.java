import com.sistemi.informativi.connection.ConnectionManager;
import com.sistemi.informativi.dao.FacedeDAO;
import com.sistemi.informativi.dao.FacedeDAOImpl;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class CrudTest {

    @Test
    public void removeCourseTest() throws SQLException, ClassNotFoundException {

        FacedeDAO facedeDAO = new FacedeDAOImpl();
        Connection connection = ConnectionManager.getConnection();

        facedeDAO.removeCourse(3);
        ConnectionManager.closeConnection();

    }

}
