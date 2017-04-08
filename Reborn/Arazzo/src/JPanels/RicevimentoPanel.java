package JPanels;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Global.GlobalVar;
import combobox.PCIIComboBox;
import ricevimentoProfessore.FindOrarioRicevimentoProfessore;
import ricevimentoProfessore.Professori;

public class RicevimentoPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	int nuProfessori = 188;    //importante!   , dimensione del vettore per immagazzinare i professori
	private JTextField giorno;
	private JTextField orario;
	private FindOrarioRicevimentoProfessore f;
	Image arrowup ;
	Image arrowdown;
	
	public RicevimentoPanel() {
		setOpaque(false); //sfondo trasparente del panel per permettere la visione dello sfondo del jframe

		this.setLayout(null);
		this.setBounds(0, 0, 1280, 1024);
		
		 Set <String> tmp = null;
    	 
		 arrowup = GlobalVar.img_drop_arrow_up.getScaledInstance(15, 15,
			        Image.SCALE_SMOOTH);
		 arrowdown= GlobalVar.img_drop_arrow_down.getScaledInstance(15, 15,
			        Image.SCALE_SMOOTH);
			
		 
    	Professori p;
		try {
			p = new Professori();
			tmp =  p.getProfessori(); 
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
		String[] professori = new String[nuProfessori];  // stringa che conterra' tutti i professori
		int i=0;
		 for (Iterator<String> it = tmp.iterator(); it.hasNext(); ) {
		        String obj = it.next();
		        if(!obj.equals("") && !obj.equals(" ")){
		        	professori[i] = obj;
		        	i++;
		        }
		    }
		 
		//freccetta per professori
			final JLabel arrow = new JLabel("");
			arrow.setIcon(new ImageIcon(arrowup));
			arrow.setBounds(249, 342, 20, 20);
			add(arrow);
    	
			 giorno = new JTextField();
			 giorno.setHorizontalAlignment(SwingConstants.CENTER);
			 giorno.setFont(new Font("Oswald", Font.PLAIN, 30));
			 giorno.setBorder(null);
			 giorno.setOpaque(false);
			 giorno.setEditable(false);
			 giorno.setBounds(512, 336, 236, 37);
				add(giorno);
				giorno.setColumns(10);
			
			 orario = new JTextField();
			 orario.setHorizontalAlignment(SwingConstants.CENTER);
			 orario.setFont(new Font("Oswald", Font.PLAIN, 30));
			 orario.setBorder(null);
			 orario.setOpaque(false);
			 orario.setEditable(false);
			 orario.setBounds(780, 336, 236, 37);
				add(orario);
				orario.setColumns(10);
    	
		final PCIIComboBox comboBox = new PCIIComboBox(professori);
		comboBox.setMaximumRowCount(15);
		comboBox.setFont(new Font("Oswald", Font.BOLD, 22));
		comboBox.addItemListener(new ItemListener() {
		      public void itemStateChanged(ItemEvent e) {
		    	  arrow.setIcon(new ImageIcon(arrowup));
					try {
						
						f = new FindOrarioRicevimentoProfessore(comboBox.getSelectedItem().toString());
						f.getRisultato();
						//System.out.print(f.getGiorno() + " " + f.getOrario());
						giorno.setText(f.getGiorno());
						orario.setText(f.getOrario());
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
		      });
		comboBox.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				arrow.setIcon(new ImageIcon(arrowdown));
			}
		});
		comboBox.setBounds(267, 340, 200, 30);
		
		add(comboBox);
		
		JLabel background = new JLabel("");
		background.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 arrow.setIcon(new ImageIcon(arrowup));
			}
		});
		background.setIcon(new ImageIcon(GlobalVar.img_ricevimento_panel));
		background.setBounds(0, 0, 1280, 1024);
		add(background);
		
		try {
			f = new FindOrarioRicevimentoProfessore(professori[0]);
			f.getRisultato();
			//System.out.print(f.getGiorno() + " " + f.getOrario());
			giorno.setText(f.getGiorno());
			orario.setText(f.getOrario());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
