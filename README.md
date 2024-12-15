# Juego de Ahorcado en Java

Este es un juego interactivo de Ahorcado desarrollado en **Java** con una interfaz gráfica utilizando **Swing**. El objetivo del juego es adivinar la palabra secreta antes de agotar los intentos disponibles. Es ideal para practicar lógica de programación y el manejo de estructuras en Java.

---

## Descripción
El juego selecciona una palabra secreta de un conjunto de categorías disponibles (como animales, deportes, tecnología, entre otros) y permite al jugador intentar adivinar letra por letra. Ofrece una interfaz amigable que muestra el progreso de la palabra, los intentos restantes y un sistema visual con una barra de vidas.

---

## Características
- Selección de palabras por categorías.
- Interfaz gráfica intuitiva construida con Swing.
- Mensajes interactivos que guían al jugador.
- Manejo de archivos para cargar palabras por categorías.
- Sistema de vida con barra de progreso.

---

## Tecnologías Utilizadas
- **Java 8 o superior**
- **Swing** para la interfaz gráfica
- **Gestión de archivos** para cargar las palabras desde archivos locales

---

## Instalación y Configuración

### Requisitos previos
- Tener instalado **Java 8** o una versión superior.
- Un entorno de desarrollo como **IntelliJ IDEA**, **Eclipse**, o simplemente un editor de texto con capacidad para compilar Java.

### Instrucciones
1. Clona este repositorio:
   ```bash
   git clone https://github.com/tu_usuario/juego-ahorcado.git
   ```
2. Abre el proyecto en tu IDE de preferencia.
3. Configura la ruta de los archivos de palabras en el código (ubicados en la carpeta `temas/`).
4. Ejecuta la clase `Main.java` para iniciar el juego.

---

## Uso
1. Inicia el programa ejecutando `Main.java`.
2. Aparecerá un menú inicial con tres opciones:
   - **Inicio:** Comienza una nueva partida.
   - **Ver Ficha Técnica:** Muestra información sobre los desarrolladores y el proyecto.
   - **Salir:** Cierra la aplicación.
3. Selecciona una categoría y comienza a adivinar las letras de la palabra secreta.
4. ¡Diviértete adivinando antes de quedarte sin intentos!

---

## Estructura del Proyecto
El proyecto contiene las siguientes clases principales:

### **Main.java**
Clase principal que inicializa el menú del juego y muestra la ficha técnica.

### **MenuInicial**
Muestra el menú principal con opciones para comenzar el juego, ver la ficha técnica o salir.

### **AhorcadoGUI**
Gestiona la interfaz gráfica del juego, mostrando el progreso, intentos restantes y mensajes interactivos.

### **JuegoAdivinanza**
Controla la lógica del juego, como la selección de palabras, manejo de intentos y estado del juego (ganado, perdido o en progreso).

### **Palabra**
Representa la palabra a adivinar, gestionando el progreso y verificando las letras ingresadas.

---

## Personalización
Puedes agregar nuevas categorías de palabras o modificar las existentes:
1. Navega a la carpeta `temas/`.
2. Abre o crea un archivo de texto con el nombre de la categoría (por ejemplo, `animales.txt`).
3. Añade palabras separadas por líneas.

---

## Ejemplo Visual
A continuación, un ejemplo de cómo se verá el juego:

```text
Progreso: _ _ _ _ _
Intentos restantes: 8
Categoría: Animales

¡Adivina una letra!
```

---

## Créditos
- **Product Owner:** Gisell Alexandra Anaya Santafé
- **Scrum Master:** Sergio Alejandro Villamizar Espinel
- **Desarrolladores:**
  - Jeison David Méndez Castro
  - Heidy Lizeth Conde Jaimes

---


## Contribuciones
¡Las contribuciones son bienvenidas! Por favor, sigue estos pasos:
1. Haz un fork del repositorio.
2. Crea una rama para tu funcionalidad (`git checkout -b nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -m 'Añadir nueva funcionalidad'`).
4. Envía un pull request para revisión.
