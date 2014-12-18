package net.erickpineda.juegodecartas;

import java.io.Serializable;

public class Carta implements Serializable {
	/**
	 * Identificador de la clase.
	 */
	private static final long serialVersionUID = -7334904955252156074L;
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
	 * Método que cambia el valor de una carta.
	 * 
	 * @param v
	 *            Nuevo valor que tendrá la carta
	 */
	public void setValorCarta(int v) {
		this.cara = v;
	}

	/**
	 * Método que cambia el palo de una carta.
	 * 
	 * @param p
	 *            Nombre del palo que será la carta
	 */
	public void setPaloCarta(String p) {
		this.palo = p;
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
