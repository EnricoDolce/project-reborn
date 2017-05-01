package dualscreen;
import java.awt.AWTEvent;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.AWTEventListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Global.GlobalVar;
import JPanels.OspitiInterniPanel;
import JPanels.ToolBar;

public class DualScreenFrame extends JFrame {

	/**
	 * Frame base utilizzato nello schermo della tv 
	 */
	public DualScreenFrame() {
		
		initialize();
	}

	/**
	 * metodo per inizializzare le basi del frame
	 */
	private void initialize() {

	
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//this.setUndecorated(true);  // nascondo toolbar del sistema operativo
		this.setSize(1920, 1080);
		this.setVisible(true);
		
		JPanel panel = new JPanel();   // Panel temporaneo
				panel.setOpaque(false);
		this.getContentPane().add(panel, 0);
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 1920, 1080);
		Image dimg = GlobalVar.img_background_scelta.getScaledInstance(1920, 1080,   //scalo l'immagine
		        Image.SCALE_SMOOTH);

		background.setIcon(new ImageIcon(dimg));
		this.getContentPane().add(background,1);
	}
	
	/**
	 * Metodo per cambiare il JPanel all'interno del Frame dello schermo della tv
	 * @param panel novo Panel
	 */
	public void DualScreenGoToPanel(JPanel panel){
	
			GlobalVar.dualscreenframe.getContentPane().remove(0);
			GlobalVar.dualscreenframe.getContentPane().add(panel,0);
		
		GlobalVar.dualscreenframe.repaint();
		GlobalVar.dualscreenframe.getContentPane().repaint(); 
	}
	
	/**
	 * metodo per settare la visibilita del Frame dello schermo della tv
	 * @param bool
	 */
	public void DualScreenVisible(boolean bool){	
		
		GlobalVar.dualscreenframe.setVisible(bool);
		
	}
	
	
}
