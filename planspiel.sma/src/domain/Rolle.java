package domain;

import java.util.ArrayList;
import java.util.List;

public class Rolle {
	String name;
	String spielername;
	ArrayList<String> anwortliste = new ArrayList<String>();
	int id;

	public Rolle(String name, ArrayList<String> anwortliste, int id) {
		super();
		this.id = id;
		this.name = name;
		this.anwortliste = anwortliste;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpielername() {
		return spielername;
	}

	public void setSpielername(String spielername) {
		this.spielername = spielername;
	}

	public List getAnwortliste() {
		return anwortliste;
	}

	public void setAnwortliste(ArrayList<String> anwortliste) {
		this.anwortliste = anwortliste;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
