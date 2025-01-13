package fr.nexa.users.main;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello, World !");
		try {
			String texte = toUpperText("Hiya !");
			
			byte ah = 6;
			short bh = 5;
			int ch = 7;
			
			long d = 21347865432L;
			float val1 = 5.00F;
			double val2 = 65845.25D;
			
			char ca = 'a';
			
			boolean log = true;
			
			BigDecimal bg;
			BigInteger bi;
			
			/*
			 * Warning :
			 * int a = 3;
			 * int b = a++;
			 * system.out.printable(a + " | " + b )
			 * 
			 * int a = 3;
			 * int b = ++a;
			 * system.out.printable(a + " | " + b)

			 */
			
			int a = 3;
			int b = --a;
			int c = a--;
			System.out.println(a + " | " + b + " | " + c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Makes a text in upper case.
	 * @param texte : text to be transformed.
	 * @return the upper case text.
	 * @throws Exception : 
	 * <ul>
	 * 	<li> if the input is NULL.
	 * 	<li> if the input is empty.
	 * </ul>
	 * @author Sassid.
	 * @since 2025-01-13.
	 * @see Main#toLowerText(String)
	 */
	public static String toUpperText(String texte) throws Exception {
		if (texte == null ) {
			throw new NullPointerException("the text is mandatory !");
		}
		if (texte.isBlank()) {
			throw new IllegalArgumentException("the text cannot be empty !");
		}
		return texte.toUpperCase();
	}
	
	/**
	 * Makes a text in lower case.
	 * @param texte : text to be transformed.
	 * @return the lower case text.
	 * @throws Exception : 
	 * <ul>
	 * 	<li> if the input is NULL.
	 * 	<li> if the input is empty.
	 * </ul>
	 * @author Sassid.
	 * @since 2025-01-13.
	 * @see Main#toUpperText(String)
	 */
	public static String toLowerText(String texte) throws Exception {
		if (texte == null ) {
			throw new NullPointerException("the text is mandatory !");
		}
		if (texte.isBlank()) {
			throw new IllegalArgumentException("the text cannot be empty !");
		}
		return texte.toLowerCase();
	}

}

