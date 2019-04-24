
public class MementoStyled {

	private ParagraphStyled estado;
	
	public MementoStyled(ParagraphStyled pEstado) {
		this.estado = pEstado;
	}
	
	public ParagraphStyled GetSavedState() {
		return estado;
	}
	
}
