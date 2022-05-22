package mavenClasses;

public class MainSax {

	public static void main(String[] args) {
		
		SaxMyParser parser = new SaxMyParser();
		Root root = parser.parse();
		System.out.println("Root " + root.toString());
	}

}
