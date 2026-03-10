package zoojava.db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EnvLoader {
    public static void load(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    System.setProperty(parts[0].trim(), parts[1].trim());
                }
            }
            System.out.println(">>> Configuración cargada desde .env");
        } catch (IOException e) {
            System.err.println("Error: No se pudo encontrar o leer el archivo .env");
        }
    }
}
