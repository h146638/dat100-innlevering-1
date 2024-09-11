/* Navn: 	 			Jørgen Haukeland
 * Studentnr: 			146638 
 * Opprettet:			10.09.2024
 * Sist redigert: 		11.09.2024
 * Oppgave:				O1 - Trinnskatt
 */

package no.hvl.dat100;

import static java.lang.Double.*;

import java.util.Scanner;

public class O1 {
	public static void main(String[] args) {
		double tall1 = -1;
		double tall2 = 0;
		// variabler for trinnskatt for raskere håndtering senere
		double trinn1 = 1441.6; //denne gav opprinnelig avrundingsfeil, så verdien er skrevet inn som den er og ikke multiplisert slik som de andre.
		double trinn2 = 377150 * 0.04;
		double trinn3 = 267900 * 0.136;
		double trinn4 = 412100 * 0.166;
		long sumskatt = 0; //for beregning og desimal-håndtering senere.
		
		Scanner input = new Scanner(System.in);
		System.out.println("Beregning av trinnskatt\nBruttoinntekt: ");
		String tall1Txt = input.next();
		input.close();
		tall1 = parseDouble(tall1Txt);
		System.out.println("Registrert bruttoinntekt: " + tall1);

		if (tall1 < 208050)
			System.out.println("Ingen trinnskatt");
		else {
			tall2 = tall1;
			tall1 = tall1 - 208050;

			while (tall1 > 0) {  
				tall1 -= 84800; //trinn 1 skatt. Om skatten ikke oppnådde trinn 2 så blir 84800 blitt lagt til på nytt.

				if (tall1 <= 0) { 
					tall1 += 84800;
					System.out.println("oppnådd trinn 1 og må skatte på " + tall2 + "\nhvor det blir " + tall1 * 0.017
							+ " i skatt");
					sumskatt += (tall1 * 0.017) + 0.5;
					System.out.println("**********\nTotalt: " + sumskatt + " i skatt");
					tall1 = -1;
					
				} else {
					tall1 -= 377150; // trinn 2 skatt

					if (tall1 <= 0) {
						tall1 += 377150;
						System.out.println("oppnådd trinn 2 og må skatte på " + tall2 + "\nhvor det blir \n"
								+ tall1 * 0.04 + " i trinn 2 skatt\n" + trinn1 + " i trinn 1 skatt");
						sumskatt += trinn1 + (tall1 * 0.04) + 0.5;
						System.out.println("**********\nTotalt: " + sumskatt + " i skatt");
						tall1 = -1;
						
					} else {
						tall1 -= 267900; // trinn 3 skatt

						if (tall1 <= 0) {
							tall1 += 267900;
							System.out.println("oppnådd trinn 3 og må skatte på " + tall2 + "\nhvor det blir \n"
									+ tall1 * 0.136 + " i trinn 3 skatt\n" + trinn2 + " i trinn 2 skatt\n" + trinn1
									+ " i trinn 1 skatt");
							sumskatt += trinn2 + trinn1 + (tall1 * 0.136) + 0.5;
							System.out.println("**********\nTotalt: " + sumskatt + " i skatt");
							tall1 = -1;
						} else {
							tall1 -= 412100; // trinn 4 skatt

							if (tall1 <= 0) {
								tall1 += 412100;
								System.out.println("oppnådd trinn 4 og må skatte på " + tall2 + "\nhvor det blir "
										+ tall1 * 0.166 + " i trinn 4 skatt\n" + trinn3 + " i trinn 3 skatt\n" + trinn2
										+ " i trinn 2 skatt\n" + trinn1 + " i trinn 1 skatt");
								sumskatt += trinn3 + trinn2 + trinn1 + (tall1 * 0.166) + 0.5;
								System.out.println("**********\nTotalt: " + sumskatt + " i skatt");
								tall1 = -1; 
							} else { // trinn 5 skatt

								System.out.println("oppnådd trinn 5 og må skatte på " + tall2 + "\nhvor det blir "
										+ tall1 * 0.176 + " i trinn 5 skatt\n" + trinn4 + " i trinn 4 skatt\n" + trinn3
										+ " i trinn 3 skatt\n" + trinn2 + " i trinn 2 skatt\n " + trinn1
										+ " i trinn 1 skatt");
								sumskatt += trinn4 + trinn3 + trinn2 + trinn1 + (tall1 * 0.176) + 0.5;
								System.out.println("**********\nTotalt: " + sumskatt + " i skatt");
								tall1 = -1;
							}

						}

					}

				}
			}

		}
	}
}
