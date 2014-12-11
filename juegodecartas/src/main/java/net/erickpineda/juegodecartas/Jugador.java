package net.erickpineda.juegodecartas;

import java.io.Serializable;

public class Jugador{
	
	/**
	 * Nombre que tendrá el jugador
	 */
	private String nombreJugador;
	/**
	 * Dinero en monedas del jugador
	 */
	private int monedas;
	
	public Jugador(final String nombre, final int dinero){
		nombreJugador = nombre;
		monedas = dinero;
	}
	
	
	
}
