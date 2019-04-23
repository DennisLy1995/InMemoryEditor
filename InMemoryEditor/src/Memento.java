
public class Memento {

	private Paragraph estado;
	
	public Memento(Paragraph pEstado) {
		this.estado = pEstado;
	}
	
	public Paragraph GetSavedState() {
		return estado;
	}
	
}
