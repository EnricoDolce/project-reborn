package JPanels;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Global.GlobalVar;
import variazoniOrari.Variazioni;

public class VariazioniOrarioPanel extends JPanel {

	/**
	 * Creazione del panel delle variazioni orario
	 * @throws IOException 
	 */
	public VariazioniOrarioPanel() throws IOException {
		setOpaque(false); //sfondo trasparente del panel per permettere la visione dello sfondo del jframe

		this.setLayout(null);
		this.setBounds(0, 0, 1280, 1024);
		
//		
//		Variazioni tmp = new Variazioni("/home/enrico/Documents/variazioni.pdf",
//				"/home/enrico/GitHub/project-reborn/Reborn/Arazzo/resources/imgPDF/variazioniorario.jpg");
		Variazioni tmp = new Variazioni(GlobalVar.pathDayPdf,GlobalVar.pathDayJPG);
		
		try{
			tmp.toJpg();
			}
		catch(Exception e){
			System.out.println(e);
		}
		
		
		JLabel label = new JLabel("");
		label.setBounds(218,213,842,595); //(230,238,842,595)
		
		/**
		 * immagine della variazione
		 */
		BufferedImage img = null;
		try {
					img = ImageIO.read(getClass().getResource("/imgPDF/variazioniorario.jpg"));
				
		} catch (IOException e) {
		    e.printStackTrace();
		}

		//scalo l'immagine
		Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(),
		        Image.SCALE_SMOOTH);
		
		
		label.setIcon(new ImageIcon(dimg));
		add(label);
		
		JLabel background = new JLabel("");
		
		background.setIcon(new ImageIcon(GlobalVar.img_variazioni_background));
		background.setBounds(0, 0, 1280, 1024);
		add(background);
		
		
	}

}
