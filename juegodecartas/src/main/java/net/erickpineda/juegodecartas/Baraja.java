package net.erickpineda.juegodecartas;

import java.util.ArrayList;

public class Baraja {
	// Una lista de cartas
	private ArrayList<Carta> baraja = null;

	// Tipo de cara para la carta
	private int[] caras;

	// Tipo de palo para las cartas
	private String[] palos = { "Oros", "Bastos", "Espadas", "Copas" };

	// Cartas que sobraran
	private int cartasRestantes;

	// Cantidad de cartas a crear
	private int NUMERO_DE_CARTAS = 48;

	/**
	 * Constructor de Baraja de cartas
	 */
	public Baraja() {
		this.baraja = new ArrayList<Carta>(NUMERO_DE_CARTAS);
		cartasRestantes = 0;

		// Agrego las cartas a la baraja
		for (int i = 0; i < palos.length; i++) {
			for (int j = 1; j <= 12; j++) {
				baraja.add(new Carta(palos[i], caras[j]));
			}
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

}
