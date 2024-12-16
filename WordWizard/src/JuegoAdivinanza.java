import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase que gestiona la logica principal de un juego de adivinanza de palabras.
 * Permite cargar palabras de un archivo basado en temáticas, realizar intentos
 * de adivinanza y determinar el estado del juego (ganado, perdido o en progreso).
 */
public class JuegoAdivinanza {
    private Palabra palabra; // Representa la palabra a adivinar.
    private int intentos; // Número de intentos restantes.

    /**
     * Obtiene una lista de palabras desde un archivo basado en la temática seleccionada.
     *
     * @param tema El nombre del archivo que contiene las palabras para la temática.
     * @return Una lista de palabras asociadas a la temática. Si el archivo no existe o
     *         hay un error, retorna una lista vacía.
     */
    public static List<String> obtenerPalabrasPorTematica(String tema) {
        List<String> palabras = new ArrayList<>();
        String archivoRuta = "assets/" + tema + ".txt";

        try (InputStream input = JuegoAdivinanza.class.getClassLoader().getResourceAsStream(archivoRuta);
             BufferedReader br = new BufferedReader(new InputStreamReader(input))) {

            if (input == null) {
                System.err.println("El archivo con el tema '" + tema + "' no existe en la ruta: " + archivoRuta);
                return palabras;
            }

            String linea;
            while ((linea = br.readLine()) != null) {
                palabras.add(linea.trim());
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return palabras;
    }

    /**
     * Inicia el juego seleccionando una palabra aleatoria de un archivo basado en
     * la temática dada.
     *
     * @param tema           La temática de las palabras.
     * @param intentosMaximos El número máximo de intentos permitidos.
     * @throws IllegalArgumentException Si no se encuentra ninguna palabra para la temática dada
     *                                  o si el número de intentos es inválido.
     */
    public void iniciarJuego(String tema, int intentosMaximos) {
        String palabraSeleccionada = seleccionarPalabra(tema);
        if (palabraSeleccionada == null) {
            throw new IllegalArgumentException("No se encontró ninguna palabra en el archivo para la temática: " + tema);
        }
        iniciarJuegoConPalabra(palabraSeleccionada, intentosMaximos);
    }

    /**
     * Selecciona una palabra aleatoria de la temática especificada.
     *
     * @param tema La temática de las palabras.
     * @return Una palabra aleatoria de la lista de palabras de la temática, o null si
     *         no hay palabras disponibles.
     */
    public static String seleccionarPalabra(String tema) {
        List<String> palabras = obtenerPalabrasPorTematica(tema);

        if (palabras.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return palabras.get(random.nextInt(palabras.size()));
    }

    /**
     * Inicializa el juego con una palabra específica.
     *
     * @param palabraSeleccionada La palabra con la que se iniciará el juego.
     * @param intentosMaximos     El número máximo de intentos permitidos.
     * @throws IllegalArgumentException Si la palabra es nula o vacía, o si el número de intentos es menor o igual a cero.
     */
    public void iniciarJuegoConPalabra(String palabraSeleccionada, int intentosMaximos) {
        if (palabraSeleccionada == null || palabraSeleccionada.trim().isEmpty()) {
            throw new IllegalArgumentException("La palabra seleccionada no puede estar vacía.");
        }
        if (intentosMaximos <= 0) {
            throw new IllegalArgumentException("El número de intentos debe ser mayor que cero.");
        }
        this.palabra = new Palabra(palabraSeleccionada);
        this.intentos = intentosMaximos;
    }

    /**
     * Intenta adivinar una letra en la palabra.
     *
     * @param letra La letra que el jugador desea adivinar.
     * @return true si la letra está en la palabra; false en caso contrario.
     * @throws IllegalStateException Si el juego ya ha terminado (ganado o perdido).
     */
    public boolean adivinarLetra(char letra) {
        if (juegoPerdido()) {
            throw new IllegalStateException("El juego ha terminado. No hay más intentos.");
        }
        if (intentos <= 0) {
            throw new IllegalStateException("El juego ha terminado. No hay más intentos.");
        }
        boolean letraCorrecta = palabra.comprobarLetra(letra);
        if (!letraCorrecta) {
            intentos--;
        }
        return letraCorrecta;
    }

    /**
     * Muestra el progreso actual de la palabra adivinada.
     *
     * @return Una representación de la palabra con las letras acertadas y guiones bajos para las no adivinadas.
     */
    public String mostrarProgreso() {
        if (palabra == null) {
            return "No hay palabra inicializada.";
        }
        return palabra.getPalabraAdivinada();
    }

    /**
     * Verifica si el jugador ha ganado el juego.
     *
     * @return true si todas las letras han sido adivinadas; false de lo contrario.
     */
    public boolean juegoGanado() {
        return !palabra.getPalabraAdivinada().contains("_");
    }

    /**
     * Verifica si el jugador ha perdido el juego.
     *
     * @return true si se han agotado los intentos y la palabra no ha sido completamente adivinada; false de lo contrario.
     */
    public boolean juegoPerdido() {
        return intentos <= 0 && !juegoGanado();
    }

    /**
     * Obtiene el número de intentos restantes.
     *
     * @return El número de intentos restantes.
     */
    public int getIntentosRestantes() {
        return intentos;
    }

    /**
     * Obtiene la palabra seleccionada para el juego.
     *
     * @return La palabra seleccionada.
     */
    public String getPalabraSeleccionada() {
        return palabra.getPalabraSeleccionada();
    }
}
