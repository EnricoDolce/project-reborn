package JPanels;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Global.GlobalVar;
import comunicazioni.GestioneComunicazioni;
import javax.swing.JButton;

public class VisualizzaComunicazioniPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	int pos =0;
	public VisualizzaComunicazioniPanel(String file , GestioneComunicazioni g) {
		setOpaque(false); //sfondo trasparente del panel per permettere la visione dello sfondo del jframe

		this.setLayout(null);
		this.setBounds(0, 0, 1280, 1024);
		
		
		final Vector<BufferedImage> t=g.imgComunicazione(file);
		 
		
		final JLabel label = new JLabel("");
		label.setBounds(358,95,595,842); 
		
		BufferedImage img = null;
		
		img = t.get(pos);
		
		Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(),
		        Image.SCALE_SMOOTH);
		
		
		label.setIcon(new ImageIcon(dimg));
		add(label);
		

		final JButton left = new JButton("");
		left.setBorderPainted(false);
		left.setFocusPainted(false);
		left.setContentAreaFilled(false);
		left.setIcon(new ImageIcon(GlobalVar.img_com_left_arrow));
		left.setBounds(12, 95, 334, 842);
		left.setVisible(false);
		add(left);
		
		final JButton right = new JButton("");
		right.setBorderPainted(false);
		right.setFocusPainted(false);
		right.setContentAreaFilled(false);
		right.setIcon(new ImageIcon(GlobalVar.img_com_right_arrow));
		right.setBounds(958, 95, 322, 842);
		right.setVisible(false);
		add(right);
		
		if(t.size()>1)
		{
			right.setVisible(true);
			left.setVisible(true);
		}
		

			
			left.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent arg0) {
					left.setIcon(null);
				}
				public void mouseReleased(MouseEvent arg0) {
					left.setIcon(new ImageIcon(GlobalVar.img_com_left_arrow));
					if(pos > 0)  // se voglio tornare indietro  non vado in underflow
					{
						 BufferedImage img = null;
						 pos = pos-1;
						 img = t.get(pos);
								
						Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(),
						        Image.SCALE_SMOOTH);
						
						
						label.setIcon(new ImageIcon(dimg));
					}
					
					
				}
			});
			
			right.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent arg0) {
					right.setIcon(null);
				}
				public void mouseReleased(MouseEvent arg0) {
					right.setIcon(new ImageIcon(GlobalVar.img_com_right_arrow));
					if(pos < t.size()-1)  // se voglio tornare indietro  non vado in underflow
					{
						 BufferedImage img = null;
						 pos = pos+1;
						 img = t.get(pos);
								
						Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(),
						        Image.SCALE_SMOOTH);
						
						
						label.setIcon(new ImageIcon(dimg));
					}
					
					
				}
			});
		
		
		
			JLabel background = new JLabel("");
			background.setIcon(new ImageIcon(GlobalVar.img_comunicazioni_background));
			background.setBounds(0, 0, 1280, 1024);
			add(background);
			
		//System.out.println(t.size());

	}
}
