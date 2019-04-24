
public class ParagraphStyled extends ExtParagraph {

	private String text;
	private int fontSize = 0;
	private String fontFamily = "";
	private int type = 2;

	public ParagraphStyled(String text, int fontSize, String fontFamily) {
		this.text = text;
		this.fontSize = fontSize;
		this.fontFamily = fontFamily;
		this.type = 2;
	}
	
	@Override
	public Memento saveState() {
		return null;
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
		this.text = state.GetSavedStateStyled().getText();
		this.fontSize = state.GetSavedStateStyled().getFontSize();
		this.fontFamily = state.GetSavedStateStyled().getFontFamily();
		this.type = state.GetSavedStateStyled().getTypeParagraph();

	}

	@Override
	public int getTypeParagraph() {
		return type;
	}
	
	@Override
	public String InformationParagraph() {
		return text + "{ fontSize: " + fontSize + ", fontFamily: " + fontFamily + "}";		
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
