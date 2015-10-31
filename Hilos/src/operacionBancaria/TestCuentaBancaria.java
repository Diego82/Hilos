package operacionBancaria;

public class TestCuentaBancaria {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		CuentaBancaria cuenta = new CuentaBancaria(1000);
		Thread hiloIngresar;
		Thread hiloRetirar;
		
		for (int i = 0; i < 6; i++) {
			hiloIngresar = new IngresoDinero(cuenta, 100);
			hiloRetirar = new RetirarDinero(cuenta, 200);
			hiloIngresar.start();
			hiloRetirar.start();
		}
	}
}
