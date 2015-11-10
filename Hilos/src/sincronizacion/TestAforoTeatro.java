package sincronizacion;

import java.util.concurrent.Semaphore;

public class TestAforoTeatro {
	public static void main(String[] args) {

		AforoTeatro real = new AforoTeatro(4000);
		Thread hiloEntrada;
		Thread hiloSalida;
		
		for (int i = 0; i < 10; i++) {
			hiloEntrada = new AforoTeatro(real,10);
			hiloSalida = new AforoTeatro(real,-5);
			hiloEntrada.start();
			hiloSalida.start();
		}
	}
}

class AforoTeatro extends Thread {
	// Atributos
	private int entradas; //Variable con la que registramos las entradas y salidas del teatro
	private int aforo = 4000; //Aforo que tiene en el momento
	private Semaphore semaforo = new Semaphore(1);
	/**
	 * Constructor
	 * @param entradas
	 */
	public AforoTeatro(int aforo) {
		this.aforo = aforo;
	}

	public AforoTeatro(AforoTeatro real , int entradas) {
		System.out.println("llamada a run()");
		run();
	}
	
	//En este metodo se registran el numero de entradas y salidas que se realizan
	public void setAforo(int numeroEntradas){
		this.aforo += numeroEntradas;
		System.out.println("El aforo actual es de "+this.aforo);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			semaforo.acquire();
			setAforo(this.entradas);
			semaforo.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}