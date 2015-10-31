package numeroPrimo;

public class NumerosPrimos extends Thread {

	// Atributo
	private long numero;

	/**
	 * @param numero
	 */
	public NumerosPrimos(long numero) {
		super();
		this.numero = numero;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		//System.out.println("Inicializando el hilo "+Thread.currentThread().getName());
		System.out.println(this.numero+" es numero primo? "+esPrimo());
		/*
		if (esPrimo())
			System.out.println(this.numero+" es un numero primo");
		else
			System.out.println(this.numero+" no es un numero primo");*/
	}

	private boolean esPrimo() {
		
		long n = this.numero;

		if (n <= 3) {
			return n > 1;
		} else if (n % 2 == 0 || n % 3 == 0) {
			return false;
		} else {
			for (long i = 5; i * i <= n; i += 6) {
				if (n % i == 0 || n % (i + 2) == 0) {
					return false;
				}
			}
			return true;
		}
	}
}
