package notOurs;

public class CashMachineApp {

	public static void main(String[] args) {
		Geldautomat geldautomat = new Geldautomat();
		geldautomat.fenster(new CashMachine(new Konten().getKonten()));

	}
}