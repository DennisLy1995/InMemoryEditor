
public class MementoStyled extends ExtMemento{

	private ParagraphStyled estado;
	
	public MementoStyled(ParagraphStyled pEstado) {
		this.estado = pEstado;
	}
	
	@Override
	public Paragraph GetSavedState() {
		return null;
	}

	@Override
	public ParagraphStyled GetSavedStateStyled() {
		return estado;
	}
	
}
