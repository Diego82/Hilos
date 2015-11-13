package colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class TestColeccionesSincronizadas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coleccion coleccion = new Coleccion();
		Thread hilo1 = new Operacion(coleccion);
		Thread hilo2 = new Operacion(coleccion);
		Thread hilo3 = new Operacion(coleccion);
		hilo1.start();hilo2.start();hilo3.start();
		try {
			hilo1.join();hilo2.join();hilo3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(coleccion);
		
		
	}

}
class Coleccion {
	
	private List<Integer> lista = Collections.synchronizedList(new ArrayList<Integer>());
	private Vector<Integer> vector = new Vector<Integer>();
	
	public Coleccion(){
		for (int i = 0; i < 50 ; i++) {
			lista.add(i);
			vector.add(i);
		}
	}
	
	public void quitar(){
		lista.remove(0);
		vector.remove(0);
	}

	@Override
	public String toString() {
		return "Coleccion \nlista=" + lista + "\nvector=" + vector + "\n";
	}	
}
class Operacion extends Thread{
	Coleccion coleccion;

	public Operacion(Coleccion coleccion) {
		this.coleccion = coleccion;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			coleccion.quitar();
		}
	}
}