package facade;

import java.util.ArrayList;

import domain.Roles;
import domain.Rolle;

public class gamecontroller {
	Roles roles = new Roles();

	public void asignRoles(String name, int i) {
		roles.asign(i, name);
	}

	public ArrayList<Rolle> getRoles() {
		return roles.getRoles();
	}

	public void createRoles() {
		roles.createAllRoles();
	}

}
