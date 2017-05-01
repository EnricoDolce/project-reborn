package JPanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import Global.GlobalVar;
import dualScreenPanels.ScreenRicercaProf;
import dualscreen.DualScreenFrame;

public class SceltaModuloPanel extends JPanel {


	public SceltaModuloPanel() {
		setOpaque(false);
		this.setBounds(0, 0, 1280, 1024);
		setLayout(null);
	

		//base per non far passare il click oltre la toolbar e di conseguenza cliccare altre cose sotto di essa
//				JButton base = new JButton("");
//				base.setBorderPainted(false);
//				base.setContentAreaFilled(false); 
//				base.setBounds(0, 0, 446, 994);
//				add(base);
				
		if(GlobalVar.Interno==true)
		{
			
			/**
			 * Bottone del modulo che permette di fare la ricerca del professore
			 */
			final JButton ricercaProf = new JButton();
			
			ricercaProf.setIcon(new ImageIcon(GlobalVar.img_btn_mod_ricercaprof));
			ricercaProf.setFont(new Font("Oswald", Font.BOLD, 28));
			ricercaProf.setForeground(Color.decode("#565656"));
			ricercaProf.setVerticalTextPosition(JButton.CENTER);
			ricercaProf.setHorizontalTextPosition(JButton.CENTER);
			ricercaProf.setBorderPainted(false);
			ricercaProf.setFocusPainted(false);
			ricercaProf.setContentAreaFilled(false);
			ricercaProf.setBounds(15, 270, 280, 480);
			
			ricercaProf.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					
					ricercaProf.setIcon(new ImageIcon(GlobalVar.img_btn_mod_ricercaprof_pressed));
				}
				public void mouseReleased(MouseEvent arg0) {
	
					ricercaProf.setIcon(new ImageIcon(GlobalVar.img_btn_mod_ricercaprof));
					
					GlobalVar.dualscreenframe.DualScreenVisible(true);
					GlobalVar.screenricercaprof = new ScreenRicercaProf();
					GlobalVar.dualscreenframe.DualScreenGoToPanel(GlobalVar.screenricercaprof);		
					
					JPanel tmp = new RicercaProfPanel();
						
							
							GlobalVar.GoToPanel(tmp);
				}
					
			});
		
			/**
			 * bottone del modulo che permette di visualizzare la planimetria
			 */
			final JButton planimetria = new JButton();
			
			planimetria.setIcon(new ImageIcon(GlobalVar.img_btn_mod_planimetria));
			planimetria.setFont(new Font("Oswald", Font.BOLD, 28));
			planimetria.setForeground(Color.decode("#565656"));
			planimetria.setVerticalTextPosition(JButton.CENTER);
			planimetria.setHorizontalTextPosition(JButton.CENTER);
			planimetria.setBorderPainted(false);
			planimetria.setFocusPainted(false);
			planimetria.setContentAreaFilled(false);
			planimetria.setBounds(240+15, 270, 280, 480);
			
			planimetria.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					
					planimetria.setIcon(new ImageIcon(GlobalVar.img_btn_mod_planimetria_pressed));
				}
				public void mouseReleased(MouseEvent arg0) {
	
					planimetria.setIcon(new ImageIcon(GlobalVar.img_btn_mod_planimetria));
					
							
				}
					
			});
			
			/**
			 * bottone del modulo che permette di visualizzare quando un prof fa ricevimento
			 */
			final JButton ricevimento = new JButton();
			
			ricevimento.setIcon(new ImageIcon(GlobalVar.img_btn_mod_ricevimento));
			ricevimento.setFont(new Font("Oswald", Font.BOLD, 28));
			ricevimento.setForeground(Color.decode("#565656"));
			ricevimento.setVerticalTextPosition(JButton.CENTER);
			ricevimento.setHorizontalTextPosition(JButton.CENTER);
			ricevimento.setBorderPainted(false);
			ricevimento.setFocusPainted(false);
			ricevimento.setContentAreaFilled(false);
			ricevimento.setBounds((240*2)+15, 270, 280, 480);
			
			ricevimento.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					
					ricevimento.setIcon(new ImageIcon(GlobalVar.img_btn_mod_ricevimento_pressed));
				}
				public void mouseReleased(MouseEvent arg0) {
	
					ricevimento.setIcon(new ImageIcon(GlobalVar.img_btn_mod_ricevimento));
					
							JPanel tmp = new RicevimentoPanel();
						
							
							GlobalVar.GoToPanel(tmp);
				}
					
			});
			
			/** 
			 * bottone del modulo che permetta la visualizzazione delle comunicazioni
			 */
			final JButton comunicazioni = new JButton();
			
			comunicazioni.setIcon(new ImageIcon(GlobalVar.img_btn_mod_comunicazioni));
			comunicazioni.setFont(new Font("Oswald", Font.BOLD, 28));
			comunicazioni.setForeground(Color.decode("#565656"));
			comunicazioni.setVerticalTextPosition(JButton.CENTER);
			comunicazioni.setHorizontalTextPosition(JButton.CENTER);
			comunicazioni.setBorderPainted(false);
			comunicazioni.setFocusPainted(false);
			comunicazioni.setContentAreaFilled(false);
			comunicazioni.setBounds((240*3)+15, 270, 280, 480);
			
			comunicazioni.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					
					comunicazioni.setIcon(new ImageIcon(GlobalVar.img_btn_mod_comunicazioni_pressed));
				}
				public void mouseReleased(MouseEvent arg0) {
	
					comunicazioni.setIcon(new ImageIcon(GlobalVar.img_btn_mod_comunicazioni));
					
							JPanel tmp = new ComunicazioniPanel();
							
							GlobalVar.GoToPanel(tmp);
				}
					
			});
			
			/**
			 * Bottono che consente la visualizzazione delle variazioni di orario giornaliere
			 */
			final JButton variazioni = new JButton();
			
			variazioni.setIcon(new ImageIcon(GlobalVar.img_btn_mod_variazioni));
			variazioni.setFont(new Font("Oswald", Font.BOLD, 28));
			variazioni.setForeground(Color.decode("#565656"));
			variazioni.setVerticalTextPosition(JButton.CENTER);
			variazioni.setHorizontalTextPosition(JButton.CENTER);
			variazioni.setBorderPainted(false);
			variazioni.setFocusPainted(false);
			variazioni.setContentAreaFilled(false);
			variazioni.setBounds((240*4)+15, 270, 280, 480);
			
			variazioni.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					
					variazioni.setIcon(new ImageIcon(GlobalVar.img_btn_mod_variazioni_pressed));
				}
				public void mouseReleased(MouseEvent arg0) {
	
					variazioni.setIcon(new ImageIcon(GlobalVar.img_btn_mod_variazioni));
					
							JPanel tmp;
							try {
								tmp = new VariazioniOrarioPanel();
								
								GlobalVar.GoToPanel(tmp);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						
				}
				
				
					
			});
			
			this.add(ricercaProf);
			this.add(planimetria);
			this.add(ricevimento);
			this.add(comunicazioni);
			this.add(variazioni);
		}
		else if(GlobalVar.Ospite==true)
		{
			
			
		}
				
				
		
		
	}


	
	

}
