package net.erickpineda.juegodecartas;

public class Carta {
	/*
	 * Picas, Diamantes, Trebol, Corazón
	 */
	private String palo;
	/**
	 * Va de 1 a 12.
	 */
	private int cara;

	/**
	 * Constructor de la Carta.
	 * 
	 * @param tipoPalos
	 *            La carta será según Picas, Diamantes, Trebol, Corazón
	 * @param tipoCara
	 *            Los números de las cartas
	 */
	public Carta(final String tipoPalos, final int tipoCara) {
		this.cara = tipoCara;
		this.palo = tipoPalos;
	}

	/**
	 * Mostrar la cara de la carta.
	 * 
	 * @return Retorna un entero que será el número de la carta
	 */
	public int getValorCarta() {
		return this.cara;
	}

	/**
	 * Mostrar el tipo de palo de la carta.
	 * 
	 * @return Retorna el String del palo de la carta
	 */
	public String getPaloCarta() {
		return this.palo;
	}

	/**
	 * Concatena la cara y el palo de la carta.
	 */
	public String toString() {
		return this.cara + " de " + this.palo;
	}
}
