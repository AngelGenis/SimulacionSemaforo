package semaforo.gui;

import semaforo.op.BufferLimitado;
import semaforo.op.Consumidor;
import semaforo.op.Productor;

import java.awt.EventQueue;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import semaforo.gui.MainWindow;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPanel;

public class MainWindow {
	private JFrame frame;
	MyCanvas canvas;
	Label LabelNArticulosProducir=new Label("Articulos a Producir");
	Label LabelTiempoProduccion=new Label("Tiempo de produccion: "); 
	TextField ArticulosAProducir=new TextField();
	TextField tiempoProduccion=new TextField(); 
	Label LabelTiempoConsumo=new Label("Tiempo de Consumo: "); 
	TextField TiempoConsumo=new TextField();
	Label label = new Label("Proceso Consumidor");
	Label label_4 = new Label("Articulos a Consumir");
	TextField ArticulosAConsumir = new TextField();
	Label label_1 = new Label("");
	Label label_2 = new Label("");
	Label label_3 = new Label("Proceso Productor");
	private final JPanel panelConsumidor = new JPanel();
	private final JPanel panelProductor = new JPanel();
	private final JPanel panelBuffer = new JPanel();
	public JPanel[] buffers;
	
	/**
	 * Launch the application.
	 */
	MainWindow window = this;
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainWindow(){
		inicializar();
	}
	
	public void inicializar() {
		frame = new JFrame();
		frame.setBounds(100, 100, 516, 601);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 LabelNArticulosProducir.setBounds(138,216, 109,30);
		 ArticulosAProducir.setBounds(267, 226, 74, 20);
		 
		 LabelTiempoProduccion.setBounds(138,246, 126,30);  
		 
		 tiempoProduccion.setBounds(267, 252, 74, 20);
		  
		 LabelTiempoConsumo.setBounds(138,276, 108,30); 
		 
		 TiempoConsumo.setBounds(267, 282, 74, 20);
		 
		 frame.getContentPane().add(LabelNArticulosProducir); 
		 frame.getContentPane().add(ArticulosAProducir);
		 
		 frame.getContentPane().add(LabelTiempoProduccion); 
		 frame.getContentPane().add(tiempoProduccion);
		 
		 frame.getContentPane().add(LabelTiempoConsumo); 
		 frame.getContentPane().add(TiempoConsumo);
		 
		 JButton btnIniciar = new JButton("Iniciar");
		 btnIniciar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		int nProducir= Integer.parseInt(ArticulosAProducir.getText());	
		 		int tiempoConsumidor = Integer.parseInt(TiempoConsumo.getText());	
		 		int tiempoProductor = Integer.parseInt(tiempoProduccion.getText());	
		 		int nConsumos = Integer.parseInt(ArticulosAConsumir.getText());
		 		buffers = new JPanel[nProducir];
				Buffers();
				 
		 		BufferLimitado buffer = new BufferLimitado(window, nProducir);
		 		Productor productor = new Productor( buffer, window, tiempoConsumidor, nConsumos);
				Consumidor consumidor = new Consumidor(buffer, window, tiempoProductor, nProducir);	
		 	}
		 });
		 btnIniciar.setBounds(395, 528, 89, 23);
		 frame.getContentPane().add(btnIniciar);
		 
		
		 label.setBounds(21, 73, 103, 20);
		 frame.getContentPane().add(label);
		 
		 
		 label_1.setBackground(Color.YELLOW);
		 label_1.setBounds(21, 99, 103, 79);
		 frame.getContentPane().add(label_1);
		 
		
		 label_2.setBackground(Color.BLUE);
		 label_2.setBounds(381, 99, 103, 79);
		 frame.getContentPane().add(label_2);
	 
		 label_3.setBounds(381, 73, 103, 20);
		 frame.getContentPane().add(label_3);
		 
		 panelConsumidor.setBackground(Color.GRAY);
		 panelConsumidor.setBounds(138, 121, 37, 42);
		 
		 frame.getContentPane().add(panelConsumidor);
		 panelProductor.setBackground(Color.GRAY);
		 panelProductor.setBounds(338, 121, 37, 42);
		 
		 frame.getContentPane().add(panelProductor);
		 panelBuffer.setBackground(Color.RED);
		 panelBuffer.setBounds(226, 415, 37, 42);
		 
		 frame.getContentPane().add(panelBuffer);
		 panel.setBackground(Color.GRAY);
		 panel.setBounds(59, 172, 3, 267);
		 
		 frame.getContentPane().add(panel);
		 panel_1.setBackground(Color.GRAY);
		 panel_1.setBounds(429, 172, 3, 267);
		 
		 frame.getContentPane().add(panel_1);
		 panel_2.setBackground(Color.GRAY);
		 panel_2.setBounds(59, 434, 187, 5);
		 
		 frame.getContentPane().add(panel_2);
		 panel_3.setBackground(Color.GRAY);
		 panel_3.setBounds(242, 434, 187, 5);
		 
		 frame.getContentPane().add(panel_3);
		 
		
		 
		 ArticulosAConsumir.setBounds(267, 192, 74, 20);
		 frame.getContentPane().add(ArticulosAConsumir);
		 
		
		 label_4.setBounds(138, 182, 109, 30);
		 frame.getContentPane().add(label_4);
		 
	}
	public void Buffers(){
		int counter = 212;
		
		for (int i=0; i<buffers.length; i++){
			buffers[i] = new JPanel();
			buffers[i].setBounds(counter,339,10,29);
			frame.getContentPane().add(buffers[i]);
			buffers[i].setBackground(Color.yellow);
			counter+=12;
		}
	}
	
	public void CambiarColor(String semaforo,Color color) {
		switch(semaforo) {
		case "consumidor":
			panelConsumidor.setBackground(color);
			break;
		
		case "productor":
			panelProductor.setBackground(color);
			break;
			
		case "buffer:":
			panelBuffer.setBackground(color);
			break;
		default:
			System.out.println("Error");
		}
	}
}
