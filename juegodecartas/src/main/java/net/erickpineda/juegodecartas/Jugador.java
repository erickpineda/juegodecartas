package net.erickpineda.juegodecartas;

import java.io.Serializable;

public class Jugador {

	/**
	 * Nombre que tendrá el jugador
	 */
	private String nombreJugador;
	/**
	 * Dinero en monedas del jugador
	 */
	private int monedas;
	/**
	 * Carta que se le dará al jugador.
	 */
	private Carta carta;

	/**
	 * Constructor para el jugador.
	 * 
	 * @param nombre
	 *            Nombre que recibira el jugador
	 * @param dinero
	 *            Dinero que tendra el jugador
	 */
	public Jugador(final String nombre, final int dinero) {
		this.nombreJugador = nombre;
		this.monedas = dinero;
	}

	/**
	 * Constructor para el jugador con carta en mano.
	 * 
	 * @param nombre
	 *            nombre que tendrá el jugador
	 * @param dinero
	 *            dinero en monedas del jugador
	 * @param miCarta
	 *            carta a dar para el jugador
	 */
	public Jugador(final String nombre, final int dinero, final Carta miCarta) {
		this.nombreJugador = nombre;
		this.monedas = dinero;
		this.carta = miCarta;
	}

	/**
	 * Cambia la carta que tiene el jugador.
	 * 
	 * @param i
	 *            posicion en mano del jugador
	 * @param c
	 *            carta a cambiar
	 */
	public void setCarta(int i, Carta c) {
		this.carta = c;
	}

	/**
	 * Método que retorna el nombre del jugador.
	 * 
	 * @return retorna el nombre del jugador
	 */
	public String getNombre() {
		return this.nombreJugador;
	}

	/**
	 * Método que retorna el dinero en monedas del jugador.
	 * 
	 * @return retorna un entero, que será el dinero del jugador
	 */
	public int getDinero() {
		return this.monedas;
	}

	/**
	 * Método que retorna a la carta en mano del Jugador.
	 * 
	 * @return retorna la carta en mano del jugador
	 */
	public Carta getCartaJugador() {
		return this.carta;
	}

	/**
	 * Método que concatena el jugador, dinero en monedas y carta en mano de
	 * éste.
	 */
	public String toString() {
		return this.getNombre() + " tiene " + this.getDinero()
				+ " moneda(s) y " + this.getCartaJugador();
	}

}
