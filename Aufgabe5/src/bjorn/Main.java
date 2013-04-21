package bjorn;

/**
 * @author Normal
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> speicher = new List<String>();

		speicher.insertFirst("SECHS");

		speicher.insertFirst("FUENF");
		speicher.insertFirst("VIER");
		speicher.insertFirst("DREI");
		speicher.insertFirst("ZWEI");
		speicher.insertFirst("EINS");

		System.out.println(speicher);
		System.out.println(speicher.size());

		try {
			System.out.println(speicher.get(0));
		}

		catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}

		try {
			speicher.add("SIEBEN");
		}

		catch (NullPointerException e) {
			System.out.println(e.getLocalizedMessage());
		}

		System.out.println("--------------------------------");
		System.out.println("");
		System.out.println(speicher);
		System.out.println(speicher.size());

	}

}
