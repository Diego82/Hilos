package colecciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TestDiccionario {

	public static void main(String[] args) {
	
		List<Diccionario> listadoLIST = new ArrayList<Diccionario>();
		Set<Diccionario> listadoSET = new HashSet<Diccionario>();
		HashMap<String, Diccionario> listadoMAP = new HashMap<>();
		HashMap<String,String> listadoMAP2 = new HashMap<String,String>();
		HashMap<Integer,String> map = new HashMap<Integer,String>();
				
		File inFile = new File("diccionario.csv");
		String lineaLeida;		
		Scanner sc;
		
		try {
			sc = new Scanner(inFile);
			while (sc.hasNextLine()) {
				lineaLeida = sc.nextLine();
				String[] array = lineaLeida.split("@");
				Diccionario aux = new Diccionario(array[0], array[1]);
				listadoLIST.add(aux);
				listadoSET.add(aux);
				listadoMAP.put(array[0], aux);
				listadoMAP2.put(array[0], array[1]);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int numero = 0;
		
		/*System.out.println("tamaño de la lista "+listadoLIST.size());
		for (int i = 0; i < 15 ; i++) {
			numero = (int) (Math.random()*listadoLIST.size());
			System.out.println(listadoLIST.get(numero).getPalabraES()+" en ingles significa "
								+listadoLIST.get(numero).getPalagraEN()+" y se encuentra en la posicion "+numero);
		}*/
		
		//System.out.println(listadoLIST);
		//System.out.println(listadoSET);
		//System.out.println(listadoMAP2);
		
		map.put(1, "Casillas");		map.put(15, "Ramos");
		map.put(1, "Pique");		map.put(5, "Puyol");
		map.put(11, "Capdevila");	map.put(14, "Xabi Alonso");
		map.put(16, "Busquets");	map.put(8, "Xavi Hernandez");
		map.put(18, "Pedrito");		map.put(6, "Iniesta");
		map.put(7, "Villa");
		System.out.println(listadoMAP2.size());
		System.out.println();
		
		
		
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
}

