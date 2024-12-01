public class JuegoAdivinanza {
    String palabra;
    int intentos;
    char[] progreso;

    public JuegoAdivinanza(String palabra, int intentos){
        this.palabra = palabra.toLowerCase();
        this.intentos = intentos;
        this.progreso = new char[palabra.length()];
        for(int i = 0; i < progreso.length; i++){
            progreso[i] = '_';
        }
    }
}
