package srcClase;

public class TestConMetodoReferencia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Inicio del programa");
		Thread hilo = new Thread(TestConMetodoReferencia::ejecuta);
		hilo.start();
		System.out.println("Fin del programa");
	}

	public static void ejecuta(){
		System.out.println("Hola desde el hilo");
	}
}
