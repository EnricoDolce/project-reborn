package comunicazioni;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
/**
 * Permette di leggere un file .txt 
 * @author Andrea Venturella
 *
 */
public class TXTReader {
	private FileReader fr;
	private BufferedReader bf;
	/**
	 * Costruttore della classe
	 * @param nomeFile nome del File da leggere
	 */
	public TXTReader(String nomeFile) {
		try
		{
			fr=new FileReader(nomeFile);
			bf=new BufferedReader(fr);
		}
		catch(IOException e)
		{
			System.out.println("FATAL ERROR: lettura file!");
		}
	}
	/**
	 * Effettua la lettura
	 * @return Vector<String> contenente le varie stringhe lette
	 */
	public Vector<String> txtRead()
	{
		boolean fin=false;
		Vector<String> temp=new Vector<String>();
		String t;
		try {
			t = bf.readLine();
			while(t!=null)
			{		
					temp.add(t);
					t=bf.readLine();
			}
			bf.close();
			fr.close();
		} catch (IOException e) {
			System.out.println("Errore lettura!");
		}
		return temp;
	}
	
	
}
