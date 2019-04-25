
public class Controller {

	private static TextManager textManager= new TextManager();
	
	public static void execute(int option) {
		boolean checker = false;
		int numParagraph = 0;
		
		switch(option) {
		case 1:
			textManager.add(UI.readNewParagraph());
			break;
			
		case 2: 
			numParagraph = UI.getParagraphNumber();
			checker = textManager.modify(numParagraph, UI.readNewParagraph());
			if(checker==true) {
				System.out.println("El texto se ha modificado con exito.");
			}else {
				System.out.println("El texto no se ha podido modificar.");
			}
			break;
			
		case 3: 
			UI.print("This is the current whole text\n");
			for (ExtParagraph paragraph: textManager.getParagraphs()){
				UI.print(paragraph.InformationParagraph());
			}
			break;
			
		case 4: 
			numParagraph = UI.getParagraphNumber();
			checker = textManager.backToOldState(numParagraph);
			break;
			
		case 5: 
			Controller.saveOrRestore();
			break;
			
		}
		
	}

	
	
	private static void saveOrRestore() {
		String option = UI.leerString("Digit 1 to save\nDigit 2 to restore");
		switch(option) {
		case "1":
			//Save
			Controller.save();
			break;
			
		case "2":
			//Restore
			Controller.Restore();
			break;
		}
		
	}

	private static void save() {
		String option = UI.leerString("Digit 1 for txt\nDigit 2 for BD");
		switch(option) {
		case "1":
			//Txt
			TxtPersistence saveTxt = new TxtPersistence();
			saveTxt.guardarListas(textManager.getWholeText(), textManager.getWholeMementos());
			break;
			
		case "2":
			//BD
			BDPersistence saveBD = new BDPersistence();
			saveBD.guardarListas(textManager.getWholeText(), textManager.getWholeMementos());
			break;
		}		
	}

	private static void Restore() {
		String option = UI.leerString("Digit 1 for txt\nDigit 2 for BD");
		switch(option) {
		case "1":
			//Txt
			try {
				TxtPersistence saveTxt = new TxtPersistence();
				String name = UI.leerString("Type the name of the File");
				saveTxt.retornarParrafosGuardados(name);
				textManager.setWholeText(saveTxt.readParagraphFile(name));
				textManager.setWholeMementos(saveTxt.readMementoFile(name));
				System.out.println("Information imported in the system.");
			}catch(Exception e) {
				System.out.println("Upss something went wrong.");
				System.out.println(e);
				
			}
			
			break;
			
		case "2":
			//BD
			BDPersistence saveBD = new BDPersistence();
			System.out.println("Information imported in the system.");
			break;
		}
	}





}
