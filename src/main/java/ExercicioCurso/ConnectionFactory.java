package ExercicioCurso;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private ConnectionFactory() {
        throw new UnsupportedOperationException();
    }

    public static Connection getConnection() {

        Connection connection = null;

        // Os valores estão sendo recebidos do arquivo connection.properties
        // Recebe os valores e carrega na variável Properties
        try (InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream("connection.properties")) {

            // Parâmetros para se conectar ao banco de dados.
            Properties prop = new Properties();
            prop.load(input);

            // Recebe os valores
            String driver = prop.getProperty("jdbc.driver");
            String dataBaseAddress = prop.getProperty("db.address");
            String dataBaseName = prop.getProperty("db.name");
            String user = prop.getProperty("db.user.login");
            String password = prop.getProperty("db.user.password");

            // Cria uma String de conexão
            StringBuilder sb = new StringBuilder("jdbc:")
                    .append(driver).append("://")
                    .append(dataBaseAddress).append("/")
                    .append(dataBaseName);
            String connectionUrl = sb.toString();

            // Requer a conexão, armazena e retorna
            try {
                connection = DriverManager.getConnection(connectionUrl, user, password);
            } catch (SQLException e) {
                System.out.println("Houve um erro ao conectar.");
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            System.out.println("Falha ao tentar carregar o arquivo de propriedades.");
            e.printStackTrace();
        }

        return connection;
    }
}

