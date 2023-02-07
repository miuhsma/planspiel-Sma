package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import domain.Rolle;
import facade.gamecontroller;

public class userinterface {
	Scanner scan = new Scanner(System.in);
	private int textSpeed = 75;
	gamecontroller game = new gamecontroller();

	public void startGame() {
		game.createRoles();
		boolean bool = true;
		print("Willkommen !");
		while (bool) {
			System.out.println("");
			print("1. Spiel starten ");
			print("2. Einstellungen");
			print("3. Authoren");
			print("4. Beenden");
			int wahl = Integer.parseInt(scan.nextLine());
			switch (wahl) {
			case 1:
				System.out.println("____________________");
				print("Spiel starten !");
				asignRoles();
				playScenario();
				break;
			case 2:
				System.out.println("____________________");
				print("Einstellungen");
				settings();
				break;
			case 3:
				authoren();
				break;
			case 4:
				System.out.println("_______________________");
				print("Spiel beenden, tschüss! ");
				bool = false;
			}
		}

	}

	public void settings() {
		print("1. Text-speed");
		print("2. zurück");
		int wahl = Integer.parseInt(scan.nextLine());
		switch (wahl) {
		case 1:
			changeTextSpeed();
			break;
		case 2:
			break;
		}
	}

	public void changeTextSpeed() {
		print("Text-Speed: " + textSpeed);
		print("Geben sie den neuen TextSpeed ein");
		textSpeed = Integer.parseInt(scan.nextLine());
	}

	public void playScenario() {
		print("Sie können nun aus 5 verschiedenen Szenarien wählen");
		System.out.println("=============================================");
		print("1. Daten im Darknet veröffentlicht");
		System.out.println("---------------------------------------------");
		print("2. Ein Zulieferer wurde gehackt");
		System.out.println("---------------------------------------------");
		print("3. Gestörte Windkraftanlagen");
		System.out.println("---------------------------------------------");
		print("4. Diebstahl von 30 Bitcoin");
		System.out.println("---------------------------------------------");
		print("5. Mitarbeiter verliert USB-Stick");
		System.out.println("---------------------------------------------");
		int wahl = Integer.parseInt(scan.nextLine()) - 1;

		switch (wahl) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		}
	}

	public void playScenario3() {

	}

	public void asignRoles() {
		String[] roles = { "Geschäftsleitung", "Informationssicherheitsbeauftragter", "Datenschutzbeauftragter",
				"Anwalt", "Head of Human Resources", "Head of Marketing" };
		ArrayList<Integer> choosen = new ArrayList<Integer>();
		ArrayList<String> roleList = new ArrayList<String>(Arrays.asList(roles));
		print("Mit wie vielen Spielern möchten sie Spielen? (2mind - 6max)");
		int anzahl = Integer.parseInt(scan.nextLine());

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
		ArrayList<Rolle> allRoles = game.getRoles();
		for (Rolle i : allRoles) {
			if (i.getSpielername() != null) {
				System.out.println(i.getId() + ": " + i.getName() + " - " + i.getSpielername());
			}
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

	public void authoren() {
		System.out.println();
		System.out.println("Authoren:");
		print("Lukas Siegle");
		print("Carlo Bauer");
		print("Sven Schlicksupp");
		print("Vincent Leber");
		print("Mike Ullrich");
		print("Petar");
		System.out.println();
		print("Sma - Planspiel WS22/23");

	}

}
