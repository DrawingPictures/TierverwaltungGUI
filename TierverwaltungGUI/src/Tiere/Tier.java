package Tiere;

public class Tier {
	
	private int id;
	private String typ;
	private String name;
	private String hautfarbe;
	private String geburtstag;
	
	public Tier(int id, String typ, String name, String hautfarbe, String geburtstag) {
		
		this.id = id;
		this.typ = typ;
		this.name = name;
		this.hautfarbe = hautfarbe;
		this.geburtstag = geburtstag;

	}
	
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHautfarbe() {
		return hautfarbe;
	}
	public void setHautfarbe(String hautfarbe) {
		this.hautfarbe = hautfarbe;
	}
	public String getGeburtstag() {
		return geburtstag;
	}
	public void setGeburtstag(String geburtstag) {
		this.geburtstag = geburtstag;
	}
	public int getId() {
		return id;
	}
	
	

}
