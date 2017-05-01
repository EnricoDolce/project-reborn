package JPanels;

import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;
import java.util.Map.Entry;

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

/**
 * JPanel per la ricerca del professore
 *
 */
public class RicercaProfPanel extends JPanel {

	/**
	 * numero professori
	 */
	int nProf = 187; // ! numero professori
	/**
	 *  ora da ricercare
	 */
	int ora=0;
	/**
	 * giorno da ricercare
	 */
	String giorno;
	/**
	 * prof da ricercare
	 */
	String prof;
	
	Image arrowup ;
	Image arrowdown;
	/**
	 * HashMap utilizzata per costruire l'orologio dinamico
	 */
	HashMap orologio = new HashMap();
	
	/**
	 * TextField utilizzato per la visualizzazione a schermo del risultato della ricerca
	 */
	private JTextField textField;
	
	
	public RicercaProfPanel() {
		setOpaque(false); //sfondo trasparente del panel per permettere la visione dello sfondo del jframe

		Date date = new Date();   // given date
		Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
		calendar.setTime(date);   // assigns calendar to given date 
		ora = (calendar.get(Calendar.HOUR_OF_DAY) - 8);
		
		
		
		switch (date.getDay()) {
		case 1:
			giorno = "lunedi";
			break;
		case 2:
			giorno = "martedi";
			break;
		case 3:
			giorno = "mercoledi";
			break;
		case 4:
			giorno = "giovedi";
			break;
		case 5:
			giorno = "venerdi";
			break;
		case 6:
			giorno = "sabato";
			break;
		case 0:
			giorno = "domenica";
			break;

		}
		
		
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 1024);
		
		Color c = new Color(246,219,104);
		
		 arrowup = GlobalVar.img_drop_arrow_up.getScaledInstance(30, 30,
		        Image.SCALE_SMOOTH);
		 arrowdown= GlobalVar.img_drop_arrow_down.getScaledInstance(30, 30,
		        Image.SCALE_SMOOTH);
		
		 /**
		  * Oggetto GestioneProfessori 
		  */
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
		
			/**
			 * array di stringhe contenenti i giorni della settimana
			 */
			String[] giorni = new String[]{"Lunedi","Martedi","Mercoledi","Giovedi","Venerdi","Sabato"};
			
			/**
			 * array di stringhe contenenti i prof
			 */
			String[] professori = new String[nProf];  // stringa che conterra' tutti i professori

			for(int i=0;i<nProf;i++){
				//System.out.println(tmp.get(i));
				professori[i] = tmp.get(i).toString();
			}
			
			prof = professori[0];
			
			
			orologio = gestione.cercaProfessoreInGiorno(prof,giorno);
			 Set<Entry> entries = orologio.entrySet(); 
			 System.out.println(entries.toString());
			GlobalVar.screenricercaprof.setHour(entries);
			
			//freccetta per professori
			final JLabel arrow1 = new JLabel("");
			arrow1.setIcon(new ImageIcon(arrowup));
			arrow1.setBounds(60, 270, 50, 50);
			add(arrow1);
			//freccetta per giorni
			final JLabel arrow2 = new JLabel("");
			arrow2.setIcon(new ImageIcon(arrowup));
			arrow2.setBounds(500, 270, 50, 50);
			add(arrow2);
			//freccetta per ore
			final JLabel arrow3 = new JLabel("");
			arrow3.setIcon(new ImageIcon(arrowup));
			arrow3.setBounds(925, 270, 50, 50);
			add(arrow3);
			
		
			textField = new JTextField();
			textField.setForeground(c);
			textField.setEditable(false);
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setFont(new Font("Oswald", Font.BOLD, 35));
			textField.setBorder(null);
			textField.setOpaque(false);
			textField.setBounds(342, 930, 600, 40);
			add(textField);
			textField.setColumns(10);
			
			/**
			 * Combobox per la scelta dell'ora
			 */
			final PCIIComboBox OrecomboBox = new PCIIComboBox(ore);
			OrecomboBox.setBounds(965, 270, 200, 50);
			OrecomboBox.setForeground(new Color(91,81,80));
			OrecomboBox.setFont(new Font("Oswald", Font.BOLD, 22));
			OrecomboBox.setSelectedIndex(ora);
			OrecomboBox.addItemListener(new ItemListener() {
			      public void itemStateChanged(ItemEvent e) {
			    	  arrow3.setIcon(new ImageIcon(arrowup));
			    	  
						ora = OrecomboBox.getSelectedIndex();
						String tmp = gestione.cercaProfessoreInOra(prof, ora+1, giorno);
						if(tmp.equals("") || tmp.equals(" "))
							textField.setText("non effettua lezioni in questa ora");
						else if(tmp.equals("R"))
							textField.setText("ora dedicata al ricevimento genitori");
						else if(tmp.equals("D"))
							textField.setText("ora disponibile del professore");
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
			
			/**
			 * Combobox per la scelta del giorno
			 */
			final PCIIComboBox GiornicomboBox = new PCIIComboBox(giorni);
			GiornicomboBox.setBounds(545, 270, 200, 50);
			GiornicomboBox.setForeground(new Color(91,81,80));
			GiornicomboBox.setFont(new Font("Oswald", Font.BOLD, 22));
			GiornicomboBox.setSelectedIndex(date.getDay()-1);
			GiornicomboBox.addItemListener(new ItemListener() {
			      public void itemStateChanged(ItemEvent e) {
			    	  arrow2.setIcon(new ImageIcon(arrowup));
			    	
			    	  giorno = GiornicomboBox.getSelectedItem().toString().toLowerCase();
			    	  String tmp = gestione.cercaProfessoreInOra(prof, ora+1, giorno);
			    	  
			    	  orologio = gestione.cercaProfessoreInGiorno(prof,giorno);
						 Set<Entry> entries = orologio.entrySet();
						 System.out.println(entries.toString());
						GlobalVar.screenricercaprof.setHour(entries);
			    	  
						if(tmp.equals("") || tmp.equals(" "))
							textField.setText("non effettua lezioni in questa ora");
						else if(tmp.equals("R"))
							textField.setText("ora dedicata al ricevimento genitori");
						else if(tmp.equals("D"))
							textField.setText("ora disponibile del professore");
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

			/**
			 * Combobox per la scelta del prof
			 */
			final PCIIComboBox ProfcomboBox = new PCIIComboBox(professori);
			ProfcomboBox.setBounds(100, 270, 200, 50);
			ProfcomboBox.setForeground(new Color(91,81,80));
			ProfcomboBox.setFont(new Font("Oswald", Font.BOLD, 22));
			ProfcomboBox.addItemListener(new ItemListener() {
			      public void itemStateChanged(ItemEvent e) {
			    	  
			    	  arrow1.setIcon(new ImageIcon(arrowup));
			    	
			    	  prof = ProfcomboBox.getSelectedItem().toString();
			    	
						String tmp = gestione.cercaProfessoreInOra(prof, ora+1, giorno);

						orologio = gestione.cercaProfessoreInGiorno(prof,giorno);
						 Set<Entry> entries = orologio.entrySet();
						 System.out.println(entries.toString());
						GlobalVar.screenricercaprof.setHour(entries);
						
						if(tmp.equals("") || tmp.equals(" "))
							textField.setText("non effettua lezioni in questa ora");
						else if(tmp.equals("R"))
							textField.setText("ora dedicata al ricevimento genitori");
						else if(tmp.equals("D"))
							textField.setText("ora disponibile del professore");
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
			
			//quando apro il panel mi fa la ricerca con i dati di default
			 String app = gestione.cercaProfessoreInOra(prof, ora+1, giorno);
			if(app.equals("") || app.equals(" "))
				textField.setText("non effettua lezioni in questa ora");
			else
				textField.setText(app);
			
	}
}

