package srcClase;

public class TestConClaseInterna {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Comienza el hilo principal");
		Thread hilo = new Thread(new Runnable() {
	
			@Override
			public void run() {
				// 	TODO Auto-generated method stub
		
			}
		});
		System.out.println("Fianaliza el hilo principal");
	}

}
