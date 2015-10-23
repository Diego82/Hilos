package imprimirNumeros;

public class SinParametros {

	public static void main(String[] args) {
		System.out.println("inicio del programa");
		Runnable runnable = () -> {
			for (int i = 0; i < 30; i++) {
				System.out.print(i+" ");
			}
		};
		Thread hilo1 = new Thread(runnable);
		Thread hilo2 = new Thread(runnable);
		
		hilo1.start();
		hilo2.start();
		System.out.println("fin del programa");
	}
}
