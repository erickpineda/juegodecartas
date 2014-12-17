package net.erickpineda.juegodecartas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Juego {

	private static List<Jugador> jugones;

	private static int DINERO_TOTAL;

	private static Carta masAlta;

	private static Random rand = new Random();

	/**
	 * Método que se encarga de construir el orden del juego.
	 */
	public Juego() {
		jugones = new ArrayList<Jugador>();
		String[] nombres = { "Tarma", "Marco", "Fio", "Eri" };
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

		Carta cartas;

		for (int i = 0; i < nombres.length; i++) {
			cartas = baraja.repartirCartas();

			jugones.add(new Jugador(nombres[i], getDinero(4), cartas));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(jugones.get(i));
		}
	}

	/**
	 * Método que calcula el jugador con la carta más alta.
	 */
	public void cartaMasAlta() {
		Carta miCarta = jugones.get(0).getCartaJugador();

		for (int pos = 1; pos < jugones.size(); pos++) {

			System.out.println("--->> Falta implementar");
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
