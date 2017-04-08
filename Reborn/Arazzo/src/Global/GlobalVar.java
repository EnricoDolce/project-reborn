package Global;
import java.awt.Image;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import JPanels.OspitiInterniPanel;

/**
 * Classe che contiene tutte le variabili che servono istanziate staticamente come le immagini , in modo da non creare rallentamenti in runtime al costo di aspettare qualche secondo all'avvio del SW,
 * la classe contiene anche delle variabili che sono utili durante la programmazione come il frame o lo stack
 *	
 *	le variabili che iniziano con img_ sono immagini , quelle che iniziano con path_ sono i percorsi delle immagini all'interno del progetto.
 *	
 */

public class GlobalVar {
	
	public static JPanel toolbar;
	public static JFrame frame;  // frame principale
	
	public static Image img_btn_ospiti;
	public static Image img_btn_ospiti_pressed;
	public static Image img_btn_interni;
	public static Image img_btn_interni_pressed;
	public static Image img_btn_mod;  // bottone per scelta moduli
	public static Image img_btn_mod_pressed;
	public static Image img_background;
	public static Image img_home;   // bottone home toolbar
	public static Image img_home_pressed; // home premuto toolbar
	public static Image img_close_menu;  // X
	public static Image img_open_menu;  // tre linee
	public static Image img_navigation_menu;
	public static Image img_blur;
	public static Image img_ricevimento_panel;
	public static Image img_ricercaprof_panel;
	public static Image img_drop_arrow_down;  //freccetta per capire dove cliccare
	public static Image img_drop_arrow_up;    //freccetta per capire dove cliccare
	public static Image img_left_arrow;      //frecce toolbar
	public static Image img_right_arrow;
	public static Image img_left_arrow_pressed;
	public static Image img_right_arrow_pressed;
	public static Image img_comunicazioni_background;
	public static Image img_com_left_arrow;
	public static Image img_com_right_arrow;
	public static Image img_variazioni_background;
	
	public static String path_btn_ospiti = "/images/btn_ospiti.png";
	public static String path_btn_ospiti_pressed = "/images/btn_ospiti_pressed.png";
	public static String path_btn_interni = "/images/btn_interni.png";
	public static String path_btn_interni_pressed = "/images/btn_interni_pressed.png";
	public static String path_background = "/images/background.png";
	public static String path_home = "/images/home.png";
	public static String path_home_pressed = "/images/home_pressed.png";
	public static String path_close_menu = "/images/close_cross.png";
	public static String path_open_menu = "/images/menu_icon.png";
	public static String path_navigation_menu = "/images/navigation_menu.png";
	public static String path_blur = "/images/blur.png";
	public static String path_ricevimento_panel = "/images/ricevimento_panel.png";
	public static String path_ricercaporf_panel = "/images/ricercaprof_panel.png";
	public static String path_btn_mod = "/images/btn_mod.png";
	public static String path_btn_mod_presssed =  "/images/btn_mod_pressed.png";
	public static String path_drop_arrow_down = "/images/drop_arrow_down.png";
	public static String path_drop_arrow_up = "/images/drop_arrow_up.png";
	public static String path_left_arrow = "/images/left_arrow.png";
	public static String path_left_arrow_pressed = "/images/left_arrow_pressed.png";
	public static String path_right_arrow = "/images/right_arrow.png";
	public static String path_right_arrow_pressed = "/images/right_arrow_pressed.png";
	public static String path_comunicazioni_background = "/images/comunicazioni_background.png";
	public static String path_com_left_arrow = "/images/com_left_arrow.png";
	public static String path_com_right_arrow = "/images/com_right_arrow.png";
	public static String path_variazioni_background = "/images/variazioni_background.png";
	
	public static int StackPosition=0;
	public static Vector<JPanel> Stack = new Vector<JPanel>(1,1);
	
	public static boolean Ospite = false;   // flag per capire se e' stato selezionato ospite o interno
	public static boolean Interno = false;
	
	
	/**
	 * Costruttore che istanzia le variabili.
	 */
	public GlobalVar()
	{
		
		//istanzio tutte le immagini
		try{
			
			img_btn_interni =ImageIO.read(getClass().getResource(path_btn_interni));
			img_btn_ospiti =ImageIO.read(getClass().getResource(path_btn_ospiti));
			img_btn_ospiti_pressed = ImageIO.read(getClass().getResource(path_btn_ospiti_pressed));
			img_btn_interni_pressed = ImageIO.read(getClass().getResource(path_btn_interni_pressed));
			img_background =  ImageIO.read(getClass().getResource(path_background));
			img_home = ImageIO.read(getClass().getResource(path_home));
			img_home_pressed = ImageIO.read(getClass().getResource(path_home_pressed));
			img_close_menu = ImageIO.read(getClass().getResource(path_close_menu));
			img_open_menu = ImageIO.read(getClass().getResource(path_open_menu));
			img_navigation_menu = ImageIO.read(getClass().getResource(path_navigation_menu));
			img_blur = ImageIO.read(getClass().getResource(path_blur));
			img_ricevimento_panel = ImageIO.read(getClass().getResource(path_ricevimento_panel));
			img_ricercaprof_panel = ImageIO.read(getClass().getResource(path_ricercaporf_panel));
			img_btn_mod = ImageIO.read(getClass().getResource(path_btn_mod));
			img_btn_mod_pressed = ImageIO.read(getClass().getResource(path_btn_mod_presssed));
			img_drop_arrow_down = ImageIO.read(getClass().getResource(path_drop_arrow_down));
			img_drop_arrow_up = ImageIO.read(getClass().getResource(path_drop_arrow_up));
			img_left_arrow = ImageIO.read(getClass().getResource(path_left_arrow));
			img_left_arrow_pressed = ImageIO.read(getClass().getResource(path_left_arrow_pressed));
			img_right_arrow = ImageIO.read(getClass().getResource(path_right_arrow));
			img_right_arrow_pressed = ImageIO.read(getClass().getResource(path_right_arrow_pressed));
			img_comunicazioni_background = ImageIO.read(getClass().getResource(path_comunicazioni_background));
			img_com_left_arrow = ImageIO.read(getClass().getResource(path_com_left_arrow));
			img_com_right_arrow = ImageIO.read(getClass().getResource(path_com_right_arrow));
			img_variazioni_background = ImageIO.read(getClass().getResource(path_variazioni_background));
			
			Stack.add(0,new OspitiInterniPanel());
			
		
		}catch(Exception e){
			
			e.printStackTrace();
		}
	
	}
	
	public static int StackContains(JPanel tmp)
	{
		for(int i=0 ;i<Stack.size();i++){
			
			if(Stack.get(i) == tmp )
				return i;
			
		}
		return -1;
	}
	
public static void GoToPanel (JPanel tmp){  // da migliorare  ( possibilmente se esiste il jpanel andare direttamente alla posizione dello stack in cui e' istanziato ed eliminare i successivi (forse))
		
		if((GlobalVar.Stack.get(GlobalVar.StackPosition).getClass()).equals(tmp.getClass())) //controlla se si tenta di aprire la stessa finestra
		{
			
			
		}
		else
		{
			
			GlobalVar.frame.getContentPane().remove(1);  // + 2 perche 0  e 1 sono riservati alla toolbar e al menu
			GlobalVar.frame.getContentPane().add(tmp,1);
			
		
			
			GlobalVar.StackPosition++;
			if(GlobalVar.Stack.size() == GlobalVar.StackPosition)    // se l'indice dello stack non e' istanziato
				GlobalVar.Stack.add(GlobalVar.StackPosition,tmp);    // add jpanl
			else													// altrimenti					
				GlobalVar.Stack.set(GlobalVar.StackPosition,tmp);	// set jpanl
	
		}
		GlobalVar.frame.repaint();
		GlobalVar.frame.getContentPane().repaint();  // i repaint servono per far si che la grafica si aggiorni , altrimenti diventa tutto glitchato
		
	}
	


}
