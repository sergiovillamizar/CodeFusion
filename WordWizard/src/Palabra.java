/**
 * Clase que representa una palabra para un juego de adivinanza.
 * Permite verificar letras ingresadas, mostrar el progreso del jugador y gestionar
 * el estado de la palabra adivinada.
 */
public class Palabra {
    private String palabraSeleccionada; // La palabra que el jugador debe adivinar.
    private String progreso; // Representación del progreso del jugador, usando guiones bajos.

    /**
     * Constructor que inicializa la palabra a adivinar y el progreso inicial.
     *
     * @param palabraSeleccionada la palabra que el jugador intentará adivinar.
     * @throws IllegalArgumentException si la palabra es nula, vacía o contiene solo espacios.
     */
    public Palabra(String palabraSeleccionada) {
        if (palabraSeleccionada == null || palabraSeleccionada.trim().isEmpty()) {
            throw new IllegalArgumentException("La palabra seleccionada no puede estar vacía o nula.");
        }
        this.palabraSeleccionada = palabraSeleccionada.toLowerCase(); // Convertir a minúsculas para consistencia.
        this.progreso = "_".repeat(palabraSeleccionada.length()); // Inicializar el progreso con guiones bajos.
    }

    /**
     * Obtiene la palabra seleccionada.
     *
     * @return la palabra a adivinar.
     */
    public String getPalabraSeleccionada() {
        return palabraSeleccionada;
    }

    /**
     * Muestra la palabra seleccionada separada por guiones.
     * Cada carácter se separa con un guion, sin alterar el contenido original.
     *
     * @return una representación de la palabra con guiones entre caracteres.
     */
    public String mostrarConGuiones() {
        if (palabraSeleccionada == null || palabraSeleccionada.isEmpty()) {
            return "";
        }
        StringBuilder palabraConGuiones = new StringBuilder();
        for (int i = 0; i < palabraSeleccionada.length(); i++) {
            palabraConGuiones.append(palabraSeleccionada.charAt(i));
            if (i < palabraSeleccionada.length() - 1) {
                palabraConGuiones.append("-");
            }
        }
        return palabraConGuiones.toString();
    }

    /**
     * Comprueba si una letra ingresada está presente en la palabra seleccionada.
     * Si la letra es correcta, actualiza el progreso con la letra en las posiciones correspondientes.
     *
     * @param letra la letra ingresada por el jugador.
     * @return true si la letra está en la palabra; false de lo contrario.
     * @throws IllegalArgumentException si el carácter ingresado no es una letra.
     */
    public boolean comprobarLetra(char letra) {
        if (!Character.isLetter(letra)) {
            throw new IllegalArgumentException("El carácter ingresado debe ser una letra.");
        }
        letra = Character.toLowerCase(letra); // Convertir a minúsculas para comparación.
        boolean letraCorrecta = false;
        StringBuilder nuevaPalabra = new StringBuilder();

        for (int i = 0; i < palabraSeleccionada.length(); i++) {
            if (Character.toLowerCase(palabraSeleccionada.charAt(i)) == letra) {
                nuevaPalabra.append(letra); // Si coincide, se agrega la letra al progreso.
                letraCorrecta = true;
            } else {
                nuevaPalabra.append(progreso.charAt(i)); // Mantener el progreso actual en las demás posiciones.
            }
        }

        if (letraCorrecta) {
            progreso = nuevaPalabra.toString(); // Actualizar el progreso solo si la letra es correcta.
        }
        return letraCorrecta;
    }

    /**
     * Obtiene el progreso actual de la palabra adivinada.
     *
     * @return una cadena con las letras acertadas y guiones bajos para las pendientes.
     */
    public String getPalabraAdivinada() {
        return progreso;
    }
}
