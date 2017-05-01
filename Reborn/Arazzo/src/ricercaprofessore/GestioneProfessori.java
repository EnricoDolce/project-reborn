package ricercaprofessore;

import java.io.IOException;
import java.util.Vector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * classe per la gestione dei professori.
 * @author Iacopo Melani
 *
 */
public class GestioneProfessori {
	
	/**
	 * vettore contenente tutti i professori del file excel.
	 */
	private static Vector<Professore> professori;

	/**
	 * costruttore della classe.
	 */
	public GestioneProfessori() {
		super();
		
	}
	
	/**
	 * metodo get per ricevere il vettore dei professori.
	 * @return Vector<Professore>
	 */
	public Vector<Professore> getProfessori() {
		return professori;
	}

	/**
	 * metodo set per inserire il vettore dei professori.
	 * @param p
	 */
	public void setProfessori(Professore p) {
		this.professori.addElement(p);
	}
	
	/**
	 * metodo per caricare il vettore dei professori. Esso richiama la classe ricercaProfessore e ricava il vettore con i professori all'interno.
	 * @throws IOException
	 */
	public void caricaProfessori()
	{
		ricercaProfessore ricerca = new ricercaProfessore();
		try
		{
			this.professori = ricerca.ricerca();
		}catch (IOException e) {}
	}
	
	/**
	 * metodo che stampa tutti i professori all'interno del vettore.
	 */
	public void stampaTutti()		//stampa tutti i professori con tutti gli orari
	{
		for(int i = 0;i<professori.size();i++)
		{
			System.out.println(professori.elementAt(i).getNome()+"\n");
			
			for(Entry entry : professori.elementAt(i).getMappa().entrySet())
			{
			    String key = (String) entry.getKey();
			    Vector<String> orari = (Vector<String>) entry.getValue();
			   
			    System.out.println(key + ":");
			    
			    for(int k=0;k<orari.size();k++)
			    {
			    		System.out.println((k+1) + "°" + "->" + orari.elementAt(k));
			    }

			    
			}
			
		}System.out.println("\n");
	}
	
	/**
	 * metodo che stampa un professore dato un nome in input.
	 * @param nome
	 */
	public void stampaProfessore(String nome)		//stampa orario di un professore
	{
		String cercato = nome;
		cercato = cercato.toUpperCase();
		for(int i = 0;i<professori.size();i++)
		{
			if(professori.elementAt(i).getNome().equals(cercato))
			{
				System.out.println(professori.elementAt(i).getNome()+"\n");
				
				for(Entry entry : professori.elementAt(i).getMappa().entrySet())
				{
				    String key = (String) entry.getKey();
				    Vector<String> orari = (Vector<String>) entry.getValue();
				   
				    System.out.println(key + ":");
				    
				    for(int k=0;k<orari.size();k++)
				    {
				    		System.out.println((k+1) + "°" + "->" + orari.elementAt(k));
				    }
	
				    
				}
			}
			
		}
	}
	
	/**
	 * metodo che stampa professore in un giorno specifico ad un'ora scelta.
	 * @param nome
	 * @param ora
	 * @param giorno
	 */
	public String cercaProfessoreInOra(String nome,int ora, String giorno) {	//stampa orario professore in un giorno a una determinata
		String cercato = nome.toUpperCase();
		for(int i = 0;i<professori.size();i++)
		{
			if(professori.elementAt(i).getNome().equals(cercato))
			{
				System.out.println(professori.elementAt(i).getNome()+"\n");
				
				for(Entry entry : professori.elementAt(i).getMappa().entrySet())
				{
				    String key = (String) entry.getKey();
				    Vector<String> orari = (Vector<String>) entry.getValue();
				    
				   if(key.equals(giorno))
				   {
					    System.out.println(key+":");
					    try{
					    System.out.println((ora) + "°" + "->" + orari.elementAt(ora-1));  // se da errore di index out of bound vuol dire che non lavora in quelle ore
					    }
					    catch (ArrayIndexOutOfBoundsException e) {
							return " ";
						}
					    return orari.elementAt(ora-1);
				   }
				    
				}
			}
			
		}
		return "";
	}
	
	public static HashMap<Integer,String> cercaProfessoreInGiorno(String nome, String giorno){
		String cercatoProfessore = nome.toUpperCase();
		HashMap<Integer,String> mappaGiorno = new HashMap<Integer,String>();  //combinazione ora(Integer):classe(String)
		for(int i=0;i<professori.size();i++)
		{
			if(professori.elementAt(i).getNome().equals(cercatoProfessore))
			{
				for(Entry entry : professori.elementAt(i).getMappa().entrySet())
				{
				    Vector<String> orari = (Vector<String>) entry.getValue(); //classi
				    if(entry.getKey().equals(giorno))
				    {
					    for(int k=0;k<orari.size();k++)
					    {
					    		if(!orari.elementAt(k).equals(""))
					    		{
					    			mappaGiorno.put(k+1, orari.elementAt(k));
					    		}
					    }
				    }
				}
			}
		}

		return mappaGiorno;
	}
	
	public static void main(String args[])
	{
		GestioneProfessori g = new GestioneProfessori();
		
		g.caricaProfessori();		//inizializza tutti i professori
		
		

		int numeroProfessori = g.professori.size();
		HashMap temp = new HashMap();
		 temp = cercaProfessoreInGiorno("buonopane","venerdi");
		 
		 Set<Entry> entries = temp.entrySet();
		for (Entry<Integer,String> entry : entries) {
			  int key = entry.getKey();
			  String value = entry.getValue();
			  System.out.println(key+" "+value);
			}
		
	}
	
	
}
