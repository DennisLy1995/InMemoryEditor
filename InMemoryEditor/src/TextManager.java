import java.util.ArrayList;
import java.util.List;

public class TextManager {

	private List<Paragraph> wholeText = new ArrayList<>();
	private List<Memento> wholeMementos = new ArrayList<>();

	public void add(String readNewParagraph) {
		System.out.println("Type the text:\n");
		Paragraph temp = new Paragraph(readNewParagraph);
		this.wholeText.add(temp);
		this.wholeMementos.add(temp.saveState());
	}

	public boolean modify(int numParagraph, String readNewParagraph) {
		boolean modified = false;
		int contador = 1;
		Paragraph temp = new Paragraph("");
		for (Paragraph currentParagraph : wholeText) {
			if (contador == numParagraph) {
				temp.setText(currentParagraph.getText());
				temp.setStyle(currentParagraph.getStyle());
				wholeMementos.set(wholeText.indexOf(currentParagraph), new Memento(temp));
				currentParagraph.setText(readNewParagraph);
				modified = true;
			}
			contador++;
		}

		return modified;
	}

	public boolean backToOldState(int numParagraph) {
		boolean checker = false;
		
		
		
		return checker;
	}

	public List<Paragraph> getParagraphs() {
		return this.wholeText;
	}

}
