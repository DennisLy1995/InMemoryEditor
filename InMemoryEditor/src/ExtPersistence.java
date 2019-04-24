import java.util.List;

import com.google.gson.Gson;

public abstract class ExtPersistence {

	protected Gson jsonSerializer = new Gson();
	
	public abstract List<ExtParagraph> retornarParrafosGuardados(String temp);
	public abstract List<ExtMemento> retornarEstadosAnterioresGuardados(String temp);
	public abstract String serializeListParagraphs(List<ExtParagraph> list);
	public abstract String serializeListMementos(List<ExtMemento> list);
	public abstract String saveListParagraphs(String phrases);
	public abstract boolean saveListMementos(String name, String value);
	
	public void guardarListas(List<ExtParagraph> listP, List<ExtMemento> listM){
		String name = saveListParagraphs(serializeListParagraphs(listP));
		saveListMementos(name, serializeListMementos(listM));
		
	}
	
	
}
