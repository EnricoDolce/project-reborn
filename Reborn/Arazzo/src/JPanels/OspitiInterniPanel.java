package JPanels;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Global.GlobalVar;

public class OspitiInterniPanel extends JPanel {

	/**
	 * Creazione JPanel che gestisce la scelta fatta dell'utente , ovvero se essere un ospite o un Interno ,
	 * a seconda della scelta fatta appariranno schermate differenti con differenti opzioni caricate dinamicamente
	 */
	public OspitiInterniPanel() {
		setOpaque(false); //sfondo trasparente del panel per permettere la visione dello sfondo del jframe

		this.setLayout(null); //absolute layout
		this.setBounds(0, 0, 1280, 1024);
				// settaggio bottone ed eliminazione valori di default ( bordo e colore di background)
				final JButton ospitiBtn = new JButton("");
				ospitiBtn.setBorderPainted(false);
				ospitiBtn.setContentAreaFilled(false); 
				
				//settaggio immagine bottone 
					ospitiBtn.setIcon(new ImageIcon(GlobalVar.img_btn_ospiti));
			
				
				//event handler bottone ospiti premuto
				ospitiBtn.addMouseListener(new MouseAdapter() 
				{
					public void mousePressed(MouseEvent arg0) {
						
						ospitiBtn.setIcon(new ImageIcon(GlobalVar.img_btn_ospiti_pressed));
											
						GlobalVar.Ospite = true; // flag per capire se e' stato selezionato ospite o interno
						GlobalVar.Interno = false;
					
						
						System.out.println("Bottone Ospiti premuto");
			
					}
					public void mouseReleased(MouseEvent arg0) {
						
						
						ospitiBtn.setIcon(new ImageIcon(GlobalVar.img_btn_ospiti));
						
						JPanel tmp = new SceltaModuloPanel();
						
						
						GlobalVar.toolbar.setVisible(true);
						
						GlobalVar.GoToPanel(tmp);
					}
				});
				
				
				ospitiBtn.setBounds(640,10,640,1024);
				this.add(ospitiBtn);

				// settaggio bottone ed eliminazione valori di default ( bordo e colore di background)
				final JButton interniBtn = new JButton("");
				interniBtn.setBorderPainted(false);     
				interniBtn.setContentAreaFilled(false); 
				
				//settaggio immagine bottone
					interniBtn.setIcon(new ImageIcon(GlobalVar.img_btn_interni));
			
				
				//event handler bottone interni premuto
				interniBtn.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent arg0) {

						
							interniBtn.setIcon(new ImageIcon(GlobalVar.img_btn_interni_pressed));
							
							GlobalVar.Ospite = false;
							GlobalVar.Interno = true;
							
						
						System.out.println("Bottone Interni premuto");
					}
					public void mouseReleased(MouseEvent arg0) {
						
						
						interniBtn.setIcon(new ImageIcon(GlobalVar.img_btn_interni));
						
						JPanel tmp = new SceltaModuloPanel();
				
						GlobalVar.toolbar.setVisible(true);
						
						GlobalVar.GoToPanel(tmp);
					
					}
				});
				
				interniBtn.setBounds(0, 10, 640,1024);
				this.add(interniBtn);
				
			
	}
	


}
