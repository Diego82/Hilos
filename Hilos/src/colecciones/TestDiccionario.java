package colecciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TestDiccionario {

	public static void main(String[] args) {
	
		List<Diccionario> listadoLIST = new ArrayList<Diccionario>();
		List<String> listaIngles = new ArrayList<>();
		List<String> listaEspanol = new ArrayList<>();
		
		Set<Diccionario> listadoSET = new HashSet<Diccionario>();
		HashMap<String, Diccionario> listadoMAP = new HashMap<>();
		HashMap<String,String> listadoMAP2 = new HashMap<String,String>();
		HashMap<Integer,String> map = new HashMap<Integer,String>();
				
		File inFile = new File("diccionario.csv");
		//Para pasar el archivo posemos utilizar esta clase
		Path path = Paths.get("dicionario.csv"); 
		String lineaLeida;		
		
		
		try (Scanner sc = new Scanner(inFile);){
			
			while (sc.hasNextLine()) {
				lineaLeida = sc.nextLine();
				String[] array = lineaLeida.split("@");
				Diccionario aux = new Diccionario(array[0], array[1]);
				
				listaEspanol.add(array[0]);
				listaIngles.add(array[1]);
				
				listadoLIST.add(aux);
				listadoSET.add(aux);
				listadoMAP.put(array[0], aux);
				listadoMAP2.put(array[0], array[1]);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(listadoLIST.size());
		System.out.println(listadoSET.size());
		System.out.println(listadoMAP.size());
		System.out.println(listadoMAP2.size());
		
		map.put(1, "Casillas");		map.put(15, "Ramos");
		map.put(1, "Pique");		map.put(5, "Puyol");
		map.put(11, "Capdevila");	map.put(14, "Xabi Alonso");
		map.put(16, "Busquets");	map.put(8, "Xavi Hernandez");
		map.put(18, "Pedrito");		map.put(6, "Iniesta");
		map.put(7, "Villa");
		
		//System.out.println(map);
		
		Scanner in1 = new Scanner(System.in);
		String palabra = in1.nextLine();
		
		if (listaIngles.contains(palabra)) {
			int posicion = listaIngles.indexOf(palabra);
			String localizada = listaIngles.get(posicion);
			System.out.println(palabra+" : "+localizada);
			
			if (listadoMAP2.containsKey(palabra)) {
				String localizada2 = listadoMAP2.get(palabra);
				System.out.println(palabra+" : "+localizada);
			}
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
		return "Diccionario: palabra en español: " + palabraES + ", palagra en ingles: " + palagraEN + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((palabraES == null) ? 0 : palabraES.hashCode());
		result = prime * result + ((palagraEN == null) ? 0 : palagraEN.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diccionario other = (Diccionario) obj;
		if (palabraES == null) {
			if (other.palabraES != null)
				return false;
		} else if (!palabraES.equals(other.palabraES))
			return false;
		if (palagraEN == null) {
			if (other.palagraEN != null)
				return false;
		} else if (!palagraEN.equals(other.palagraEN))
			return false;
		return true;
	}
	
	
}

