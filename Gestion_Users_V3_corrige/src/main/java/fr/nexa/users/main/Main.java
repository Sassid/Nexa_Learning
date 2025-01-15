package fr.nexa.users.main;

import fr.nexa.users.entity.User;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			
			
//			String texte = toUpperText("bonjour");
//			System.out.println(texte);
//
//			int a = 3;
//			int b = --a;
//			int c = a--;
//			System.out.println(a + " | " + b + " | " + c);
//			
//			boolean isComplete = false;
//			String resultat;
//			if (isComplete) {
//				resultat = "Complet";
//			} else {
//				resultat = "Dispo";
//			}
//			System.out.println(resultat);
//			
//			String resultat2 = isComplete ? "Complet" : "Dispo";
//			System.out.println(resultat2);
			
			try {
				int a = Integer.valueOf("abc");
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Permet de transformer tout le texte en majuscules.
	 * @param text : Le texte à transformer en majuscules.
	 * @return Le texte en majuscules.
	 * @throws Exception :
	 * <ul>
	 * 	<li> Si le texte d'entrée est NULL.</li>
	 *  <li> Si le texte d'entrée est vide.</li>
	 * </ul>
	 * @author Ryadh.
	 * @since 2025-01-13
	 * @see Main#toLowerText(String)
	 */
	public static String toUpperText(String text) throws Exception {
		if (text == null) {
			throw new NullPointerException("le texte est obligatoire !");
		}
		if (text.isBlank()) {
			throw new IllegalArgumentException("Le texte ne doit être vide !");
		}
		return text.toUpperCase();
	}
	
	/**
	 * Permet de transformer tout le texte en miniscules.
	 * @param text : Le texte à transformer en miniscules.
	 * @return Le texte en miniscules.
	 * @throws Exception :
	 * <ul>
	 * 	<li> Si le texte d'entrée est NULL.</li>
	 *  <li> Si le texte d'entrée est vide.</li>
	 * </ul>
	 * @author Ryadh.
	 * @since 2025-01-13
	 * @see Main#toUpperText(String)
	 */
	public static String toLowerText(String text) {
		if (text == null) {
			throw new NullPointerException("le texte est obligatoire !");
		}
		if (text.isBlank()) {
			throw new IllegalArgumentException("Le texte ne doit être vide !");
		}
		return text.toLowerCase();
	}
}
