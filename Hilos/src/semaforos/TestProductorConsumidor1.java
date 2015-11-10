package semaforos;

public class TestProductorConsumidor1 {

	public static void main(String[] args) {
		Buffer1 buffer =new Buffer1();
		Consumidor1 consumidor = new Consumidor1(buffer);
		Productor1 productor = new Productor1(buffer);
		consumidor.start();
		productor.start();
	}
}

class Buffer1 {
	private char contenido;
	private boolean disponible = false;
	
	public char recoger(){
		if (disponible) {
			this.disponible = false;
			return this.contenido;
		}
		return '\b';
	}
	public void poner(char c){
		this.disponible = true;
		this.contenido = c;
	}
}
class Productor1 extends Thread {
	private Buffer1 buffer;
	private final String letras="abcdefghijklmnñopqrstuvwxyz";
	
	public Productor1(Buffer1 buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			char caracter = letras.charAt((int) (Math.random()*letras.length()));
			this.buffer.poner(caracter);
			System.out.println(i+" Productor "+caracter);
			try {
				Thread.sleep((long) (Math.random()*500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}
class Consumidor1 extends Thread {
	
	
	private Buffer1 buffer;

	public Consumidor1(Buffer1 buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int j = 0; j < 10; j++) {
			char caracter = this.buffer.recoger();
			System.out.println(j+"Consumidor "+caracter);			
		}
		try {
			Thread.sleep((long) (Math.random()*500));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}