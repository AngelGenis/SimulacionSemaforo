package semaforo.op;

import java.awt.Color;

import semaforo.gui.MainWindow;

public class Consumidor implements Runnable {
	BufferLimitado b = null;
	MainWindow interfaz = new MainWindow();
	int tiempo = 0;
	int n_consumos = 0;
	int i=0;
	
	public Consumidor(BufferLimitado initb, MainWindow interfaz, int tiempo, int nConsumos) {
		b = initb;
		new Thread(this).start();
		this.tiempo = tiempo;
		this.interfaz = interfaz;
		this.n_consumos = nConsumos;
	}
	
	public void run() {
		double item;
		while(n_consumos > 0){
			item = b.fetch();
			i++;
			interfaz.buffers[i-1].setBackground(Color.CYAN);
			System.out.println( "Articulo extraido:" + item );
			Util.mySleep(tiempo);
			n_consumos--;
		}
	}
}