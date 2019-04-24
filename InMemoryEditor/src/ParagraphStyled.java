
public class ParagraphStyled implements IntParagraph {

	private String text;
	private int fontSize = 0;
	private String fontFamily = "";
	private int type = 2;

	@Override
	public Memento saveState() {
		return null;// new Memento(this);
	}

	@Override
	public MementoStyled saveStateStyled() {
		return new MementoStyled(this);
	}

	@Override
	public void retoreFromMemento(Memento state) {
		// Do nothing.
	}

	@Override
	public void retoreFromMemento(MementoStyled state) {
		this.text = state.GetSavedState().getText();
		this.fontSize = state.GetSavedState().getFontSize();
		this.fontFamily = state.GetSavedState().getFontFamily();
		this.type = state.GetSavedState().getTypeParagraph();

	}

	@Override
	public int getTypeParagraph() {
		return type;
	}

	public ParagraphStyled(String text, int fontSize, String fontFamily) {
		super();
		this.text = text;
		this.fontSize = fontSize;
		this.fontFamily = fontFamily;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public String getFontFamily() {
		return fontFamily;
	}

	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}

}
