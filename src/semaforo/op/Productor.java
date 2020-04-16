package semaforo.op;
import java.util.Random;

import semaforo.gui.MainWindow;

public class Productor implements Runnable {
	BufferLimitado b = null;
	MainWindow interfaz = new MainWindow();
	
	public Productor(BufferLimitado initb,MainWindow interfaz) {
		b = initb;
		new Thread( this ).start();
		this.interfaz = interfaz;
	}
	public void run() {
		double item;
		Random r = new Random();
		
		while(true){
			item = r.nextDouble();
			System.out.println("Articulo producido: " + item );
			b.deposit(item);
			Util.mySleep(4000);
		}
	}
	
}