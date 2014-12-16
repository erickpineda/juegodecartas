package net.erickpineda.juegodecartas;

import java.util.ArrayList;

public class Baraja {
	/**
	 * Una lista de cartas
	 */
	private ArrayList<Carta> baraja = null;

	/**
	 * Tipo de cara para la carta
	 */
	private int[] caras;

	/**
	 * Tipo de palo para las cartas
	 */
	private String[] palos = { "Oros", "Bastos", "Espadas", "Copas" };

	/**
	 * Cartas que sobraran
	 */
	private int cartasRestantes;

	/**
	 * Cantidad de cartas a crear
	 */
	private int NUMERO_DE_CARTAS = 48;

	/**
	 * Constructor de Baraja de cartas
	 */
	public Baraja() {
		this.baraja = new ArrayList<Carta>(NUMERO_DE_CARTAS);
		this.caras = new int[12];
		cartasRestantes = 0;

		// Agrego las cartas a la baraja
		for (int i = 0; i < palos.length; i++) {
			for (int j = 1; j <= caras.length; j++) {
				baraja.add(new Carta(palos[i], j));
			}
		}

		// Barajo las cartas para que se cree aleatoriamente
		for (int i = 0; i < baraja.size(); i++) {
			int cartaAleatoria1 = (int) (Math.random() * NUMERO_DE_CARTAS);
			int cartaAleatoria2 = (int) (Math.random() * NUMERO_DE_CARTAS);

			Carta cambio = (Carta) baraja.get(cartaAleatoria2);

			baraja.set(cartaAleatoria2, baraja.get(cartaAleatoria1));
			baraja.set(cartaAleatoria1, cambio);

		}
	}

	/**
	 * Descontar las cartas de la baraja al repartirlas.
	 * 
	 * @return retorna a la cantidad actual de la baraja
	 */
	public Carta repartirCartas() {
		cartasRestantes++;
		return baraja.remove(baraja.size() - 1);
	}

	/**
	 * Tamaño de la baraja que se crea.
	 * 
	 * @return retorna un número entero que será el tamaño actual de la baraja
	 */
	public int getSizeBaraja() {
		return baraja.size();
	}

	/**
	 * Método que se encarga de agregar una carta a la baraja.
	 * 
	 * @param miCarta
	 *            parámetro de la carta
	 */
	public void darCarta(Carta miCarta) {
		baraja.add(miCarta);
	}

	/**
	 * Método que retorna la cantidad de cartas restantes.
	 * 
	 * @return retorna un número entero para las cartas restantes en la baraja.
	 */
	public int getCartasRestantes() {
		return (NUMERO_DE_CARTAS - cartasRestantes);
	}

}
