package semaforo.op;
import java.util.Random;

import semaforo.gui.MainWindow;

public class Productor implements Runnable {
	BufferLimitado b = null;
	MainWindow interfaz = new MainWindow();
	int tiempo = 0;
	
	public Productor(BufferLimitado initb,MainWindow interfaz, int tiempo) {
		b = initb;
		new Thread( this ).start();
		this.interfaz = interfaz;
		this.tiempo = tiempo;
	}
	public void run() {
		double item;
		Random r = new Random();
		
		while(true){
			item = r.nextDouble();
			System.out.println("Articulo producido: " + item );
			b.deposit(item);
			Util.mySleep(tiempo);
		}
	}
	
}