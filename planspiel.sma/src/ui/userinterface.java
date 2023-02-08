package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import domain.Rolle;
import facade.gamecontroller;

public class userinterface {
	Scanner scan = new Scanner(System.in);
	private int textSpeed = 1;
	private String message;
	gamecontroller game = new gamecontroller();

	public void startGame() {
		game.createRoles();
		boolean bool = true;
		print("Willkommen !");
		while (bool) {
			System.out.println("");
			message = "1. Spiel starten\n2. Einstellungen\n3. Autoren\n4. Beenden";
			print(message);
			int wahl = validateInput(message, x -> x >= 1 && x <= 4);
			
			switch (wahl) {
			case 1:
				System.out.println("____________________");
				print("Spiel starten !");
				assignRoles();
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
		message = "1. Text-speed\n2. Zurück";
		print(message);
		
		int wahl  = validateInput(message, x -> x == 1 || x == 2);
		switch (wahl) {
		case 1:
			changeTextSpeed();
			break;
		case 2:
			break;
		}
	}

	public void changeTextSpeed() {
		message = "Geben sie den neuen TextSpeed ein (Zwischen 10 und 100)";
		print("Text-Speed: " + textSpeed);
		print(message);
		textSpeed = validateInput(message, x -> x >= 10 &&  x <= 100);
		
	}

	public void playScenario() {
		message = "Sie können nun aus 5 verschiedenen Szenarien wählen\n" + 
                "=============================================\n" +
                "1. Daten im Darknet veröffentlicht\n" + 
                "---------------------------------------------\n" +
                "2. Ein Zulieferer wurde gehackt\n" + 
                "---------------------------------------------\n" +
                "3. Gestörte Windkraftanlagen\n" + 
                "---------------------------------------------\n" +
                "4. Diebstahl von 30 Bitcoin\n" + 
                "---------------------------------------------\n" +
                "5. Mitarbeiter verliert USB-Stick\n" + 
                "---------------------------------------------\n";

		print(message);

		int wahl = validateInput(message, x -> (x > 0 && x < 5)) - 1;
		 
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

	public void assignRoles() {
		String[] roles = { "Geschäftsleitung", "Informationssicherheitsbeauftragter", "Datenschutzbeauftragter",
				"Anwalt", "Head of Human Resources", "Head of Marketing" };
		List<Integer> choosen = new ArrayList<>();
		List<String> roleList = new ArrayList<>(Arrays.asList(roles));
		message = "\nMit wie vielen Spielern möchten sie Spielen? (2 - 6)";
		print(message);

		int anzahl = validateInput(message, x -> x >= 2 && x <= 6 );

		for (int i = 0; i < anzahl; i++) {
			System.out.println("\nSpieler " + (i + 1) + ", wählen sie ihren Namen! ");
			print("Name: ");
			String name = scan.nextLine();

			message = "\nWählen Sie Ihre Rolle\n";
			for (int n = 0; n < roleList.size(); n++) 
				if (!choosen.contains(n))
					message += (n + 1) + ". " + roles[n] + "\n";
			int wahl = 0;
			System.out.println(message);
			wahl = validateInput(message, x -> (x > 0 && x <= 6) && !choosen.contains(x)) - 1;
			
			choosen.add(wahl);
			game.asignRoles(name, wahl);
		}
		printRoles();
	}
	private int validateInput(String messageToRepeat, Predicate<Integer> condition) {
		boolean valid = true;

		int value = -1;

		do {
			valid = true;
			try { 
				System.out.print("\nEingabe: ");
				value = Integer.parseInt(scan.nextLine());
				if (!condition.test(value)) {
					System.out.println("\nBitte die Auswahl beachten!\n" + messageToRepeat);
					valid = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("Falsches Format!\n\n" + messageToRepeat);
				valid = false;
			}



		} while (!valid);
		return value;
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
