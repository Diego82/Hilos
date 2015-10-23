package srcClase;

public class TestHilosConThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Comienzo del programa principal");
		HilosConThread hilo = new HilosConThread();
		hilo.start();
		try {
			hilo.sleep(10_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Hilo main interrumpido");
			e.printStackTrace();
		}
		System.out.println("Fin desde el programa principal");
	}
}

class HilosConThread extends Thread {

	//el codigo se ejecuta concurretemente
	//Se implimenta con el metodo run()
	//Que los aporta la clase Thread
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		/*try {
			Thread.sleep(5_000);
		} catch (InterruptedException e) {
			 TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("hola desde el hilo");
	}
}
