import java.util.List;

public class BDPersistence extends ExtPersistence{

	@Override
	public List<ExtParagraph> retornarParrafosGuardados(String temp, Class<ExtParagraph[]> test) {
		return null;
	}

	@Override
	public List<ExtMemento> retornarEstadosAnterioresGuardados(String temp) {
		return null;
	}

	@Override
	public String serializeListParagraphs(List<ExtParagraph> list) {
		return null;
	}

	@Override
	public String serializeListMementos(List<ExtMemento> list) {
		System.out.println("Saved in the BD.");
		return null;
	}

	@Override
	public String saveListParagraphs(String phrases) {
		return null;
	}

	@Override
	public boolean saveListMementos(String name, String mementos) {
		return false;
	}



}
