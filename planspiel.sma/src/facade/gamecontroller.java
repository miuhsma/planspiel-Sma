package facade;

import domain.Roles;

public class gamecontroller {
	Roles roles = new Roles();

	public void asignRoles(String name, int i) {
		roles.asign(name, i);
	}

	public String[][] getRoleArray() {
		return roles.getRoleArray();
	}

}
