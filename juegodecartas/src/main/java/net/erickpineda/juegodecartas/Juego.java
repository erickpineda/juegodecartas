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
	private static int masAlta;
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
	}

	/**
	 * Método que se encarga de las cláusulas de lectura y escritura del fichero
	 * y decide que ejecutar en cada momento. Por ejemplo: si no hay partida
	 * guardada de los jugadores la creará, en caso contrario leerá una
	 * existente. Siempre a cada final de lectura se elimina el fichero de la
	 * partida.
	 */
	public void iniciar() {

		miFichero = new File(saveGame);

		try {

			if (!miFichero.exists()) {
				// Creo el fichero y guardo los datos
				crearFichero();
				crearJugadores(0);
				partidaNueva();

			} else {
				// Abrir el fichero y leerlo
				abrirFichero();
				partidaAntigua();

			}

			getCartaAlta(jugones);

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
				// eliminarFichero(saveGame); // El fichero se eliminará siempre
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Método que serializa el juego o lo que sea serializable.
	 * 
	 * @throws IOException
	 *             Errores de excepciones.
	 * @throws ClassNotFoundException
	 *             El método jugar() se encarga de las cláusulas, si el nombre
	 *             de la clase no es encontrado.
	 */
	public static void crearFichero() throws IOException,
			ClassNotFoundException {

		fos = new FileOutputStream(miFichero);
		oos = new ObjectOutputStream(fos);
		oos.writeObject(jugones);

	}

	/**
	 * Método que deserializa la partida guardada del juego.
	 * 
	 * @throws ClassNotFoundException
	 *             El método jugar() se encarga de las cláusulas, si el nombre
	 *             de la clase no es encontrado.
	 * @throws IOException
	 *             Excepciones de error que se encarga el método jugar().
	 */
	public static void abrirFichero() throws ClassNotFoundException,
			IOException {

		System.out.println("\n**Ya existe una partida guardada del juego***\n");
		fis = new FileInputStream(miFichero);
		ois = new ObjectInputStream(fis);

		ois.readObject();

	}

	/**
	 * Método que crea los jugadores que participarán en el juego, con su
	 * respectivo dinero y carta.
	 * 
	 * @param pos
	 *            Posición desde donde se creará la partida. Ej: si hay 5
	 *            jugadores guardados y llegan 3 más, la posición seria 5. Por
	 *            lo menos para <strong>mi programa que solo implementa un array
	 *            String con todos los nombres de los jugadores</strong>.
	 */
	public static void crearJugadores(int pos) {

		Carta carta;

		System.out.println("-->> PARTICIPANTES\n");

		for (int i = pos; i < nombresJugadores.length; i++) {
			// Se descuenta una carta
			carta = baraja.repartirCartas();
			jugones.add(new Jugador(nombresJugadores[i], getDinero(4), carta));

		}
	}

	/**
	 * Método que crea una nueva partida si no existe una partida guardada.
	 * 
	 * @throws IOException
	 *             Excepciones de error, el método jugar() se encarga de las
	 *             cláusulas para la escritura y lectura de un fichero.
	 */
	public static void partidaNueva() throws IOException {

		oos.writeObject(jugones.get(0)); // Guardo el primer jugador

		for (Jugador j : jugones)
			System.out.println(j);
	}

	/**
	 * Calculará la carta más alta entre los jugadores para decidir el ganador.
	 * 
	 * @param lista
	 *            Pasa por parámetro lo que será la lista de los jugadores ya
	 *            creados en algún momento.
	 */
	public static void getCartaAlta(List<Jugador> lista) {
		Jugador j = null;

		for (int i = 0; i < lista.size(); i++) {
			int miCarta = lista.get(i).getCartaJugador().getValorCarta();

			if (miCarta > masAlta) {
				masAlta = miCarta;
				j = lista.get(i);
			}
			System.out.println("*** FALTA IMPLEMENTAR ***");
		}
		System.out.println("\n--> El ganador es:");
		System.out.println(j + "\n");
	}

	/**
	 * Siempre que exista una partida guardada del juego se reanudará y volverá
	 * a crear una partida, junto con el/los jugador/es existente/s.
	 * 
	 * @throws IOException
	 *             Excepciones de error, el método jugar() se encarga de las
	 *             cláusulas para la escritura y lectura de un fichero.
	 * @throws ClassNotFoundException
	 *             El método jugar() se encarga de las cláusulas, si el nombre
	 *             de la clase no es encontrado.
	 */
	public static void partidaAntigua() throws ClassNotFoundException,
			IOException {

		Jugador jugadorExistente = (Jugador) ois.readObject();
		jugones.add(jugadorExistente);

		System.out.println("- Jugador Existente: " + "\n" + jugadorExistente + "\n");

		// Vuelta a crear los jugadores desde el punto de guardado
		crearJugadores(1);

		for (Jugador j : jugones) {
			if (!jugadorExistente.equals(j)) {
				System.out.println("- Nuevo* " + j);
			}
		}

	}

	/**
	 * Método que se encarga de eliminar el fichero de la partida.
	 * 
	 * @param pathFile
	 *            Ubicacion en String del fichero.
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
	 *            Un número entero, que limita el máximo de dinero para un
	 *            jugador.
	 * @return retorna un número entero entre 1 y el máximo.
	 */
	public static int getDinero(final int numero) {
		return rand.nextInt(numero) + 1;
	}
}
