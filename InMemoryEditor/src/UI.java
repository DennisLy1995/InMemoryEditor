import java.io.Console;
import java.util.Scanner;

public class UI {

	public static void displayMenu() {
		System.out.println("");
		System.out.println("=========================");
		System.out.println("Editor Demo");
		System.out.println("Select your option");
		System.out.println("1 Add paragraph");
		System.out.println("2 Modify paragrap");
		System.out.println("3 Show all text");
		System.out.println("4 Exit");
		System.out.println("=========================");
	}

	public static int readOption() {
		Scanner reader = new Scanner(System.in);
		
		try {
			return Integer.parseInt(reader.nextLine());
		} catch (Exception e) {
			System.out.println("Invalid option");
			return 0;
		}
	}

	public static String readNewParagraph() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Type the new text:\n");
		return reader.nextLine();
	}

	public static int getParagraphNumber() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Type the text you want to modify:\n");
		try {
			return Integer.parseInt(reader.nextLine());
		} catch (Exception e) {
			return 0;
		}
	}

	public static void print(String string) {
		System.out.println(string);
	}

}