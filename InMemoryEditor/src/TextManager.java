import java.util.ArrayList;
import java.util.List;

public class TextManager {

	private List<ExtParagraph> wholeText = new ArrayList<>();
	private List<ExtMemento> wholeMementos = new ArrayList<>();

	public List<ExtParagraph> getParagraphs() {
		return this.wholeText;
	}

	public void add(String readNewParagraph) {
		System.out.println("1 for regular text\n2 for styled text");
		switch (UI.readOption()) {

		case 1:
			// Regular paragraph
			Paragraph temp = new Paragraph(readNewParagraph);
			this.wholeText.add(temp);
			this.wholeMementos.add(temp.saveState());
			break;

		case 2:
			// Styled paragraph.
			ParagraphStyled tempStyled = new ParagraphStyled(readNewParagraph, UI.leerEntero("Insert the font size:\n"),
					UI.leerString("Insert the type font:\n"));
			this.wholeText.add(tempStyled);
			this.wholeMementos.add(tempStyled.saveStateStyled());
			break;

		default:
			System.out.println("Invalid option");
			break;

		}

	}

	public boolean modify(int numParagraph, String readNewParagraph) {
		boolean modified = false;
		int contador = 1;
		int index = 0;
		for (ExtParagraph currentParagraph : wholeText) {
			if (contador == numParagraph) {

				index = wholeText.indexOf(currentParagraph);

				switch (determineTypeParagraph(currentParagraph)) {

				case 1:
					Paragraph temp = new Paragraph("");
					temp.setText(((Paragraph)currentParagraph).getText());
					wholeMementos.set(index, new Memento(temp));
					((Paragraph)currentParagraph).setText(readNewParagraph);
					modified = true;
					break;

				case 2:
					
					ParagraphStyled tempStyled = new ParagraphStyled("",0,"");
					tempStyled.setText(((ParagraphStyled)currentParagraph).getText());
					tempStyled.setFontSize(((ParagraphStyled)currentParagraph).getFontSize());
					tempStyled.setFontFamily(((ParagraphStyled)currentParagraph).getFontFamily());
					wholeMementos.set(index, new MementoStyled(tempStyled));
					((ParagraphStyled)currentParagraph).setText(readNewParagraph);
					((ParagraphStyled)currentParagraph).setFontSize(UI.leerEntero("Insert the font size:\n"));
					((ParagraphStyled)currentParagraph).setFontFamily(UI.leerString("Insert the type font:\n"));
					modified = true;
					 
					break;

				default:
					modified = false;
					break;

				}

			}
			contador++;
		}
		return modified;
	}

	public boolean backToOldState(int numParagraph) {
		boolean returned = false;
		int contador = 1;
		int index = -1;
		for (ExtParagraph currentParagraph : wholeText) {
			if (contador == numParagraph) {
				index = wholeText.indexOf(currentParagraph);
				
				switch (determineTypeParagraph(currentParagraph)) {

				case 1:
					Paragraph temp = new Paragraph("");
					temp.setText(((Paragraph)currentParagraph).getText()); 
					currentParagraph = wholeMementos.get(index).GetSavedState();
					wholeText.set(index, currentParagraph); wholeMementos.set(index, new
					Memento(temp)); returned = true;
					 
					break;

				case 2:
					
					ParagraphStyled tempStyled = new ParagraphStyled("",0,"");
					tempStyled.setText(((ParagraphStyled)currentParagraph).getText()); 
					tempStyled.setFontSize(((ParagraphStyled)currentParagraph).getFontSize());
					tempStyled.setFontFamily(((ParagraphStyled)currentParagraph).getFontFamily());
					currentParagraph = wholeMementos.get(wholeText.indexOf(currentParagraph)).GetSavedStateStyled();
					wholeText.set(index, currentParagraph); wholeMementos.set(index, new MementoStyled(tempStyled)); 
					returned = true;
					
					break;

				default:
					returned = false;
					break;

				}

			}
			contador++;
		}
		return returned;
	}

	public static int determineTypeParagraph(ExtParagraph current) {

		switch (current.getTypeParagraph()) {

		case 1:// regular paragraph.
			return 1;

		case 2:// Styled paragraph.
			return 2;

		default:// Not a known type of paragraph.
			System.out.println("There isn't a known type for this paragraph.");
			return 0;

		}

	}

	public List<ExtParagraph> getWholeText() {
		return wholeText;
	}

	public void setWholeText(List<ExtParagraph> wholeText) {
		this.wholeText = wholeText;
	}

	public List<ExtMemento> getWholeMementos() {
		return wholeMementos;
	}

	public void setWholeMementos(List<ExtMemento> wholeMementos) {
		this.wholeMementos = wholeMementos;
	}
	
	

}
