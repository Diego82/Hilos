package imprimirNumeros;

public class ConParametros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Comienza el programa principal");
		Hilos hilo1 = new Hilos(0, 10);
		Hilos hilo2 = new Hilos(10, 20);
		Hilos hilo3 = new Hilos(20, 30);
		hilo1.start(); hilo2.start(); hilo3.start();
		System.out.println("Termina el programa principal");
	}

}

class Hilos extends Thread{
	//Atributos
	private int valorMin;
	private int valorMax;
	
	//Constructor
	public Hilos(int valorMin, int valorMax) {
		this.valorMin = valorMin;
		this.valorMax = valorMax;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Comienza el hilo: "+Thread.currentThread().getName()+" con prioridad "+Thread.currentThread().getPriority());
		for (int i = this.valorMin; i < this.valorMax; i++) {
			System.out.print(i+" ");
		}
		System.out.println("Termina el hilo: "+Thread.currentThread().getName());
	}
}
