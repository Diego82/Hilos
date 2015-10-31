package numeroPrimo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestNumeroPrimo {

	public static void main(String[] args) {
		
		double timeInicio = System.currentTimeMillis();
		List<Long> listaNumeros = new ArrayList<Long>();
		long numero;
		File inFile = new File("numeros_primos.txt");
		Scanner in = null;
		//Obtenemos el numero de cores de nuestro procesador 
		int cores = Runtime.getRuntime().availableProcessors();
		//Definimos el numero de hilos que queremos que entren a la vez
		ExecutorService execute = Executors.newFixedThreadPool(cores);
		
		//Ahora procedemos a leer los numeros de nuestro archivo con la clase Scanner
		try {
			in = new Scanner(inFile);
			while (in.hasNextLong()) {
				numero = in.nextLong();
				//Creamos un hilo con la clase Runnable para poder pasarselo al execute
				Runnable worker = new NumerosPrimos(numero);
				//Corremos el execute con el hilo que queremos que hemos creado
				execute.execute(worker);
				//Por ultimo guardamos nuestro numero leido en nuestra lista
				listaNumeros.add(numero);
			}
			execute.shutdown();
			//Introducimos este bucle que controlará cuando termina de ejecutarse el ultimo hilo para cerrar el 
			while (!execute.isTerminated()) {				
			}
			double timeFin = System.currentTimeMillis();
			System.out.println("tiempo de ejecucion: "+(timeFin-timeInicio));
			
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha encontrado el archivo");
		}
		finally {
			if (in == null) {
				in.close();
			}
		}
	}
}
