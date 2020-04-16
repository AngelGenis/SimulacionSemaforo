package semaforo.op;

import java.awt.Color;

import semaforo.gui.MainWindow;

public class BufferLimitado{
	int size = 10;
	double buffer[] = new double[size];
	int inBuf = 0, outBuf = 0;
	MainWindow interfaz;
	
	SemaforoBinario mutex = new SemaforoBinario(true);
	SemaforoContador isEmpty = new SemaforoContador(0);
	SemaforoContador isFull = new SemaforoContador(size);
	int i = 0;
	
	public BufferLimitado(MainWindow interfaz, int size){
		this.interfaz = interfaz;
		this.size = size;
		buffer = new double[size];
		isFull = new SemaforoContador(size);
	}
	
	public void deposit(double value){
		isFull.P(); 
			interfaz.CambiarColor("productor", Color.green);
			mutex.P(); 
				interfaz.CambiarColor("consumidor", Color.red);
				buffer[inBuf] = value;
				i++;
				interfaz.buffers[i-1].setBackground(Color.CYAN);
				inBuf = (inBuf + 1) % size;
			mutex.V();
		isEmpty.V();
	}
	
	public double fetch(){	
		double value;
		isEmpty.P();
		interfaz.CambiarColor("consumidor", Color.green);
		
			mutex.P();
			interfaz.CambiarColor("productor",Color.red);
			
				value = buffer[outBuf];
				outBuf = (outBuf+1) % size;
				
				interfaz.buffers[i-1].setBackground(Color.yellow);
				i--;
			mutex.V();
		isFull.V();
		
		return value;
	}
	
	
}