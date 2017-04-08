package comunicazioni;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {

		GestioneComunicazioni g=new GestioneComunicazioni();
		g.refresh();
		Vector<BufferedImage> t=g.imgComunicazione("034 - The English Project 2016-17");
		System.out.println(t.size());
		
		/*for(int i=0;i<t.size();i++)
		{
			System.out.println(t.get(i).getWidth());
		}*/
		/*Vector<String> t2=g.nomiComunicazioni();
		for(String s: t2)
		{
			System.out.println(s);
		}*/
		//g.refresh();
		/*try { // TODO Sistemare donwload la prima volta (scarica fino al file 36) DONE
			String[] command = {"/bin/bash", "/home/andrea/downloadComunicazioni.sh"};
			ProcessBuilder p=new ProcessBuilder(command);
			Process pr=p.start();
			//Process pr=Runtime.getRuntime().exec("/home/andrea/pdf/downloadComunicazioni.sh"); OLD
			pr.waitFor();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*String temp="/home/andrea/pdf/140 - ferie Pasqua-ATA.pdf".split("/")[4];
		temp=temp.substring(0, temp.length()-4);
		System.out.println(temp);*/
		//Render r=new Render("/home/andrea/pdf/140 - ferie Pasqua-ATA.pdf","/home/andrea/imgPDF/","140");
	}

}
