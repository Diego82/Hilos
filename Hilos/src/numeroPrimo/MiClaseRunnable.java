package numeroPrimo;

public class MiClaseRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("mostramos el run de mi hilo creado");
		System.out.println(Thread.currentThread());
		Thread hiloSecundario = new Thread("hilo secundario");
		System.out.println(hiloSecundario);

	}

}
