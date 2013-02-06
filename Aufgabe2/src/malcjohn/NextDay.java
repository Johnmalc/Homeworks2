package malcjohn;

public class NextDay {

	public static void main(String[] args) {
		int t = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);
		int j = Integer.parseInt(args[2]);
		/**
		 * http://www.tutorials.de/java/187920-zahl-kommandozeile-uebergeben.
		 * html
		 * 
		 * Start as run as configuration with numbers as arguments
		 * 
		 */
		Date da = new Date(t, m, j);
		System.out.println(da.getJahr());
		System.out.println(da.getMonat());
		System.out.println(da.getTag());

	}

}
