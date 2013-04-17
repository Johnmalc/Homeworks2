package de.university.reutlingen.newversion;

public class ProductDescription {
	private String produktGruppe;
	private String beschreibungsText;

	public ProductDescription(String produktGruppeX, String beschreibungsTextX) {
		this.produktGruppe = produktGruppeX;
		this.beschreibungsText = beschreibungsTextX;
	}

	public enum PriceLevel {
		LOW(9.99), MEDIUM(19.99), HIGH(49.99), EXCLUSIVE(99.99);
		
		private double zahl;

		private PriceLevel(double zahlX) {
			this.zahl = zahlX;
		}

		@Override
		public String toString() {
			return String.valueOf(zahl);
		}
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
