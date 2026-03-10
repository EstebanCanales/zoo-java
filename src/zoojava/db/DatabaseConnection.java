package zoojava.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.File;

public class DatabaseConnection {

    static {
        // Carga el archivo .env al inicio
        EnvLoader.load(".env");
    }

    public static Connection getConnection() throws SQLException {
        // Obtenemos los valores de las variables de entorno o propiedades
        // Quitamos los valores por defecto sensibles para máxima seguridad
        String walletPath = System.getProperty("WALLET_PATH");
        String tnsName = System.getProperty("TNS_NAME");
        String dbUser = System.getProperty("DB_USER");
        String dbPassword = System.getProperty("DB_PASSWORD");

        if (dbPassword == null || dbUser == null || tnsName == null) {
            throw new SQLException("Error de configuración: Variables de entorno no encontradas en el archivo .env");
        }

        // Convertir ruta relativa a absoluta para JDBC
        String absoluteWalletPath = new File(walletPath).getAbsolutePath();
        String dbUrl = "jdbc:oracle:thin:@" + tnsName + "?TNS_ADMIN=" + absoluteWalletPath;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            Properties props = new Properties();
            props.setProperty("user", dbUser);
            props.setProperty("password", dbPassword);

            Connection conn = DriverManager.getConnection(dbUrl, props);
            System.out.println(">>> Conexión exitosa a Oracle Cloud.");
            return conn;
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró el driver JDBC de Oracle.");
            throw new SQLException(e);
        } catch (SQLException e) {
            System.err.println("Error de conexión SQL: " + e.getMessage());
            throw e;
        }
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
