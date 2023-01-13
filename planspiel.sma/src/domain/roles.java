package domain;

import java.util.ArrayList;

public class Roles {

	ArrayList<Rolle> allRoles = new ArrayList<Rolle>();

	public void asign(int a, String name) {
		for (Rolle rolle : allRoles) {
			if (a == rolle.getId()) {
				rolle.setSpielername(name);
			}
		}
	}

	public ArrayList<Rolle> getRoles() {
		return allRoles;
	}

	public void createAllRoles() {
		allRoles.add(createRoleGeschäftsleitung());
		allRoles.add(createRoleInformationssicherheitsbeauftragter());
		allRoles.add(createRoleDatenschutzbeauftragter());
		allRoles.add(createRoleAnwalt());
		allRoles.add(createRoleHoHR());
		allRoles.add(createRoleHoM());
	}

	public Rolle createRoleGeschäftsleitung() {
		ArrayList<String> antwortenGeschäftsleitung = new ArrayList<String>();
		antwortenGeschäftsleitung.add("");
		antwortenGeschäftsleitung.add("");
		antwortenGeschäftsleitung.add("");
		antwortenGeschäftsleitung.add("");
		antwortenGeschäftsleitung.add("");
		antwortenGeschäftsleitung.add("");
		antwortenGeschäftsleitung.add("");
		antwortenGeschäftsleitung.add("");
		return new Rolle("Geschäftsleitung", antwortenGeschäftsleitung, 1);
	}

	public Rolle createRoleInformationssicherheitsbeauftragter() {
		ArrayList<String> antwortenInformationssicherheitsbeauftragter = new ArrayList<String>();
		antwortenInformationssicherheitsbeauftragter.add("");
		antwortenInformationssicherheitsbeauftragter.add("");
		antwortenInformationssicherheitsbeauftragter.add("");
		antwortenInformationssicherheitsbeauftragter.add("");
		antwortenInformationssicherheitsbeauftragter.add("");
		antwortenInformationssicherheitsbeauftragter.add("");
		return new Rolle("Informationssicherheitsbeauftragter", antwortenInformationssicherheitsbeauftragter, 2);
	}

	public Rolle createRoleDatenschutzbeauftragter() {
		ArrayList<String> antwortenDatenschutzbeauftragter = new ArrayList<String>();
		antwortenDatenschutzbeauftragter.add("");
		antwortenDatenschutzbeauftragter.add("");
		antwortenDatenschutzbeauftragter.add("");
		antwortenDatenschutzbeauftragter.add("");
		antwortenDatenschutzbeauftragter.add("");
		antwortenDatenschutzbeauftragter.add("");
		return new Rolle("Datenschutzbeauftragter", antwortenDatenschutzbeauftragter, 3);
	}

	public Rolle createRoleAnwalt() {
		ArrayList<String> antwortenAnwalt = new ArrayList<String>();
		antwortenAnwalt.add("");
		antwortenAnwalt.add("");
		antwortenAnwalt.add("");
		antwortenAnwalt.add("");
		antwortenAnwalt.add("");
		antwortenAnwalt.add("");
		return new Rolle("Anwalt", antwortenAnwalt, 4);
	}

	public Rolle createRoleHoHR() {
		ArrayList<String> antwortenHoHR = new ArrayList<String>();
		antwortenHoHR.add("");
		antwortenHoHR.add("");
		antwortenHoHR.add("");
		antwortenHoHR.add("");
		antwortenHoHR.add("");
		antwortenHoHR.add("");
		return new Rolle("Head of Human Resources", antwortenHoHR, 5);
	}

	public Rolle createRoleHoM() {
		ArrayList<String> antwortenHoM = new ArrayList<String>();
		antwortenHoM.add("");
		antwortenHoM.add("");
		antwortenHoM.add("");
		antwortenHoM.add("");
		antwortenHoM.add("");
		antwortenHoM.add("");
		return new Rolle("Head of Marketing", antwortenHoM, 6);
	}

}
