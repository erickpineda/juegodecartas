package net.erickpineda.juegodecartas;

/**
 * Programa que permeti simular el funcionament d'un joc de cartes anomenat «La
 * carta més alta».
 * 
 * @author Erick Pineda
 * 
 */
public class App {
	/**
	 * Nombres de los participantes
	 */
	private static String[] nombres = { "Tarma", "Marco", "Fio", "Eri", "Ryu" };

	/**
	 * Método principal del programa que crea el juego de la carta más alta.
	 */
	public static void main(String[] args) {

		Juego juego = new Juego(nombres);
		juego.iniciar();
	}
}
