package operacionBancaria;

public class CuentaBancaria {
	
	//Atributo
	private double saldo;
	/**
	 * @param saldo
	 */
	public CuentaBancaria(double saldo) {
		super();
		this.saldo = saldo;
	}
	
	public  void ingresarDinero(double ingreso){
		this.saldo += ingreso;
		System.out.println("El saldo tras el ingreso de dinero es: "+this.saldo);
	}
	
	public void retirarDinero(double ingreso){
		this.saldo -= ingreso;
		System.out.println("El saldo tras la retirada de dinero es: "+this.saldo);
	}
	
}

class RetirarDinero extends Thread{

	//Atributos
	private CuentaBancaria cuenta;
	private double cantidad;
	/**
	 * @param cuenta
	 * @param saldo
	 */
	public RetirarDinero(CuentaBancaria cuenta, double cantidad) {
		this.cuenta = cuenta;
		this.cantidad = cantidad;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.cuenta.retirarDinero(this.cantidad);
	}
}

class IngresoDinero extends Thread{

	//Atributos
	private CuentaBancaria cuenta;
	private double cantidad;
	/**
	 * @param cuenta
	 * @param saldo
	 */
	public IngresoDinero(CuentaBancaria cuenta, double cantidad) {
		this.cuenta = cuenta;
		this.cantidad = cantidad;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.cuenta.ingresarDinero(this.cantidad);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
