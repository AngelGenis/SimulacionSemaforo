package semaforo.op;

import semaforo.gui.MainWindow;

public class Consumidor implements Runnable {
	BufferLimitado b = null;
	MainWindow interfaz = new MainWindow();
	
	public Consumidor(BufferLimitado initb, MainWindow interfaz) {
		b = initb;
		new Thread(this).start();
		this.interfaz = interfaz;
	}
	
	public void run() {
		double item;
		while(true){
			item = b.fetch();
			System.out.println( "Articulo extra�o:" + item );
			Util.mySleep(40);
		}
	}
}