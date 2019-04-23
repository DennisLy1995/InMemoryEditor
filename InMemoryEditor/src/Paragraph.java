
public class Paragraph {

	private String text;

	public Paragraph(String newText) {
		this.text = newText;
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
