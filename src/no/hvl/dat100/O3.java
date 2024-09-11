/* Navn: 	 			Jørgen Haukeland
 * Studentnr: 			146638 
 * Opprettet:			11.09.2024
 * Sist redigert: 		11.09.2024
 * Oppgave:				O3 - Fakultet
 */
package no.hvl.dat100;

import java.util.Scanner;

public class O3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Skriv tall du vil finne fakultet av. \n(over 170! gir 'infinity'): ");
		String tall1Txt = input.next();
		input.close();
		int tall1 = Integer.parseInt(tall1Txt);
		System.out.println("Registrert : " + tall1 + "!");
		double sum = tall1;

		for (int i = tall1 - 1; i > 0; i--) {
			sum = sum * i;
		}
		if (tall1 < 15) { // fjerner desimal tall på mindre fakultet
			System.out.println("sum: " + String.format("%.0f", sum));
			
		} 
		else { // tall blir såpass store her, at vi vil ikke formatere vekk fra å få potens i
			   // svaret, f.eks 17! gir 3.5568...E14
			System.out.println("sum: " + sum);
		}

	}
}