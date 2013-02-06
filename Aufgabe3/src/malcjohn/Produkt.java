package malcjohn;

public class Produkt {
	private String produktBeschreibung;
	private double produktPreis;

	public Produkt(String ProduktbeschreibungX, double ProduktpreisX) {
		this.produktBeschreibung = ProduktbeschreibungX;
		this.produktPreis = ProduktpreisX;
	}

	void setProduktbeschreibung(String value) {
		this.produktBeschreibung = value;
	}

	public String getProduktBeschreibung() {
		return this.produktBeschreibung;
	}

	public void setProduktPreis(double value) {
		this.produktPreis = value;
	}

	public double getProduktPreis() {
		return this.produktPreis;
	}

}
