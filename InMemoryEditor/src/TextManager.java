import java.util.ArrayList;
import java.util.List;

public class TextManager {

	private List<Paragraph> wholeText = new ArrayList<>();
	
	public void add(String readNewParagraph) {
		System.out.println("Type the text:\n");
		this.wholeText.add(new Paragraph(readNewParagraph));
	}

	public boolean modify(int numParagraph, String readNewParagraph) {
		boolean modified = false;
		int contador = 1;
		for (Paragraph currentParagraph: wholeText) {
			if (contador == numParagraph) {
				currentParagraph.setText(readNewParagraph);
				modified = true;
			}
			contador++;
		}
		return modified;
	}

	public List<Paragraph> getParagraphs() {
		return this.wholeText;		
	}

}
