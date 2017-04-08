package JPanels;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Global.GlobalVar;

public class ToolBar extends JPanel {

	/**
	 * Creo il JPanel che andra' a gestire i movimenti per tornare alla pagina precendente o successiva , questa classe utilizza lo Stack e la StackPosition che si trovano nella classe GlobalVar.
	 *
	 * @see GlobalVar
	 */
	public ToolBar() {
		setBackground(SystemColor.window);
		setOpaque(false);
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 100);


		final JButton left = new JButton("");
		left.setBorderPainted(false);
		left.setFocusPainted(false);
		left.setContentAreaFilled(false);
		left.setIcon(new ImageIcon(GlobalVar.img_left_arrow));
		left.setBounds(10, 5, 60, 60);
		add(left);

		
		final JButton home = new JButton("");
		home.setBorderPainted(false);
		home.setContentAreaFilled(false);
		home.setIcon(new ImageIcon(GlobalVar.img_home));
		home.setBounds(1180,-15, 100, 100);
		add(home);
	
		
		//base per non far passare il click oltre la toolbar e di conseguenza cliccare altre cose sotto di essa
		JButton base = new JButton("");
		base.setBorderPainted(false);
		base.setContentAreaFilled(false); 
		base.setBounds(1180,0, 100, 100);
		add(base);
		

		left.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				
			
				left.setIcon(new ImageIcon(GlobalVar.img_left_arrow_pressed));
				
			
				System.out.println("Bottone back premuto");
	
			}
			public void mouseReleased(MouseEvent arg0) {
				
				
				left.setIcon(new ImageIcon(GlobalVar.img_left_arrow));
				if(GlobalVar.StackPosition  > 0)  // se voglio tornare indietro e non vado in underflow
				{
					GlobalVar.Stack.set(GlobalVar.StackPosition, null);
					GlobalVar.StackPosition--; // decremento la posizione attuale in cui mi trovo
					
					GlobalVar.frame.getContentPane().remove(1); // rimuovo il Jpanel che sta nell'indice 2 del frame
					GlobalVar.frame.getContentPane().add(GlobalVar.Stack.get(GlobalVar.StackPosition),1); // setto il Jpanel che e' stato aperto precedentemente
					GlobalVar.frame.repaint();
					GlobalVar.frame.getContentPane().repaint(); // aggiorno la grafica
					
					if(GlobalVar.StackPosition == 0) // se mi trovo alla schermata principale , o scelta moduli
					{
						
						GlobalVar.toolbar.setVisible(false); // rendo invisibile la toolbar
					}
				}
				
				
			}
		});
		
		
		home.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				
			
				home.setIcon(new ImageIcon(GlobalVar.img_home_pressed));
				
			
				System.out.println("Bottone back premuto");
	
			}
			public void mouseReleased(MouseEvent arg0) {
				
				
				home.setIcon(new ImageIcon(GlobalVar.img_home));
				
					GlobalVar.StackPosition = 0; 
					
					GlobalVar.frame.getContentPane().remove(1); // rimuovo il Jpanel che sta nell'indice 2 del frame
					GlobalVar.frame.getContentPane().add(GlobalVar.Stack.get(GlobalVar.StackPosition),1); // setto il Jpanel che e' stato aperto precedentemente
					GlobalVar.frame.repaint();
					GlobalVar.frame.getContentPane().repaint(); // aggiorno la grafica
					
					
						GlobalVar.toolbar.setVisible(false); // rendo invisibile la toolbar
					
				}
		
			
		});
		

	}
}
