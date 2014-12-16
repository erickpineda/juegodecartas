package net.erickpineda.juegodecartas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Programa que permeti simular el funcionament d'un joc de cartes anomenat «La
 * carta més alta».
 * 
 * @author Erick Pineda
 * 
 */
public class App {
	private static List<Jugador> jugones;

	private static int DINERO_TOTAL;

	private static Random rand = new Random();

	public static void main(String[] args) {
		App ejec = new App();
		ejec.juego();
	}

	/**
	 * Método que se encarga de construir el orden del juego.
	 */
	public void juego() {
		String[] nombres = { "Personaje 1", "Personaje 2", "Personaje 3",
				"Personaje 4" };
		Baraja baraja = new Baraja();

		crearJugadores(nombres, baraja);
		cartaMasAlta();
	}

	/**
	 * Método que crea los jugadores que participarán en el juego, con su
	 * respectivo dinero y carta.
	 * 
	 * @param nombres
	 *            Nombre que tendra el jugador que participa en el juego
	 * @param baraja
	 *            Baraja del juego al pasarla por parámetro
	 */
	public void crearJugadores(String[] nombres, Baraja baraja) {
		jugones = new ArrayList<Jugador>();
		Carta cartas;

		for (int i = 0; i < nombres.length; i++) {
			cartas = baraja.repartirCartas();

			jugones.add(new Jugador(nombres[i], getDinero(4), cartas));

		}
	}

	/**
	 * Método que calcula el jugador con la carta más alta.
	 */
	public void cartaMasAlta() {

		Iterator<Jugador> itera = jugones.iterator();
		int pos = 0;
		while (itera.hasNext()) {
			Jugador j = itera.next();

			System.out.println(jugones.get(pos).toString());
			pos++;

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
