package semaforos;

import java.util.concurrent.Semaphore;

public class TestCuentaBancariaConSemaforos {

	public static void main(String[] args) {
		CuentaBancaria cuenta = new CuentaBancaria(4000);
		OperacionBancaria operacion;
		int cantidad = 0;
		int signo = 1;
		for (int i = 0; i < 10; i++) {
			cantidad = (int) (Math.random()*100);
			operacion = new OperacionBancaria(cuenta, cantidad*signo);
			operacion.start();
			signo*=-1;			
		}
	}
}

class CuentaBancaria {
	//Atributos
	private int saldo;
	private Semaphore semaforo = new Semaphore(1);
	/**
	 * @param saldo
	 */
	public CuentaBancaria(int saldo) {
		this.saldo = saldo;
	}
	
	public void variarCuenta(int cantidad){
		
		try {
			semaforo.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.saldo+=cantidad;
		System.out.println("Variando cuenta: "+cantidad+" SALDO: "+this.saldo);
		semaforo.release();
		
	}
}

class OperacionBancaria extends Thread {
	//Atributos
	private CuentaBancaria cuenta;
	private int cantidad;
	/**
	 * @param cuenta
	 * @param saldo
	 */
	public OperacionBancaria(CuentaBancaria cuenta, int cantidad) {
		this.cuenta = cuenta;
		this.cantidad = cantidad;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		cuenta.variarCuenta(this.cantidad);
	}
}
