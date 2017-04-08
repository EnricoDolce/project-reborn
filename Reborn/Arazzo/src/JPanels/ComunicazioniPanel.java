package JPanels;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Global.GlobalVar;
import combobox.PCIIComboBox;
import comunicazioni.GestioneComunicazioni;
import javax.swing.JButton;

public class ComunicazioniPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	Image arrowup ;
	Image arrowdown;
	String file;
	public ComunicazioniPanel() {
		setOpaque(false); //sfondo trasparente del panel per permettere la visione dello sfondo del jframe

		this.setLayout(null);
		this.setBounds(0, 0, 1280, 1024);
		
		final GestioneComunicazioni g = new GestioneComunicazioni();
		g.refresh();
		
		 arrowup = GlobalVar.img_drop_arrow_up.getScaledInstance(30, 30,
		        Image.SCALE_SMOOTH);
		 arrowdown= GlobalVar.img_drop_arrow_down.getScaledInstance(30, 30,
		        Image.SCALE_SMOOTH);
		 
		//freccetta 
			final JLabel arrow = new JLabel("");
			arrow.setIcon(new ImageIcon(arrowup));
			arrow.setBounds(249, 300, 50, 50);
			add(arrow);
			
			final Vector<String> files = g.nomiComunicazioni();
			
			
				file = files.get(0);
				//file = file.substring(0,file.length() - 4); //elimino il .pdf
				System.out.println(file);
			

			final PCIIComboBox FilecomboBox = new PCIIComboBox(files);
			FilecomboBox.setBounds(288, 300, 700, 50);
			FilecomboBox.setFont(new Font("Oswald", Font.BOLD, 22));
			FilecomboBox.addItemListener(new ItemListener() {
			      public void itemStateChanged(ItemEvent e) {
			    	  
			    	  arrow.setIcon(new ImageIcon(arrowup));
			    	   file = e.getItem().toString();
						
			        }
			      });
			FilecomboBox.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					arrow.setIcon(new ImageIcon(arrowdown));
				}
			});
			add(FilecomboBox);
			
			JButton visualizza = new JButton("VISUALIZZA COMUNICAZIONE");
			visualizza.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					
						GlobalVar.GoToPanel(new VisualizzaComunicazioniPanel(file, g));
					
				}
			});
			visualizza.setFont(new Font("Oswald", Font.BOLD, 22));
			visualizza.setAlignmentX(CENTER_ALIGNMENT);
			visualizza.setBounds(418, 651, 400, 50);
			add(visualizza);
			
			
			
	}
}
