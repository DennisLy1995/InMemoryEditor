
public class Paragraph implements IntParagraph{

	private String text;

	public Paragraph(String newText) {
		this.text = newText;
	}

	@Override
	public Memento saveState() {
		return new Memento(this);
	}

	@Override
	public void retoreFromMemento(Memento state) {
		this.text = state.GetSavedState().getText();
	}

	public int getLength() {
		return this.text.length();
	}

	public String getText() {
		return this.text;
	}

	public void setText(String newText) {
		this.text = newText;
	}	
	
}
