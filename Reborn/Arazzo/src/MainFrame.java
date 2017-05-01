import java.awt.AWTEvent;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dualScreenPanels.ScreenRicercaProf;
import dualscreen.DualScreenFrame;

import Global.GlobalVar;
import JPanels.ToolBar;

/**
 * Classe che gestisce la Finestra con cui si andra' ad interfacciare l'utente
 *
 */

public class MainFrame {
	
	/**
	 * frame dello schermo touch
	 */
	private JFrame frame;

	/**
	 * Main che lancia l'applicazione
	 * 
	 */
	public static void main(String[] args) {
		final Toolkit tk = Toolkit.getDefaultToolkit();
		final long eventMask =  AWTEvent.MOUSE_EVENT_MASK;
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					MainFrame window = new MainFrame();
					
					window.frame.setVisible(true);
					tk.addAWTEventListener(new AWTEventListener() {
						
			            public void eventDispatched(AWTEvent e) {
			            	
			         	
			            }
			        }, eventMask);
			        
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 *  Costruttore del MainFrame
	 *  con new GlobalVar() , istanzio nella classe GlobalVar tutte la variabili che mi servono statiche , ad esempio le immagini
	 *  con inizialize() , inizializzo il frame con le sue componenti
	 * @see GlobalVar
	 */
	public MainFrame() {
		
		//istanzio le variabili globali
		new GlobalVar();
		
		initialize();
	}

	/**
	 * Inizializza il contenuto del frame.
	 *
	 * @return void
	 * @see ToolBar
	 * @see NavigationMenu
	 * @see GlobalVar
	 */
	private void initialize() {
		
		GlobalVar.dualscreenframe = new DualScreenFrame();
		
		//prende le informazioni dello screen del device utilizzato
		GraphicsEnvironment graphic = GraphicsEnvironment.getLocalGraphicsEnvironment();
		//GraphicsDevice device = graphic.getDefaultScreenDevice();
		
		/**
		 * variabile che gestisce i due schermi
		 */
		GraphicsDevice[] dualscreen = graphic.getScreenDevices(); 
		
		
		frame = new JFrame();
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);  // nascondo toolbar del sistema operativo
		frame.setSize(1280, 1024);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);  //absolute layout
	
		
		//setto la toolbar
		JPanel panel = new ToolBar();
		panel.setVisible(false);
		frame.getContentPane().add(panel,0);
		GlobalVar.toolbar = panel;  // salvo la toolbar per farla apparire quando voglio
		


		//settaggio Jpanel
		panel = GlobalVar.Stack.get(GlobalVar.StackPosition);   // prendo dalla classe globalVar del package Global lo stack e la pos attuale dello stack
		frame.getContentPane().add(panel,1);  //addo il panel al frame
		
	
		// frame background
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(GlobalVar.img_background_scelta));
		background.setBounds(0, 0, 1280, 1024);
		GlobalVar.background = background;
		frame.getContentPane().add(background);
		
		GlobalVar.frame = frame;  // salvo frame per apportare modifiche al frame in futuro da altre classi
	
		//dualscreen[0].setFullScreenWindow(frame);  //metto a tutto schermo il frame scelta nello schermo 0
		
		dualscreen[1].setFullScreenWindow(GlobalVar.dualscreenframe);  //metto a tutto schermo il frame nello schermo 1
		GlobalVar.frame.setAlwaysOnTop(true);
		GlobalVar.dualscreenframe.DualScreenVisible(false);
	}


 


	
}
