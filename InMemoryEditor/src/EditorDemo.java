
public class EditorDemo {

	public static void main(String[] args) {
		int option = 0;
		while (option != 5) {
			UI.displayMenu();
			option = UI.readOption();
			Controller.execute(option);
		}
		
		
	}

}
