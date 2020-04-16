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
	Label LabelNArticulosConsumir = new Label("Numero de articulos a consumir: ");  
	TextField ArticulosAConsumir=new TextField(); 
	Label LabelNArticulosProducir=new Label("Numero de articulos a Producir: ");
	Label LabelTiempoProduccion=new Label("Tiempo de produccion: "); 
	TextField ArticulosAProducir=new TextField();
	TextField tiempoProduccion=new TextField(); 
	Label LabelTiempoConsumo=new Label("Tiempo de Consumo: "); 
	TextField TiempoConsumo=new TextField();
	Label label = new Label("Proceso Consumidor");
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
		frame.setBounds(100, 100, 667, 601);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
 
		 LabelNArticulosConsumir.setBounds(205, 162, 200, 30); 
		 ArticulosAConsumir.setBounds(380, 172, 74, 20);
		 LabelNArticulosProducir.setBounds(205,192, 200,30);
		 ArticulosAProducir.setBounds(380, 202, 74, 20);
		 
		 LabelTiempoProduccion.setBounds(205,222, 200,30);  
		 
		 tiempoProduccion.setBounds(380, 232, 74, 20);
		  
		 LabelTiempoConsumo.setBounds(205,252, 200,30); 
		 
		 TiempoConsumo.setBounds(380, 262, 74, 20);
		 frame.getContentPane().add(LabelNArticulosConsumir);
		 frame.getContentPane().add(ArticulosAConsumir);
		 
		 frame.getContentPane().add(LabelNArticulosProducir); 
		 frame.getContentPane().add(ArticulosAProducir);
		 
		 frame.getContentPane().add(LabelTiempoProduccion); 
		 frame.getContentPane().add(tiempoProduccion);
		 
		 frame.getContentPane().add(LabelTiempoConsumo); 
		 frame.getContentPane().add(TiempoConsumo);
		 
		 JButton btnIniciar = new JButton("Iniciar");
		 btnIniciar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		int BufferNumb = 10;
		 		
		 		buffers = new JPanel[BufferNumb];
				colocarBuffers();
				 
		 		BufferLimitado buffer = new BufferLimitado(window);
		 		Productor productor = new Productor( buffer, window );
				Consumidor consumidor = new Consumidor( buffer, window);	
		 	}
		 });
		 btnIniciar.setBounds(522, 529, 89, 23);
		 frame.getContentPane().add(btnIniciar);
		 
		
		 label.setBounds(63, 24, 103, 20);
		 frame.getContentPane().add(label);
		 
		 
		 label_1.setBackground(Color.YELLOW);
		 label_1.setBounds(63, 50, 103, 79);
		 frame.getContentPane().add(label_1);
		 
		
		 label_2.setBackground(Color.BLUE);
		 label_2.setBounds(481, 50, 103, 79);
		 frame.getContentPane().add(label_2);
	 
		 label_3.setBounds(481, 24, 103, 20);
		 frame.getContentPane().add(label_3);
		 
		 panelConsumidor.setBackground(Color.GRAY);
		 panelConsumidor.setBounds(185, 72, 37, 42);
		 
		 frame.getContentPane().add(panelConsumidor);
		 panelProductor.setBackground(Color.GRAY);
		 panelProductor.setBounds(438, 72, 37, 42);
		 
		 frame.getContentPane().add(panelProductor);
		 panelBuffer.setBackground(Color.GRAY);
		 panelBuffer.setBounds(312, 400, 37, 79);
		 
		 frame.getContentPane().add(panelBuffer);
		 
	}
	public void colocarBuffers(){
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
