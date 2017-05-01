package comunicazioni;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

import Global.GlobalVar;
/**
 * Classe per la gestione delle comunicazioni, si occupa del download e della creazione delle immagini
 * con controlli ogni volta che viene avviato il modulo "Visualizza Comunicazioni"
 * @author Andrea Venturella
 *
 */
public class GestioneComunicazioni {
	
	private Render render;
	private TXTReader readerNew;
	
	public GestioneComunicazioni() {
		super();
		this.render=new Render(GlobalVar.pathComJPG);
	}
	/**
	 * Avvia lo script che permette il download delle comunicazioni
	 */
	public void download()
	{
		try { 
			String[] command = {GlobalVar.pathComSh,GlobalVar.pathComDownload,GlobalVar.pathCom,GlobalVar.pathComNew,GlobalVar.pathComPDF,GlobalVar.pathComJPG};
			ProcessBuilder p=new ProcessBuilder(command);  //viene avviato lo script passando i vari paramentri (i percorsi)
			Process pr=p.start();
			//Process pr=Runtime.getRuntime().exec("/home/andrea/pdf/downloadComunicazioni.sh"); OLD
			pr.waitFor();  //si attende il terminamento dell'esecuzione
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Crea i file .jpg corrispondenti ai vari .pdf leggendo quali sono ancora da renderizzare
	 */
	private void img() 
	{
		this.readerNew=new TXTReader(GlobalVar.pathComNew);
		Vector<String> toImg=readerNew.txtRead();
		for(String t: toImg)
		{
			render.toJpg(GlobalVar.pathComPDF+"/"+t);
		}
	}
	/**
	 * Effettua un controllo dei .pdf e dei .jpg per aggiornarli se necessario
	 */
	public void refresh()
	{
		download();
		img();
	}
	/**
	 * Crea un Vector di String e lo ritorna, per permettere la visualizzazione delle varie comunicazioni
	 * @return Vector<String> contenente i nomi delle varie comunicazioni 
	 */
	public Vector<String> nomiComunicazioni()
	{
		TXTReader readerComunicazioni=new TXTReader(GlobalVar.pathCom);
		Vector<String> temp=readerComunicazioni.txtRead();
		Vector<String> nomi=new Vector<String>();
		for(int i=0;i<temp.size();i++)
		{
			String t=temp.get(i).split("/")[4];
			t = t.substring(0,t.length() - 4);
			nomi.add(t);
		}
		return nomi;
	}
	/**
	 * Ritorna l'immagine corrispondente alla comunicazione cercata
	 * @param nome Nome della comunicazione
	 * @return Vector<BufferedImage> contenente i .jpg della comunicazione
	 */
	public Vector<BufferedImage> imgComunicazione(String nome)
	{
		Vector<BufferedImage> img=new Vector<BufferedImage>();

		for(int i=0;true;i++)
		{
			try {
			    BufferedImage tImg = ImageIO.read(new File(GlobalVar.pathComJPG+nome+"_"+i+".jpg"));
			    img.add(tImg);
			} catch (IOException e) {
				break;  //non esistono più immagini della comunicazione da caricare (le pagine sono finite)
			}
		}
		return img;
	}
	
}
