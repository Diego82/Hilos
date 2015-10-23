package srcClase;

public class TestConInterfazFuncional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Comienza el hilo principal");
		Runnable runnable = () -> System.out.println("Hola desde el hilo");
		Thread hilo = new Thread(runnable);
		hilo.start();
		System.out.println("fin del program principal");
	}

}
