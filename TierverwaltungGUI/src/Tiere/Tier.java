package Tiere;

public class Tier {
	
	private static int id = 0;
	private String typ;
	private String hautfarbe;
	private String geburtstag;
	
	public Tier(String typ, String hautfarbe, String geburtstag) {
		this.typ = typ;
		this.hautfarbe = hautfarbe;
		this.geburtstag = geburtstag;
		id++;
	}
	
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
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
	public static int getId() {
		return id++;
	}
	
	

}
