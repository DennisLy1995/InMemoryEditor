
public abstract class ExtParagraph {

	public abstract Memento saveState();
	public  abstract MementoStyled saveStateStyled();
	public  abstract void retoreFromMemento(Memento state);
	public  abstract void retoreFromMemento(MementoStyled state);
	public  abstract int getTypeParagraph();
	
}