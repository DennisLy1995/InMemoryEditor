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
				wholeMementos.set(wholeText.indexOf(currentParagraph), new Memento(temp));
				currentParagraph.setText(readNewParagraph);
				modified = true;
			}
			contador++;
		}

		return modified;
	}

	public boolean backToOldState(int numParagraph) {
		boolean returned = false;
		int contador = 1;
		int index = -1;
		Paragraph temp = new Paragraph("");
		for (Paragraph currentParagraph : wholeText) {
			if (contador == numParagraph) {
				index = wholeText.indexOf(currentParagraph);
				temp.setText(currentParagraph.getText());
				currentParagraph = wholeMementos.get(wholeText.indexOf(currentParagraph)).GetSavedState();
				wholeText.set(index, currentParagraph);
				wholeMementos.set(index, new Memento(temp));
				returned = true;
			}
			contador++;
		}
		return returned;
	}

	public List<Paragraph> getParagraphs() {
		return this.wholeText;
	}

}
