import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TxtPersistence extends ExtPersistence {

	@Override
	public List<ExtParagraph> retornarParrafosGuardados(String temp) {
		
		List<ExtParagraph> list = new ArrayList<>();
		ExtParagraph tempParagraph = null;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("C:\\Users\\Public\\Documents\\"+temp+".txt"));
			String line = reader.readLine();
			tempParagraph = jsonSerializer.fromJson(line, ExtParagraph.class);
			list.add(tempParagraph);
			System.out.println("NL: "+ line);
			while(line != null) {
				line = reader.readLine();
				tempParagraph = jsonSerializer.fromJson(line, ExtParagraph.class);
				list.add(tempParagraph);
				System.out.println("NL: "+ line);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return list;
	}

	@Override
	public List<ExtMemento> retornarEstadosAnterioresGuardados(String temp) {

		List<ExtMemento> list = new ArrayList<>();
		ExtMemento tempMemento = null;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("C:\\Users\\Public\\Documents\\"+temp+"Memento.txt"));
			String line = reader.readLine();
			tempMemento = jsonSerializer.fromJson(line, ExtMemento.class);
			list.add(tempMemento);
			System.out.println("NL: "+ line);
			while(line != null) {
				line = reader.readLine();
				tempMemento = jsonSerializer.fromJson(line, ExtMemento.class);
				list.add(tempMemento);
				System.out.println("NL: "+ line);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return list;
	}

	@Override
	public String serializeListParagraphs(List<ExtParagraph> list) {
		
		String tempSer = "";
		String listTemp = "";
		
		for (ExtParagraph currentParagraph : list) {
			
			tempSer = jsonSerializer.toJson(currentParagraph);
			listTemp = listTemp + tempSer + "\n";
		}
		
		
		return listTemp;
	}

	@Override
	public String serializeListMementos(List<ExtMemento> list) {
		String tempSer = "";
		String listTemp = "";
		
		for (ExtMemento currentMemento : list) {
			
			tempSer = jsonSerializer.toJson(currentMemento);
			listTemp = listTemp + tempSer + "\n";
		}
		
		
		return listTemp;
	}

	@Override
	public String saveListParagraphs(String phrases) {

		String direccionArchivos = "C:\\Users\\Public\\Documents\\";
		String name = UI.leerString("Define the name of the txt file you want to store");
		direccionArchivos = direccionArchivos + name + ".txt";
		File file = new File(direccionArchivos);
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
			fileWriter.write(phrases);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return name;
	}

	@Override
	public boolean saveListMementos(String name, String mementos) {

		boolean checker = false;

		String direccionArchivos = "C:\\Users\\Public\\Documents\\";
		direccionArchivos = direccionArchivos + name + "Mementos.txt";
		File file = new File(direccionArchivos);
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
			fileWriter.write(mementos);
			checker = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (checker == true) {
			System.out.println("List of phrases has been saved in: C:\\Users\\Public\\Documents\\" + name + ".txt");
			System.out.println(
					"                                   C:\\Users\\Public\\Documents\\" + name + "Mementos.txt");
		} else {
			System.out.println("Something went wrong and the phrases have not been saved.");
		}
		return checker;
	}

	public static String readFile(String name) throws IOException {
		String lectureTemp = "";
		String lecture = "";
		String direccionArchivos = "C:\\Users\\Public\\Documents\\";
		direccionArchivos = direccionArchivos + name + ".txt";
		FileReader fileReader = new FileReader(direccionArchivos);
		try {

			BufferedReader buffer = new BufferedReader(fileReader);

			while ((lectureTemp = buffer.readLine()) != null) {
				lecture = lecture + lectureTemp;
			}
			fileReader.close();
		} catch (Exception e) {
			fileReader.close();
			System.out.println("No se ha logrado leer el archivo.");
		}

		return lecture;
	}

	public List<ExtParagraph> readParagraphFile(String name) {
		List<ExtParagraph> temp = new ArrayList<>();
		try {
			String file = readFile(name);
			temp = retornarParrafosGuardados(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}

	public List<ExtMemento> readMementoFile(String name) {
		List<ExtMemento> temp = new ArrayList<>();
		try {
			String file = readFile(name);
			temp = retornarEstadosAnterioresGuardados(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}

}
