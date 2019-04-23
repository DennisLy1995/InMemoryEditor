
public class Controller {

	private static TextManager textManager= new TextManager();
	
	public static void execute(int option) {
		switch(option) {
		case 1:
			textManager.add(UI.readNewParagraph());
			break;
		case 2: 
			int numParagraph = UI.getParagraphNumber();
			textManager.modify(numParagraph, UI.readNewParagraph());
			break;
		case 3: 
			UI.print("This is the current whole text\n");
			for (Paragraph paragraph: textManager.getParagraphs()){
				UI.print(paragraph.getText());
			}
			break;
		}
		
	}

}
