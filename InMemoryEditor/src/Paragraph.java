
public class Paragraph {

	private String text;
	private String style;

	public Paragraph(String newText) {
		this.text = newText;
		this.style = "Monaco";
	}

	public Memento saveState() {
		return new Memento(this);
	}

	public void retoreFromMemento(Memento state) {
		this.text = state.GetSavedState().getText();
		this.style = state.GetSavedState().getStyle();
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

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	
	
}
