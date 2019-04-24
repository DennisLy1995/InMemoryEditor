
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
			for (Paragraph paragraph: textManager.getParagraphs()){
				UI.print(paragraph.getText());
			}
			break;
			
		case 4: 
			numParagraph = UI.getParagraphNumber();
			checker = textManager.backToOldState(numParagraph);
			break;
		}
		
	}

}
