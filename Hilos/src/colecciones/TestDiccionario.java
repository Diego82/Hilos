package colecciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TestDiccionario {

	public static void main(String[] args) {
	
		List<Diccionario> listadoLIST = new ArrayList<Diccionario>();
		Set<String> listadoSET = new HashSet<String>();
		String[] array;
		
		File inFile = new File("diccionario.csv");
		String lineaLeida;		
		Scanner sc;
		
		try {
			sc = new Scanner(inFile);
			while (sc.hasNextLine()) {
				lineaLeida = sc.nextLine();
				//System.out.println(lineaLeida);
				array = lineaLeida.split("@");
				for (int i = 0; i < array.length; i++) {
					Diccionario aux = new Diccionario(array[0], array[1]);
					listadoLIST.add(aux);
				}
			}
			System.out.println(listadoLIST);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

class Diccionario {
	
	private String palabraES;
	private String palagraEN;
	
	public Diccionario(String palabraES, String palagraEN) {
		this.palabraES = palabraES;
		this.palagraEN = palagraEN;
	}

	public String getPalabraES() {
		return palabraES;
	}

	public void setPalabraES(String palabraES) {
		this.palabraES = palabraES;
	}

	public String getPalagraEN() {
		return palagraEN;
	}

	public void setPalagraEN(String palagraEN) {
		this.palagraEN = palagraEN;
	}

	@Override
	public String toString() {
		return "Diccionario [palabraES=" + palabraES + ", palagraEN=" + palagraEN + "]";
	}
	
	
}

class RecogerPalabras {
	//Atributo
	private List<Diccionario> listado1;
	private Set<Diccionario> listado2;
	
	public RecogerPalabras(List<Diccionario> listado1) {
		this.listado1 = listado1;
	}
	public RecogerPalabras(Set<Diccionario> listado2) {
		this.listado2 = listado2;
	}
	
}

