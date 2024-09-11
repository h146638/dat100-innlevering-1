/* Navn: 	 			Jørgen Haukeland
 * Studentnr: 			146638 
 * Opprettet:			10.09.2024
 * Sist redigert: 		11.09.2024
 * Oppgave:				O2 - Karakterskala
 */
package no.hvl.dat100;

import java.util.Scanner;

public class O2 {

	public static void main(String[] args) {

		int p = -1; // p for poeng
		char k = 'F'; // k for karakter
		boolean loop = true; // while-løkke check
		int s = 1; // student nr

		Scanner input = new Scanner(System.in);
		System.out.println(
				"Skriv inn dine poeng her: (0-100) \nbokstaver avslutter programmet\n******************\nPoeng:");
		String tall1Txt;
		
		while (loop == true) {
			tall1Txt = input.next();
			try {
				p = Integer.parseInt(tall1Txt);
			} catch (NumberFormatException e) {
				System.out.println("*Program avsluttes*");
				break;
			}
			if (p > 100 || p < 0) {
				System.out.println("Prøv på nytt");
				s--; //korrigerer for telling
			} else if (p < 40) {
				k = 'F';
				System.out.println("Student " + s + " får karakter: " + k);
			} else if (p < 50) {
				k = 'E';
				System.out.println("Student " + s + " får karakter: " + k);
			} else if (p < 60) {
				k = 'D';
				System.out.println("Student " + s + " får karakter: " + k);
			} else if (p < 80) {
				k = 'C';
				System.out.println("Student " + s + " får karakter: " + k);
			} else if (p < 90) {
				k = 'B';
				System.out.println("Student " + s + " får karakter: " + k);
			} else if (p < 101) {
				k = 'A';
				System.out.println("Student " + s + " får karakter: " + k);
			}

			else { //denne blir trolig ikke brukt pga try-catch, men... 
				System.out.println("Ugyldig verdi, program avsluttes");
				loop = false;
			}
			s++; //neste student

		}

		input.close();

	}

}
