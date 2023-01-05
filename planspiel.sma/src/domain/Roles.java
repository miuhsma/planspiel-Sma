package domain;

public class Roles {
	String[][] roleArray = { { "", "Geschäftsleitung" }, { "", "Informationssicherheitsbeauftragter" },
			{ "", "Datenschutzbeauftragter" }, { "", "Anwalt" }, { "", "Head of Human Resources" },
			{ "", "Head of Marketing" } };

	public void asign(String name, int position) {
		roleArray[position][0] = name;
	}

	public String[][] getRoleArray() {
		return roleArray;
	}

}
