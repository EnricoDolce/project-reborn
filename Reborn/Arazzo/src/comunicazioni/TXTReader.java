package comunicazioni;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class TXTReader {
	private FileReader fr;
	private BufferedReader bf;
	
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
					//System.out.println("ADD");
					t=bf.readLine();
			}
			bf.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Errore lettura!");
		}
		return temp;
	}
	
	
}
