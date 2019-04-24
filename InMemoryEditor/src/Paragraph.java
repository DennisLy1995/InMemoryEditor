
public class Paragraph extends ExtParagraph {

	private String text;
	private int type = 1;

	public Paragraph(String newText) {
		this.text = newText;
		this.type = 1;
	}

	@Override
	public Memento saveState() {
		return new Memento(this);
	}

	@Override
	public MementoStyled saveStateStyled() {
		return null;
	}

	@Override
	public void retoreFromMemento(Memento state) {
		this.text = state.GetSavedState().getText();
		this.type = state.GetSavedState().getTypeParagraph();
	}

	@Override
	public void retoreFromMemento(MementoStyled state) {
		// Do nothing
	}

	@Override
	public int getTypeParagraph() {
		return type;
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
