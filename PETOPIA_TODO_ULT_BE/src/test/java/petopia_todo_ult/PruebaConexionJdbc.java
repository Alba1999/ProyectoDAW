package petopia_todo_ult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
public class PruebaConexionJdbc {

    @Autowired
    public DataSource dataSource;

    @Test
    public void pruebaConexion() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("La conexión a la base de datos fue exitosa");
        } catch (SQLException e) {
            System.out.println("La conexión a la base de datos falló");
            e.printStackTrace();
        }
    }
}
