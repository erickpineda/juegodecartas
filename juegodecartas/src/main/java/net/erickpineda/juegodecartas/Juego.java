package net.erickpineda.juegodecartas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Juego {
	/**
	 * Lista de jugadores que participan en el juego.
	 */
	private static List<Jugador> jugones;
	/**
	 * Pote de dinero para el ganador o ganadores.
	 */
	@SuppressWarnings("unused")
	private static int DINERO_TOTAL;
	/**
	 * Carta más alta entre los Jugadores.
	 */
	@SuppressWarnings("unused")
	private static Carta masAlta;
	/**
	 * Nombre del fichero donde se guardará la partida.
	 */
	private static String saveGame = "SaveGame";
	/**
	 * Fichero de texto que guarda la partida.
	 */
	private static File miFichero;
	/**
	 * Generar número aleatorio.
	 */
	private static Random rand = new Random();
	/**
	 * Fichero de salida a crear.
	 */
	private static FileOutputStream fos = null;
	/**
	 * Escritura del fichero.
	 */
	private static ObjectOutputStream oos = null;
	/**
	 * Fichero de entrada a leer.
	 */
	private static FileInputStream fis = null;
	/**
	 * Lectura del fichero.
	 */
	private static ObjectInputStream ois = null;
	/**
	 * Baraja de cartas del juego.
	 */
	private static Baraja baraja;
	/**
	 * Nombres que llevaran los jugadores.
	 */
	private static String[] nombresJugadores;

	/**
	 * Método que se encarga de construir el orden del juego.
	 * 
	 * @param nombres
	 *            Array de string que contendrá los nombres de los
	 *            participantes.
	 */
	public Juego(String[] nombres) {
		jugones = new ArrayList<Jugador>();
		nombresJugadores = nombres;
		baraja = new Baraja();
		jugar();
	}

	/**
	 * Método que se encarga de las cláusulas de lectura y escritura del fichero
	 * y decide que ejecutar en cada momento. Por ejemplo: si no hay partida
	 * guardada de los jugadores la creará, en caso contrario leerá una
	 * existente. Siempre a cada final de lectura se elimina el fichero de la
	 * partida.
	 */
	public void jugar() {

		miFichero = new File(saveGame);

		try {

			if (!miFichero.exists()) {
				// Creo el fichero y guardo los datos
				crearFichero();
			} else {
				// Abrir el fichero y leerlo
				abrirFichero();

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null)
					oos.close();
				if (ois != null)
					ois.close();
				eliminarFichero(saveGame); // El fichero se eliminará siempre
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Método que serializa el juego o lo que sea serializable.
	 * 
	 * @throws IOException
	 *             Errores de excepciones
	 * @throws ClassNotFoundException
	 *             El método jugar() se encarga de las cláusulas, si el nombre
	 *             de la clase no es encontrado
	 */
	public static void crearFichero() throws IOException,
			ClassNotFoundException {

		fos = new FileOutputStream(miFichero);
		oos = new ObjectOutputStream(fos);

		partidaNueva();
	}

	/**
	 * Método que deserializa la partida guardada del juego.
	 * 
	 * @throws ClassNotFoundException
	 *             El método jugar() se encarga de las cláusulas, si el nombre
	 *             de la clase no es encontrado
	 * @throws IOException
	 *             Excepciones de error que se encarga el método jugar()
	 */
	public static void abrirFichero() throws ClassNotFoundException,
			IOException {

		System.out.println("**Ya existe una partida guardada del juego***");
		fis = new FileInputStream(miFichero);
		ois = new ObjectInputStream(fis);

		ois.readObject();
		partidaAntigua(0); // Carga la partida donde haya quedado
	}

	/**
	 * Método que crea los jugadores que participarán en el juego, con su
	 * respectivo dinero y carta.
	 * 
	 * @throws IOException
	 *             El método jugar() se encarga de las cláusulas para la
	 *             escritura y lectura del fichero
	 */
	public static void guardarJugadores() throws IOException {

		Carta cartas;

		for (int i = 0; i < nombresJugadores.length; i++) {
			cartas = baraja.repartirCartas();

			jugones.add(new Jugador(nombresJugadores[i], getDinero(4), cartas));
			System.out.println(jugones.get(i));
		}
		oos.writeObject(jugones.get(0)); // Guardo el primer jugador
	}

	/**
	 * Método que calcula el jugador con la carta más alta, cuando no existe el
	 * fichero.
	 * 
	 * @throws IOException
	 *             Excepciones de error, el método jugar() se encarga de las
	 *             cláusulas para la escritura y lectura de un fichero
	 */
	public static void partidaNueva() throws IOException {

		guardarJugadores();

		for (int i = 0; i < jugones.size(); i++) {
			System.out.println("--->> Falta implementar");
		}
	}

	/**
	 * Método que calcula el jugador con la carta más alta, cuando lee una
	 * partida guardada.
	 * 
	 * @param pos
	 *            Posición en que ha quedado guardada la partida
	 */
	public static void partidaAntigua(int pos) {
		// Carta miCarta = jugones.get(0).getCartaJugador();

		for (int i = pos; i < 10; i++) {

			System.out.println("--->> Falta implementar");
		}

	}

	/**
	 * Método que se encarga de eliminar el fichero de la partida.
	 * 
	 * @param pathFile
	 *            Ubicacion en String del fichero
	 */
	public static void eliminarFichero(String pathFile) {
		File f = new File(pathFile);

		if (f.delete()) {
			System.out.println(pathFile + " se ha borrado correctamente!");
		} else {
			System.out.println(pathFile + " no se ha podido borrar!");
		}
	}

	/**
	 * Método que genera un número aleatorio, que será el dinero de los
	 * jugadores.
	 * 
	 * @param numero
	 *            Parámetro a pasar, que será el máximo de dinero para un
	 *            jugador
	 * @return retorna un número entero entre 1 y el máximo
	 */
	public static int getDinero(final int numero) {
		return rand.nextInt(numero) + 1;
	}
}
