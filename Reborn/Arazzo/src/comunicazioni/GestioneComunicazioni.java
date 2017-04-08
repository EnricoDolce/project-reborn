package comunicazioni;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

public class GestioneComunicazioni {
	private final String pathSh="/home/arazzo/Arazzo/resources/downloadComunicazioni.sh";
	private final String pathJPG="/home/arazzo/Arazzo/resources/imgPDF/";
	private final String pathNew="/home/arazzo/Arazzo/resources/pdf/toImg.txt";
	private final String pathPDF="/home/arazzo/Arazzo/resources/pdf";
	private final String pathCom="/home/arazzo/Arazzo/resources/pdf/link.txt";
	
//	private final String pathSh="/home/enrico/GitHub/project-reborn/Reborn/Arazzo/resources/downloadComunicazioni.sh";
//	private final String pathJPG="/home/enrico/GitHub/project-reborn/Reborn/Arazzo/resources/imgPDF/";
//	private final String pathNew="/home/enrico/GitHub/project-reborn/Reborn/Arazzo/resources/pdf/toImg.txt";
//	private final String pathPDF="/home/enrico/GitHub/project-reborn/Reborn/Arazzo/resources/pdf";
//	private final String pathCom="/home/enrico/GitHub/project-reborn/Reborn/Arazzo/resources/pdf/link.txt";
	private Render render;
	private TXTReader readerNew;
	
	public GestioneComunicazioni() {
		super();
		this.render=new Render(pathJPG);
	}
	
	private void download()
	{
		try { // TODO Sistemare donwload la prima volta (scarica fino al file 36) DONE
			String[] command = {"/bin/bash", pathSh};
			ProcessBuilder p=new ProcessBuilder(command);
			Process pr=p.start();
			//Process pr=Runtime.getRuntime().exec("/home/andrea/pdf/downloadComunicazioni.sh"); OLD
			pr.waitFor();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void img() //TODO creazione .jpg per ogni PDF (ciclo) DONE
	{
		this.readerNew=new TXTReader(pathNew);
		Vector<String> toImg=readerNew.txtRead();
		for(String t: toImg)
		{
			render.toJpg(pathPDF+"/"+t);
		}
	}
	public void refresh()
	{
		download();
		img();
		
	}
	public Vector<String> nomiComunicazioni()
	{
		TXTReader readerComunicazioni=new TXTReader(pathCom);
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
	public Vector<BufferedImage> imgComunicazione(String nome)
	{
		Vector<BufferedImage> img=new Vector<BufferedImage>();

		for(int i=0;true;i++)
		{
			try {
			    BufferedImage tImg = ImageIO.read(new File(pathJPG+nome+"_"+i+".jpg"));
			    img.add(tImg);
			} catch (IOException e) {
				break;
			}
		}
		return img;
	}
	
}
