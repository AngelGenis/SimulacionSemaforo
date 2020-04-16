package semaforo.op;

import java.awt.Color;

import semaforo.gui.MainWindow;

public class BufferLimitado{
	final int size = 10;
	double buffer[] = new double[size];
	int inBuf = 0, outBuf = 0;
	MainWindow interfaz;
	
	SemaforoBinario mutex = new SemaforoBinario(true);
	SemaforoContador isEmpty = new SemaforoContador(0);
	SemaforoContador isFull = new SemaforoContador(size);
	
	public BufferLimitado(MainWindow interfaz){
		this.interfaz = interfaz;
	}
	
	public void deposit(double value){
		isFull.P(); //espera si el buffer esta lleno
		
		//interfaz.CambiarColor("productor", Color.gray);
		interfaz.CambiarColor("productor", Color.green);
		mutex.P(); //asegura la exclusión mutua
		
		//interfaz.CambiarColor("consumidor", Color.gray);
		interfaz.CambiarColor("consumidor", Color.red);
		buffer[inBuf] = value;
		inBuf = (inBuf + 1) % size;
		mutex.V();
		isEmpty.V(); //notifica a algún consumidor en espera

	}
	
	public double fetch(){	
		double value;
		isEmpty.P(); // esperar si el buffer está vacío
		interfaz.CambiarColor("consumidor", Color.green);
		
		//interfaz.CambiarColor("consumidor", Color.gray);
			mutex.P(); // asegura la exclusión mutua
			interfaz.CambiarColor("productor",Color.red);
			
			//interfaz.CambiarColor("productor", Color.gray);
				value = buffer[outBuf]; // lee desde el buffer
				outBuf = (outBuf+1) % size;
			mutex.V();
		isFull.V(); // notifica a cualquier productor en espera
		
		return value;
	}
	
	
}