package hilosDaemon;

public class TestUsuarioDaemon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Comienza el proceso principal");
		HiloDaemon hilo1 = new HiloDaemon();
		HiloDaemon hilo2 = new HiloDaemon();
		HiloDaemon hilo3 = new HiloDaemon();
		HiloDaemon hilo4 = new HiloDaemon();
		
		//Le indicamos que el tipo de hilo será Daemon
		hilo1.setDaemon(true);hilo2.setDaemon(true);hilo3.setDaemon(true);hilo4.setDaemon(true);
		
		//Iniciamos
		hilo1.start();hilo2.start();hilo3.start();hilo4.start();

		//El problema de los hilos Daemon es que cuando termina el hilo principal estos terminan con el
		//independientemente de que hayan finalizado o no su proceso
		
		//Si queremos que el main espere a que terminen los hilos Daemon 
		//deberemos llamar al metodo join sobre el hilo que queremos que sea esperado

		//El programa se parará aqui hasta que los hilos con el método join finalicen su proceso
		
		System.out.println("Antes de llegar al metodo join()");
		hilo1.join();hilo2.join();hilo3.join();hilo4.join();
		
		System.out.println("Antes de dormir el hilo principal");
		Thread.sleep(2_000);
		
		System.out.println("Termina el hilo principal");
		

	}

}

class HiloDaemon extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Termina el hilo "+Thread.currentThread());
	}
}