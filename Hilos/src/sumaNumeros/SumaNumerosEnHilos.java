package sumaNumeros;

public class SumaNumerosEnHilos {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Comienza el programa principal con nombre "+Thread.currentThread().getName()+" y con id: "+Thread.currentThread().getId());
		long tiempoInicio = System.currentTimeMillis();
		/*Vamos a realizar la suma en 4 hilos diferentes
		 *y despues sumaremos los cuatro resultados*/
		Hilos hilo1 = new Hilos();
		Hilos hilo2 = new Hilos();
		Hilos hilo3 = new Hilos();
		Hilos hilo4 = new Hilos();
		
		//Una vez declarados los hilos se corren con el metodo start();
		hilo1.start(); hilo2.start(); hilo3.start(); hilo4.start();
		
		/*Debemos controlar el hilo principal de tal manera que espere a que finalice
		 * los procesos que se estan llevando a cabo en los hilos que hemos declarado
		 * Para ellos utilizaremos el metodo join()*/
		//hilo1.join();  hilo3.join(); hilo4.join(); hilo2.join();
		
		System.out.println("La suma realizada por el hilo "+hilo1.getName()+" es igual a "+hilo1.getSuma());
		System.out.println("La suma realizada por el hilo "+hilo2.getName()+" es igual a "+hilo2.getSuma());
		System.out.println("La suma realizada por el hilo "+hilo3.getName()+" es igual a "+hilo3.getSuma());
		System.out.println("La suma realizada por el hilo "+hilo4.getName()+" es igual a "+hilo4.getSuma());
		
		long sumaTotal = hilo1.getSuma()+hilo2.getSuma()+hilo3.getSuma()+hilo4.getSuma();
		System.out.println("la suma total de los cuatro procesos es = "+sumaTotal);
		
		long tiempoFin = System.currentTimeMillis();
		double tiempoEmpleado = (tiempoFin-tiempoInicio);
		
		System.out.println("Termina el programa principal. Tiempo empleado en el proceso: "+tiempoEmpleado+" milisegundos");
	}
}
class Hilos extends Thread {
	//Creamos el atributo suma para recoger la operacion en una variable
	private long suma = 0;
	
	public long getSuma(){
		return this.suma;
	}
	 public void run(){
		 System.out.println("Comienza el hilo "+Thread.currentThread().getName()+" e id: "+Thread.currentThread().getId());
		 for (int i = 0; i < 100_000_000 ; i++) {
			suma += i;
		}
		 System.out.println("Termina el hilo "+Thread.currentThread().getName());
	 }
	
}
