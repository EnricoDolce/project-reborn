package Global;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dualscreen.DualScreenFrame;

import JPanels.OspitiInterniPanel;
import dualScreenPanels.ScreenRicercaProf;

/**
 * Classe che contiene tutte le variabili che servono istanziate staticamente come le immagini , in modo da non creare rallentamenti in runtime al costo di aspettare qualche secondo all'avvio del SW,
 * la classe contiene anche delle variabili che sono utili durante la programmazione come il frame o lo stack
 *	
 *	le variabili che iniziano con img_ sono immagini , quelle che iniziano con path_ sono i percorsi delle immagini all'interno del progetto.
 *	
 */

public class GlobalVar {
	
	/**
	 * toolbar con back button e home button
	 */
	public static JPanel toolbar;
	/**
	 * Frame riguardante lo schermo touch
	 */
	public static JFrame frame;  // frame principale
	/**
	 * Frame riguardante lo schermo del televisore
	 */
	public static DualScreenFrame dualscreenframe; // frame secondo schermo
	/**
	 * Panel riguardante l'orologio dinamico
	 */
	public static ScreenRicercaProf screenricercaprof;
	/**
	 * BufferedImage bottone grande servizi
	 */
	public static BufferedImage img_btn_ospiti;
	/**
	 * BufferedImage bottone grande servizi premuto
	 */
	public static BufferedImage img_btn_ospiti_pressed;
	/**
	 * BufferedImage bottone grande info/buzzi
	 */
	public static BufferedImage img_btn_interni;
	/**
	 * BufferedImage bottone grande info/buzzi premuto
	 */
	public static BufferedImage img_btn_interni_pressed;
	/**
	 * BufferedImage di background del frame touch quando si sceglie fra servizi e info
	 */
	public static BufferedImage img_background_scelta;
	/**
	 * BufferedImage di background del frame touch quando si sceglie il modulo nella sezione info
	 */
	public static BufferedImage img_background_buzzi;
	/**
	 * BufferedImage di background del frame touch quando si sceglie il modulo nella sezione servizi
	 */
	public static BufferedImage img_background_servizi;
	/**
	 * BufferedImage del home button utilizzato nella toolbar
	 */
	public static BufferedImage img_home;   // bottone home toolbar
	/**
	 * BufferedImage del home button premuto utilizzato nella toolbar
	 */
	public static BufferedImage img_home_pressed; // home premuto toolbar
	/**
	 * BufferedImage del background utilizzato nel modulo dei ricevimenti
	 */
	public static BufferedImage img_ricevimento_panel;
	/**
	 * BufferedImage del background utilizzato nel modulo della ricerca del professore
	 */
	public static BufferedImage img_ricercaprof_panel;
	/**
	 * BufferedImage della freccetta che punta in basso che affianca ogni Combobox in modo da rendere piu intuitivo dove andare a cliccare
	 */
	public static BufferedImage img_drop_arrow_down;  //freccetta per capire dove cliccare
	/**
	 * BufferedImage della freccetta che punta a destra che affianca ogni Combobox in modo da rendere piu intuitivo dove andare a cliccare
	 */
	public static BufferedImage img_drop_arrow_up;    //freccetta per capire dove cliccare
	/**
	 * BufferedImage della freccia utilizzata nella toolbar per tornare alla schermata precedente
	 */
	public static BufferedImage img_left_arrow;      //frecce toolbar
	/**
	 * BufferedImage della freccia premuta, utilizzata nella toolbar per tornare alla schermata precedente
	 */
	public static BufferedImage img_left_arrow_pressed;
	/**
	 * BufferedImage di background del frame touch quando si visualizzano le comunicazioni
	 */
	public static BufferedImage img_comunicazioni_background;
	/**
	 * BufferedImage della freccia utilizzata per passare alla pagina precedente di un file nel modulo delle comunicazioni
	 */
	public static BufferedImage img_com_left_arrow;
	/**
	 * BufferedImage della freccia utilizzata per passare alla pagina successiva di un file nel modulo delle comunicazioni
	 */
	public static BufferedImage img_com_right_arrow;
	/**
	 * BufferedImage di background del frame touch quando si visualizzano le variazioni degli orari della scuola
	 */
	public static BufferedImage img_variazioni_background;
	/**
	 * BufferedImage del bottone del modulo che aprirà la schermata per la ricerca del professore
	 */
	public static BufferedImage img_btn_mod_ricercaprof;
	/**
	 * BufferedImage del bottone del modulo che aprirà la schermata per la visualizzazione della planimetria
	 */
	public static BufferedImage img_btn_mod_planimetria;
	/**
	 * BufferedImage del bottone del modulo che aprirà la schermata per la visualizzazione dell'orario di ricevimento di un professore
	 */
	public static BufferedImage img_btn_mod_ricevimento;
	/**
	 * BufferedImage del bottone del modulo che aprirà la schermata per la visualizzazione delle comunicazioni
	 */
	public static BufferedImage img_btn_mod_comunicazioni;
	/**
	 * BufferedImage del bottone del modulo che aprirà la schermata per la visualizzazione degli orari della scuola
	 */
	public static BufferedImage img_btn_mod_variazioni;
	/**
	 * BufferedImage del bottone premuto, modulo che aprirà la schermata per la visualizzazione della planimetria
	 */
	public static BufferedImage img_btn_mod_ricercaprof_pressed;
	/**
	 * BufferedImage del bottone premuto, modulo che aprirà la schermata per la visualizzazione della planimetria
	 */
	public static BufferedImage img_btn_mod_planimetria_pressed;
	/**
	 * BufferedImage del bottone premuto, modulo che aprirà la schermata per la visualizzazione dell'orario di ricevimento di un professore
	 */
	public static BufferedImage img_btn_mod_ricevimento_pressed;
	/**
	 * BufferedImage del bottone premuto, modulo che aprirà la schermata per la visualizzazione delle comunicazioni
	 */
	public static BufferedImage img_btn_mod_comunicazioni_pressed;
	/**
	 * BufferedImage del bottone premuto, modulo che aprirà la schermata per la visualizzazione degli orari della scuola
	 */
	public static BufferedImage img_btn_mod_variazioni_pressed;
	/**
	 * BufferedImage di background del frame dello schermo della tv
	 */
	public static BufferedImage img_dualscreen_ricercaprof_bg;
	
	public static String path_btn_ospiti = "/images/btn_ospiti.png";
	public static String path_btn_ospiti_pressed = "/images/btn_ospiti_pressed.png";
	public static String path_btn_interni = "/images/btn_interni.png";
	public static String path_btn_interni_pressed = "/images/btn_interni_pressed.png";
	public static String path_background_scelta = "/images/background_scelta.png";
	public static String path_background_buzzi = "/images/background_buzzi.png";
	public static String path_background_servizi = "/images/background_servizi.png";
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
	public static String path_dualscreen_ricercaprof_bg = "/images/bg_screen_ricerca.png";
	
	public static String path_btn_mod_ricercaprof = "/images/btn_mod_ricercaProf.png";
	public static String path_btn_mod_planimetria = "/images/btn_mod_planimetria.png";
	public static String path_btn_mod_ricevimento = "/images/btn_mod_ricevimento.png";
	public static String path_btn_mod_comunicazioni = "/images/btn_mod_comunicazioni.png";
	public static String path_btn_mod_variazioni = "/images/btn_mod_variazioni.png";
	public static String path_btn_mod_ricercaprof_pressed = "/images/btn_mod_ricercaProf_pressed.png";
	public static String path_btn_mod_planimetria_pressed = "/images/btn_mod_planimetria_pressed.png";
	public static String path_btn_mod_ricevimento_pressed = "/images/btn_mod_ricevimento_pressed.png";
	public static String path_btn_mod_comunicazioni_pressed = "/images/btn_mod_comunicazioni_pressed.png";
	public static String path_btn_mod_variazioni_pressed = "/images/btn_mod_variazioni_pressed.png";
	
	/**
	 * Path riguardante lo shell script che si occupa di scaricare le comunicazioni
	 */
	public static String pathComSh="/home/arazzo/Arazzo/resources/downloadComunicazioni.sh";  //path del .sh per il download
	/**
	 * Path che serve allo shell script per sapere dove salvare i pdf delle comunicazioni convertiti in immagini
	 */
	public static String pathComJPG="/home/arazzo/Arazzo/resources/imgPDF/";  //path della cartella dove andranno inserite le immagini renderizzate
	/**
	 * Path che serve allo shell script per sapere i nomi dei .pdf da renderizzare
	 */
	public static String pathComNew="/home/arazzo/Arazzo/resources/pdf/toImg.txt";  //path del .txt dove sono presenti i nomi dei .pdf da renderizzare
	/**
	 * Path che serve allo shell script per sapere dove salvare i pdf delle comunicazioni
	 */
	public static String pathComPDF="/home/arazzo/Arazzo/resources/pdf";  //path della cartella dove sono presenti i .pdf scaricati
	/**
	 * Path che serve allo shell script per sapere path del .txt dove sono presenti i link per il download dei .pdf
	 */
	public static String pathCom="/home/arazzo/Arazzo/resources/pdf/link.txt";  //path del .txt dove sono presenti i link per il download dei .pdf
	/**
	 * URL da dove scaricare le comunicazioni 
	 */
	public static String pathComDownload="http://192.168.1.16/comunicazioni";  //URL da dove scaricare le comunicazioni 
	
	/**
	 *  Path del pdf delle variazioni giornaliere
	 */
	public static String pathDayPdf = "/home/arazzo/Variazioni giornaliere orario.pdf";
	/**
	 *  Path del pdf renderizzato in immagine delle variazioni giornaliere
	 */
	public static String pathDayJPG = "/home/arazzo/Arazzo/resources/imgPDF/variazioniorario.jpg";
	
	/**
	 * posizione dello stack
	 */
	public static int StackPosition=0;
	/**
	 * stack in cui viene salvata la cornologia dell'utente
	 */
	public static Vector<JPanel> Stack = new Vector<JPanel>(1,1);
	
	/**
	 * flag per controllare se è stato selezionata l'opzione info
	 */
	public static boolean Ospite = false;   // flag per capire se e' stato selezionato ospite o interno
	/**
	 * flag per controllare se è stato selezionata l'opzione info
	 */
	public static boolean Interno = false;
	/**
	 * Label utilizzata come background del frame touch 
	 */
	public static JLabel background;
	
	
	/**
	 * Costruttore che istanzia le variabili globali
	 */
	public GlobalVar()
	{
		
		//istanzio tutte le immagini
		try{
			
			img_btn_interni =ImageIO.read(getClass().getResource(path_btn_interni));
			img_btn_ospiti =ImageIO.read(getClass().getResource(path_btn_ospiti));
			img_btn_ospiti_pressed = ImageIO.read(getClass().getResource(path_btn_ospiti_pressed));
			img_btn_interni_pressed = ImageIO.read(getClass().getResource(path_btn_interni_pressed));
			img_background_scelta =  ImageIO.read(getClass().getResource(path_background_scelta));
			img_background_buzzi =  ImageIO.read(getClass().getResource(path_background_buzzi));
			img_background_servizi =  ImageIO.read(getClass().getResource(path_background_servizi));
			img_home = ImageIO.read(getClass().getResource(path_home));
			img_home_pressed = ImageIO.read(getClass().getResource(path_home_pressed));
			img_ricevimento_panel = ImageIO.read(getClass().getResource(path_ricevimento_panel));
			img_ricercaprof_panel = ImageIO.read(getClass().getResource(path_ricercaporf_panel));
			img_drop_arrow_down = ImageIO.read(getClass().getResource(path_drop_arrow_down));
			img_drop_arrow_up = ImageIO.read(getClass().getResource(path_drop_arrow_up));
			img_left_arrow = ImageIO.read(getClass().getResource(path_left_arrow));
			img_left_arrow_pressed = ImageIO.read(getClass().getResource(path_left_arrow_pressed));
			img_comunicazioni_background = ImageIO.read(getClass().getResource(path_comunicazioni_background));
			img_com_left_arrow = ImageIO.read(getClass().getResource(path_com_left_arrow));
			img_com_right_arrow = ImageIO.read(getClass().getResource(path_com_right_arrow));
			img_variazioni_background = ImageIO.read(getClass().getResource(path_variazioni_background));
			img_dualscreen_ricercaprof_bg = ImageIO.read(getClass().getResource(path_dualscreen_ricercaprof_bg));
			
			img_btn_mod_ricercaprof = ImageIO.read(getClass().getResource(path_btn_mod_ricercaprof));
			img_btn_mod_planimetria = ImageIO.read(getClass().getResource(path_btn_mod_planimetria));
			img_btn_mod_ricevimento = ImageIO.read(getClass().getResource(path_btn_mod_ricevimento));
			img_btn_mod_comunicazioni = ImageIO.read(getClass().getResource(path_btn_mod_comunicazioni));
			img_btn_mod_variazioni = ImageIO.read(getClass().getResource(path_btn_mod_variazioni));
			img_btn_mod_ricercaprof_pressed = ImageIO.read(getClass().getResource(path_btn_mod_ricercaprof_pressed));
			img_btn_mod_planimetria_pressed = ImageIO.read(getClass().getResource(path_btn_mod_planimetria_pressed));
			img_btn_mod_ricevimento_pressed = ImageIO.read(getClass().getResource(path_btn_mod_ricevimento_pressed));
			img_btn_mod_comunicazioni_pressed = ImageIO.read(getClass().getResource(path_btn_mod_comunicazioni_pressed));
			img_btn_mod_variazioni_pressed = ImageIO.read(getClass().getResource(path_btn_mod_variazioni_pressed));
			
			Stack.add(0,new OspitiInterniPanel());
			
		
		}catch(Exception e){
			
			e.printStackTrace();
		}
	
	}
	
	/**
	 * Metodo che controlla se lo stack contiene un determinato JPanel
	 * @param tmp  JPanel da comparare
	 * @return 1 se esiste -1 se non esiste nello stack
	 */
	public static int StackContains(JPanel tmp)
	{
		for(int i=0 ;i<Stack.size();i++){
			
			if(Stack.get(i) == tmp )
				return i;
			
		}
		return -1;
	}
	
	/**
	 * Metodo che viene utilizzato per cambiare il JPanel all'interno del frame
	 * @param tmp  nuovo JPanel che verà istanziato al posto del precedente 
	 */
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
