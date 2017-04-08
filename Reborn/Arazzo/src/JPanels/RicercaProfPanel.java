package JPanels;

import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import Global.GlobalVar;
import combobox.PCIIComboBox;
import ricercaprofessore.GestioneProfessori;
import ricercaprofessore.Professore;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class RicercaProfPanel extends JPanel {

	int nProf = 187; // ! numero professori
	int ora=0;
	String giorno="lunedi";
	String prof="aldi";
	Image arrowup ;
	Image arrowdown;
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public RicercaProfPanel() {
		setOpaque(false); //sfondo trasparente del panel per permettere la visione dello sfondo del jframe

		this.setLayout(null);
		this.setBounds(0, 0, 1280, 1024);
		
		 arrowup = GlobalVar.img_drop_arrow_up.getScaledInstance(15, 15,
		        Image.SCALE_SMOOTH);
		 arrowdown= GlobalVar.img_drop_arrow_down.getScaledInstance(15, 15,
		        Image.SCALE_SMOOTH);
		
		final GestioneProfessori gestione = new GestioneProfessori();
		gestione.caricaProfessori();
		Vector<Professore> tmp = null;
		tmp = gestione.getProfessori();
		
		if(tmp == null)
			System.out.print("nessun porf trovato , controllare nome file xls");
	
			String[] ore = new String[17];  
			int j=0;
			
			for(int i=8;i<24;i++){
				ore[j]= i+":00 - "+(i+1)+":00";
				j++;
			}
		
			String[] giorni = new String[]{"Lunedi","Martedi","Mercoledi","Giovedi","Venerdi","Sabato"};
			
			String[] professori = new String[nProf];  // stringa che conterra' tutti i professori

			for(int i=0;i<nProf;i++){
				//System.out.println(tmp.get(i));
				professori[i] = tmp.get(i).toString();
			}
			
			//freccetta per professori
			final JLabel arrow1 = new JLabel("");
			arrow1.setIcon(new ImageIcon(arrowup));
			arrow1.setBounds(249, 302, 20, 20);
			add(arrow1);
			//freccetta per giorni
			final JLabel arrow2 = new JLabel("");
			arrow2.setIcon(new ImageIcon(arrowup));
			arrow2.setBounds(515, 302, 20, 20);
			add(arrow2);
			//freccetta per ore
			final JLabel arrow3 = new JLabel("");
			arrow3.setIcon(new ImageIcon(arrowup));
			arrow3.setBounds(770, 302, 20, 20);
			add(arrow3);
			
			
			textField = new JTextField();
			textField.setBackground(Color.WHITE);
			textField.setEditable(false);
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setFont(new Font("Oswald", Font.PLAIN, 35));
			textField.setBorder(null);
			textField.setOpaque(false);
			textField.setBounds(329, 847, 600, 40);
			add(textField);
			textField.setColumns(10);
			
			
			final PCIIComboBox OrecomboBox = new PCIIComboBox(ore);
			OrecomboBox.setBounds(788, 300, 200, 30);
			OrecomboBox.setFont(new Font("Oswald", Font.BOLD, 22));
			OrecomboBox.addItemListener(new ItemListener() {
			      public void itemStateChanged(ItemEvent e) {
			    	  arrow3.setIcon(new ImageIcon(arrowup));
			    	  
						ora = OrecomboBox.getSelectedIndex();
						String tmp = gestione.cercaProfessoreInOra(prof, ora+1, giorno);
						if(tmp.equals("") || tmp.equals(" "))
							textField.setText("non effettua lezioni in questa ora");
						else
							textField.setText(tmp);
			        }
			      });
			OrecomboBox.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					arrow3.setIcon(new ImageIcon(arrowdown));
				}
			});
			add(OrecomboBox);
			
			final PCIIComboBox GiornicomboBox = new PCIIComboBox(giorni);
			GiornicomboBox.setBounds(533, 300, 200, 30);
			GiornicomboBox.setFont(new Font("Oswald", Font.BOLD, 22));
			GiornicomboBox.addItemListener(new ItemListener() {
			      public void itemStateChanged(ItemEvent e) {
			    	  arrow2.setIcon(new ImageIcon(arrowup));
			    	
			    	  giorno = GiornicomboBox.getSelectedItem().toString().toLowerCase();
			    	  String tmp = gestione.cercaProfessoreInOra(prof, ora+1, giorno);
						if(tmp.equals("") || tmp.equals(" "))
							textField.setText("non effettua lezioni in questa ora");
						else
							textField.setText(tmp);
			        }
			      });
			GiornicomboBox.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					arrow2.setIcon(new ImageIcon(arrowdown));
				}
			});
			add(GiornicomboBox);

			
			final PCIIComboBox ProfcomboBox = new PCIIComboBox(professori);
			ProfcomboBox.setBounds(267, 300, 200, 30);
			ProfcomboBox.setFont(new Font("Oswald", Font.BOLD, 22));
			ProfcomboBox.addItemListener(new ItemListener() {
			      public void itemStateChanged(ItemEvent e) {
			    	  
			    	  arrow1.setIcon(new ImageIcon(arrowup));
			    	
			    	  prof = ProfcomboBox.getSelectedItem().toString();
			    	  
			    	  	System.out.println(prof);
						System.out.println(ora);
						System.out.println(giorno);
						String tmp = gestione.cercaProfessoreInOra(prof, ora+1, giorno);
						if(tmp.equals("") || tmp.equals(" "))
							textField.setText("non effettua lezioni in questa ora");
						else
							textField.setText(tmp);
			        }
			      });
			ProfcomboBox.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					arrow1.setIcon(new ImageIcon(arrowdown));
				}
			});
			add(ProfcomboBox);
			ProfcomboBox.setMaximumRowCount(15);
			
		
			
			JLabel background = new JLabel("");
			background.setIcon(new ImageIcon(GlobalVar.img_ricercaprof_panel));
			background.setBounds(0, 0, 1280, 1024);
			background.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					 arrow1.setIcon(new ImageIcon(arrowup));
					 arrow2.setIcon(new ImageIcon(arrowup));
					 arrow3.setIcon(new ImageIcon(arrowup));
				}
			});
			add(background);
			
			 String app = gestione.cercaProfessoreInOra(prof, ora+1, giorno);
			if(app.equals("") || app.equals(" "))
				textField.setText("non effettua lezioni in questa ora");
			else
				textField.setText(app);
			
	}
}

