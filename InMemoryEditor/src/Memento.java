
public class Memento  extends ExtMemento{

	private Paragraph estado;
	
	public Memento(Paragraph pEstado) {
		this.estado = pEstado;
	}
	
	@Override
	public Paragraph GetSavedState() {
		return estado;
	}

	@Override
	public ParagraphStyled GetSavedStateStyled() {
		return null;
	}
	
}
