package dualScreenPanels;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Set;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Global.GlobalVar;

public class ScreenRicercaProf extends JPanel {

	/**
	 * JPanel utilizzato nello schermo della tv che visualizza l'orologio dinamico
	 */
	public ScreenRicercaProf() {
		this.setLayout(null); //absolute layout
		this.setBounds(0, 0, 1920, 1080);
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 1920, 1080);
		background.setIcon(new ImageIcon(GlobalVar.img_dualscreen_ricercaprof_bg));
		this.add(background);
	}
	
	/**
	 * metodo che consente di settare la fascia oraria 
	 * @param entries set con l'ora come key e la classe come value
	 */
	public void setHour(Set<Entry> entries){
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 1920, 1080);
		background.setIcon(new ImageIcon(GlobalVar.img_dualscreen_ricercaprof_bg));
		this.add(background,1);
		
		BufferedImage tmp ;
		
		// rimuovo le ore aggiunte precedentemente
		for(int i=0;i<this.getComponentCount();i++){
			this.remove(this.getComponent(i));
		}
		
		// addo le ore all'orologio a seconda del set passato
		for (Entry<Integer,String> entry : entries) {
			JLabel h = new JLabel("");
			h.setBounds(0, 0, 1920, 1080);
			h.setOpaque(false);
			  int key = entry.getKey();

			  
			  try {
				  String path ="/images/"+key+".png";
				  System.out.println(path);
				tmp = ImageIO.read(getClass().getResource(path));
				h.setIcon(new ImageIcon(tmp));
				this.add(h,0);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			}
		this.repaint();
	
		
	}

}
