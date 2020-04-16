package semaforo.op;

import semaforo.gui.MainWindow;

public class Consumidor implements Runnable {
	BufferLimitado b = null;
	MainWindow interfaz = new MainWindow();
	int tiempo = 0;
	
	public Consumidor(BufferLimitado initb, MainWindow interfaz, int tiempo) {
		b = initb;
		new Thread(this).start();
		this.tiempo = tiempo;
		this.interfaz = interfaz;
	}
	
	public void run() {
		double item;
		while(true){
			item = b.fetch();
			System.out.println( "Articulo extraño:" + item );
			Util.mySleep(tiempo);
		}
	}
}