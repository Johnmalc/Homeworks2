package malcjohn;

public class ProductDescription {
	private String produktGruppe;

	public enum PriceLevel {

	}

	public void setProduktGruppe(String value) {
		this.produktGruppe = value;
	}

	public String getProduktGruppe() {
		return this.produktGruppe;
	}

	private String beschreibungsText;

	public void setBeschreibungsText(String value) {
		this.beschreibungsText = value;
	}

	public String getBeschreibungsText() {
		return this.beschreibungsText;
	}

}
