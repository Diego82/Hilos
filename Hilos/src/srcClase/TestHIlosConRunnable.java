package srcClase;

public class TestHIlosConRunnable {
	public static void main(String[] args) {
		System.out.println("Comienza el hilo principal");
		
		System.out.println("Fianaliza el hilo principal");
	}
}

class HilosConRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("syso desde el hilo");
	}
	
}
