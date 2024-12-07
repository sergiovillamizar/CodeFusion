import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JuegoAdivinanza {
    private Palabra palabra;
    private int intentos;

    // Metodo para obtener palabras segun la temática seleccionada
    public static List<String> obtenerPalabrasPorTematica(String tema) {
        List<String> palabras = new ArrayList<>();
        String rutaBase = System.getProperty("user.dir") + File.separator + "temas" + File.separator;

        try {
            File archivo = new File(rutaBase + tema + ".txt");
            if (!archivo.exists()) {
                System.err.println("El archivo con el tema '" + tema + "' no existe en la ruta especificada: " + archivo.getPath());
                return palabras; // Devolvemos una lista vacía
            }
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    palabras.add(linea.trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return palabras;
    }

    public void iniciarJuego(String tema, int intentosMaximos) {
        String palabraSeleccionada = seleccionarPalabra(tema);
        if (palabraSeleccionada == null) {
            throw new IllegalArgumentException("No se encontró ninguna palabra en el archivo para la temática: " + tema);
        }
        iniciarJuegoConPalabra(palabraSeleccionada, intentosMaximos);
    }

    public static String seleccionarPalabra(String tema) {
        List<String> palabras = obtenerPalabrasPorTematica(tema);

        if (palabras.isEmpty()) {
            return null; // Si no hay palabras disponibles, devolvemos null
        }
        Random random = new Random();
        return palabras.get(random.nextInt(palabras.size())); // Selecciona una palabra aleatoria
    }

    // Método para inicializar el juego con una palabra específica
    public void iniciarJuegoConPalabra(String palabraSeleccionada, int intentosMaximos) {
        if (palabraSeleccionada == null || palabraSeleccionada.trim().isEmpty()) {
            throw new IllegalArgumentException("La palabra seleccionada no puede estar vacía.");
        }
        if (intentosMaximos <= 0) {
            throw new IllegalArgumentException("El número de intentos debe ser mayor que cero.");
        }
        //this.palabra = new Palabra(palabraSeleccionada);
        this.intentos = intentosMaximos;
    }
}
