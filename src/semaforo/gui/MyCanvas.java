package semaforo.gui;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class MyCanvas extends Canvas{
	public void paint(Graphics g) {
		g.setFont(new Font("Roboto",Font.BOLD, 12));
		
		g.drawString("Productor", 98, 31);
		g.drawString("Consumidor", 341, 31);
		g.drawString("Buffer", 233, 250);
	
		
	}
}
