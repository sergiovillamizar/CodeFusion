import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Clase principal que inicia la aplicación del juego de Ahorcado.
 */
public class Main {

    /**
     * Método principal que inicializa el menú inicial del juego.
     * @param args argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuInicial().setVisible(true);
            }
        });
    }

    /**
     * Muestra una ficha técnica con información del equipo de desarrollo y detalles del juego.
     */
    public static void mostrarFichaTecnica() {
        JOptionPane.showMessageDialog(null,
                "<html><b>--- Ficha técnica del equipo ---</b><br>" +
                        "Como Product Owner: <br> GISELL ALEXANDRA ANAYA SANTAFE<br>" +
                        "Como Scrum Master: <br> SERGIO ALEJANDRO VILLAMIZAR ESPINEL<br>" +
                        "Equipo de desarrollo de Java:<br> JEISON DAVID MENDEZ CASTRO <br> HEIDY LIZETH CONDE JAIMES<br>" +
                        "Descripcion del juego: Adivina la palabra secreta antes de quedarte sin intentos.<br>" +
                        "Versión: 1.0<br>" +
                        "Fecha de creacion: Noviembre de 2024<br>" +
                        "Este juego fue diseñado para practicar la logica de programacion y manejo de estructuras.<br>" +
                        "¡Esperamos que disfrutes el juego!</html>",
                "Ficha Técnica", JOptionPane.INFORMATION_MESSAGE);
    }
}

/**
 * Clase que representa el menú inicial del juego.
 */
class MenuInicial extends JFrame {

    /**
     * Constructor que inicializa la interfaz del menú inicial.
     */
    public MenuInicial() {
        setTitle("Menú Inicial");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel labelImagen = new JLabel(new ImageIcon(getClass().getResource("/assets/logo.png")));

        panel.add(labelImagen, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(3, 1, 10, 10));
        JButton buttonInicio = new JButton("Inicio");
        JButton buttonFichaTecnica = new JButton("Ver Ficha Técnica");
        JButton buttonSalir = new JButton("Salir");

        buttonInicio.setFont(new Font("Arial", Font.BOLD, 20));
        buttonFichaTecnica.setFont(new Font("Arial", Font.BOLD, 20));
        buttonSalir.setFont(new Font("Arial", Font.BOLD, 20));

        panelCentral.add(buttonInicio);
        panelCentral.add(buttonFichaTecnica);
        panelCentral.add(buttonSalir);

        panel.add(panelCentral, BorderLayout.CENTER);

        add(panel);

        buttonInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AhorcadoGUI().setVisible(true);
                dispose();
            }
        });

        buttonFichaTecnica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mostrarFichaTecnica();
            }
        });

        buttonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}

/**
 * Clase que representa la interfaz gráfica del juego de Ahorcado.
 */
class AhorcadoGUI extends JFrame {
    private JuegoAdivinanza juego;
    private JLabel labelProgreso;
    private JLabel labelIntentos;
    private JLabel labelIntentosTotales;
    private JLabel labelNumeroLetras;
    private JTextField textFieldLetra;
    private JTextArea textAreaMensajes;
    private JProgressBar barraVidas;

    /**
     * Constructor que inicializa la interfaz del juego de Ahorcado.
     */
    public AhorcadoGUI() {
        setTitle("Juego de Ahorcado");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Panel superior para mostrar el progreso, intentos y número de letras
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(4, 1));

        labelProgreso = new JLabel("Progreso: ");
        labelProgreso.setHorizontalAlignment(SwingConstants.CENTER);
        labelProgreso.setFont(new Font("Arial", Font.BOLD, 30));

        labelNumeroLetras = new JLabel("La palabra contiene X letras.");
        labelNumeroLetras.setHorizontalAlignment(SwingConstants.CENTER);
        labelNumeroLetras.setFont(new Font("Arial", Font.BOLD, 18));

        labelIntentosTotales = new JLabel("Tiene 8 intentos.");
        labelIntentosTotales.setHorizontalAlignment(SwingConstants.CENTER);
        labelIntentosTotales.setFont(new Font("Arial", Font.BOLD, 18));

        labelIntentos = new JLabel("Intentos restantes: ");
        labelIntentos.setHorizontalAlignment(SwingConstants.CENTER);
        labelIntentos.setFont(new Font("Arial", Font.PLAIN, 16));

        barraVidas = new JProgressBar(0, 8);
        barraVidas.setValue(8);
        barraVidas.setStringPainted(true);

        panelSuperior.add(labelProgreso);
        panelSuperior.add(labelNumeroLetras);
        panelSuperior.add(labelIntentosTotales);
        panelSuperior.add(barraVidas);

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());
        textFieldLetra = new JTextField(1);
        textFieldLetra.setFont(new Font("Arial", Font.PLAIN, 24)); // Hacer el campo de texto más grande
        textAreaMensajes = new JTextArea();
        textAreaMensajes.setEditable(false);
        panelCentral.add(textFieldLetra, BorderLayout.NORTH);
        panelCentral.add(new JScrollPane(textAreaMensajes), BorderLayout.CENTER);

        JPanel panelInferior = new JPanel();
        JButton buttonNuevoJuego = new JButton("Nuevo Juego");
        JButton buttonMenuPrincipal = new JButton("Menú Principal");
        panelInferior.add(buttonNuevoJuego);
        panelInferior.add(buttonMenuPrincipal);

        panel.add(panelSuperior, BorderLayout.NORTH);
        panel.add(panelCentral, BorderLayout.CENTER);
        panel.add(panelInferior, BorderLayout.SOUTH);

        add(panel);

        buttonNuevoJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarNuevoJuego();
            }
        });

        buttonMenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuInicial().setVisible(true);
                dispose();
            }
        });

        textFieldLetra.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String letra = textFieldLetra.getText().toLowerCase();
                    if (letra.length() != 1 || !Character.isLetter(letra.charAt(0))) {
                        textAreaMensajes.append("Entrada inválida. Por favor, ingresa una sola letra.\n");
                    } else {
                        boolean acierto = juego.adivinarLetra(letra.charAt(0));
                        if (acierto) {
                            textAreaMensajes.append("¡Correcto! La letra '" + letra + "' está en la palabra.\n");
                        } else {
                            textAreaMensajes.append("Letra incorrecta. La letra '" + letra + "' no está en la palabra.\n");
                        }
                        actualizarEstadoJuego();
                    }
                    textFieldLetra.setText("");
                }
            }
        });

        iniciarNuevoJuego();
    }

    /**
     * Inicia un nuevo juego seleccionando una categoría y reiniciando los elementos del juego.
     */
    private void iniciarNuevoJuego() {
        String[] categorias = {"animales", "deportes", "tecnologia", "lugares", "general"};
        String categoriaSeleccionada = (String) JOptionPane.showInputDialog(this, "Selecciona una categoría:", "Nuevo Juego",
                JOptionPane.PLAIN_MESSAGE, null, categorias, categorias[0]);
        if (categoriaSeleccionada != null) {
            juego = new JuegoAdivinanza();
            juego.iniciarJuego(categoriaSeleccionada, 8);
            labelNumeroLetras.setText("La palabra contiene " + juego.getPalabraSeleccionada().length() + " letras.");
            textAreaMensajes.setText("¡Nuevo juego iniciado! Categoría: " + categoriaSeleccionada + "\n");
            actualizarEstadoJuego();
        }
    }

    /**
     * Actualiza el estado del juego en la interfaz gráfica, incluyendo progreso y mensajes.
     */
    private void actualizarEstadoJuego() {
        labelProgreso.setText("Progreso: " + juego.mostrarProgreso());
        labelIntentos.setText("Intentos restantes: " + juego.getIntentosRestantes());
        barraVidas.setValue(juego.getIntentosRestantes());
        if (juego.juegoGanado()) {
            textAreaMensajes.setText(""); // Limpiar el área de mensajes
            textAreaMensajes.append("¡Felicidades! Has adivinado la palabra: " + juego.getPalabraSeleccionada() + "\n");
        } else if (juego.juegoPerdido()) {
            textAreaMensajes.setText(""); // Limpiar el área de mensajes
            textAreaMensajes.setFont(new Font("Arial", Font.BOLD, 24)); // Hacer el texto más grande
            textAreaMensajes.append("Game Over\n");
            textAreaMensajes.append("La palabra era: " + juego.getPalabraSeleccionada() + "\n");
        }
    }
}
