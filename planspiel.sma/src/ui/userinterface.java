package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import facade.gamecontroller;

public class userinterface {
	Scanner scan = new Scanner(System.in);
	private int textSpeed = 75;
	gamecontroller game = new gamecontroller();

	public void startGame() {
		print("Willkomen! ");
		// asignRoles();
		print("Sie können nun aus 5 verschiedenen Szenarien wählen");
		System.out.println("_________________________________________________");
		print("1. Daten im Darknet veröffentlicht");
		print("2. Ein Zulieferer wurde gehackt");
		print("3. Gestörte Windkraftanlagen");
		print("4. Diebstahl von 30 Bitcoin");
		print("5. Mitarbeiter verliert USB-Stick");
		int wahl = Integer.parseInt(scan.nextLine()) - 1;

	}

	public void asignRoles() {
		String[] roles = { "Geschäftsleitung", "Informationssicherheitsbeauftragter", "Datenschutzbeauftragter",
				"Anwalt", "Head of Human Resources", "Head of Marketing" };
		ArrayList<Integer> choosen = new ArrayList<Integer>();
		ArrayList<String> roleList = new ArrayList<String>(Arrays.asList(roles));
		print("Mit wie vielen Spielern möchten sie Spielen? (2mind - 6max)");
		int anzahl = Integer.parseInt(scan.nextLine()) - 1;
		for (int i = 0; i < anzahl; i++) {
			System.out.println("");
			System.out.println("Spieler " + (i + 1) + " wählen sie ihren Namen! ");
			print("Name: - ");
			String name = scan.nextLine();

			for (int n = 0; n < roleList.size(); n++) {
				if (choosen.contains(n)) {
					System.out.println((n + 1) + ". -" + " vergriffen"); // evtl Rot printen kein plan jo
				} else {
					System.out.println((n + 1) + ". -" + roles[n]);
				}
			}
			int wahl = Integer.parseInt(scan.nextLine()) - 1;
			choosen.add(wahl);
			game.asignRoles(name, wahl);
		}
		printRoles();
	}

	private void printRoles() {
		print("Ihre gewählten Namen und Rollen: ");
		String[][] arr = game.getRoleArray();
		for (int i = 0; i < 6; i++) {
			System.out.print((i + 1) + ". " + arr[i][0]);
			System.out.println(" -" + arr[i][1]);
		}
	}

	private void print(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
			try {
				Thread.sleep(textSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		System.out.println("");
	}

}
