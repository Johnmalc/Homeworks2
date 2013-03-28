package de.university.reutlingen.aufgabe2.a2;

public class ProductDescription {
	private String produktGruppe;
	private String beschreibungsText;

	public ProductDescription(String produktGruppeX, String beschreibungsTextX) {
		this.produktGruppe = produktGruppeX;
		this.beschreibungsText = beschreibungsTextX;
	}

	public void setProduktGruppe(String value) {
		this.produktGruppe = value;
	}

	public String getProduktGruppe() {
		return this.produktGruppe;
	}

	public void setBeschreibungsText(String value) {
		this.beschreibungsText = value;
	}

	public String getBeschreibungsText() {
		return this.beschreibungsText;
	}

	@Override
	public String toString() {
		return "ProductDescription: " + produktGruppe
				+ ", beschreibungsText : " + beschreibungsText;
	}

}
