package sumaNumeros;

public class Prioridades {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+" - "+Thread.currentThread().getPriority());
		HilosDemo run = new HilosDemo();
		Thread hilo1 = new Thread(run);
		Thread hilo2 = new Thread(new HilosDemo());
		hilo1.start();hilo2.start();
		HilosDemo run2 = new HilosDemo();
		Thread hilo3 = new Thread(run2,"Mi hilo propio");
		//Aunque le pongamos prioridad, la maquina virtual procedera como considere opotuno
		hilo3.setPriority(Thread.MAX_PRIORITY);
		hilo3.start(); 
		hilo3.yield();
		System.out.println("Termina mi hilo principal");
	}

}

class HilosDemo implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		long dormir = (long) (Math.random()*5_000);
		try {
			Thread.sleep(dormir);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println(Thread.currentThread().getName()+ " - "+Thread.currentThread().getPriority());
	}
	
}
