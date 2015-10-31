package srcClase;

public class TestHIlosConRunnable {
	public static void main(String[] args) {
		System.out.println("Comienza el hilo principal");
		//Primero creamos el runnable que enlaza con la clase propia que implementa runnable para correr el hilo
		Runnable mihilo = new HilosConRunnable();
		//Despues creamos el hilo donde le pasamos nuestro runnable y el nombre del hilo (opcional)
		Thread hilo = new Thread(mihilo,"mi hilo");
		hilo.setDaemon(true);
		hilo.start();
		
				
		System.out.println("Fianaliza el hilo principal");
	}
}

class HilosConRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("syso desde el hilo");
		System.out.println(Thread.currentThread());
		Thread hilosecundario = new Thread("hilo secundario");
		hilosecundario.start();
		System.out.println(hilosecundario);
	}
	
}
