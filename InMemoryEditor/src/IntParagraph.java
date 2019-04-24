
public interface IntParagraph {

	public Memento saveState();
	public MementoStyled saveStateStyled();
	public void retoreFromMemento(Memento state);
	public void retoreFromMemento(MementoStyled state);
	public int getTypeParagraph();
	
	
}
