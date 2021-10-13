package BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionJDBC {

    public static void main(String[] args) {

//        String urlConnection = "jdbc:mysql://localhost/digital_innovation_one";
//
//        try (Connection conn = DriverManager.getConnection(urlConnection, "valerio", "password")) {
//            System.out.println("SUCESSO ao se conectar ao banco MySQL!");
//        } catch (Exception e) {
//            System.out.println("FALHA ao se conectar ao banco MySQL!");
//        }

        String driver = "mysql";
        String dataBaseAddress = "localhost";
        String dataBaseName = "digital_innovation_one";
        String user = "valerio";
        String password = "password";

        StringBuilder sb = new StringBuilder("jdbc:")
                .append(driver).append("://")
                .append(dataBaseAddress).append("/")
                .append(dataBaseName);

        String urlConnection = sb.toString();

        try (Connection conn = DriverManager.getConnection(urlConnection, user, password)) {
            System.out.println("SUCESSO ao se conectar ao banco MySQL!");
        } catch (Exception e) {
            System.out.println("FALHA ao se conectar ao banco MySQL!");
        }

    }
}
