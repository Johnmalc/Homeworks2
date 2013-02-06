package malcjohn;

public class Date {
	// Attributes for Day, Month and Year

	private int Tag;
	private int Monat;
	private int Jahr;

	// Constructor

	public Date(int TagX, int MonatX, int JahrX) {
		this.Jahr = JahrX;
		this.Monat = MonatX;
		this.Tag = TagX;
	}

	// Methods for Day, Month and Year

	public void setTag(int value) {
		this.Tag = value;
	}

	public int getTag() {
		return this.Tag;
	}

	public void setMonat(int value) {
		this.Monat = value;
	}

	public int getMonat() {
		return this.Monat;
	}

	public void setJahr(int value) {
		this.Jahr = value;
	}

	public int getJahr() {
		return this.Jahr;
	}

	public Date getNextDay() {
		return new Date(Tag, Monat, Jahr);
	}
}
