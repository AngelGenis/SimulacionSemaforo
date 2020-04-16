package semaforo.op;
import java.awt.Color;
import java.util.Random;

import semaforo.gui.MainWindow;

public class Productor implements Runnable {
	BufferLimitado b = null;
	MainWindow interfaz = new MainWindow();
	int tiempo = 0;
	int nProductos = 0;
	int i=0;
	
	
	public Productor(BufferLimitado initb,MainWindow interfaz, int tiempo, int nProductos) {
		b = initb;
		new Thread( this ).start();
		this.interfaz = interfaz;
		this.tiempo = tiempo;
		this.nProductos = nProductos;
		
	}
	
	public void run() {
		double item;
		Random r = new Random();
		
		while(nProductos > 0){
			item = r.nextDouble();
			System.out.println("Articulo producido: " + item );
			i++;
			interfaz.buffers[i-1].setBackground(Color.yellow);
			b.deposit(item);
			Util.mySleep(tiempo);
			nProductos--;
		}
	}
	
}