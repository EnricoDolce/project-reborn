package comunicazioni;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

/**
 * Permette la creazione di un file .jpg partendo da un .pdf
 * @author Andrea Venturella
 */
public class Render {
	/**
	 * Path del .jpg finale
	 */
	private final String pathJpg;
	
	public Render(String pathJpg) {
		this.pathJpg = pathJpg;
	}
	
	/**
	 * Crea l'immagine dato il .pdf
	 * @param pathPdf Percorso del file .pdf da convertire
	 */
	public void toJpg(String pathPdf){
		System.out.println(pathPdf);
		String nomeFile=pathPdf.split("/")[6];
		nomeFile=nomeFile.substring(0, nomeFile.length()-4); //ricava il nome del file
		try
	       {
			PDDocument document = PDDocument.load(new File(pathPdf));
			PDFRenderer pdfRenderer = new PDFRenderer(document);
			try
			{
				for(int i=0;true;i++) //necessario per creare le immagini di pdf a più pagine
				{
				    BufferedImage bim = pdfRenderer.renderImageWithDPI(i, 300, ImageType.RGB);
				    ImageIOUtil.writeImage(bim, pathJpg+nomeFile+"_"+i+".jpg", 300);
				    System.out.println(pathJpg+nomeFile+"_"+i+".jpg");
				    /*
				     * La sintassi dei file immagini creati è la seguente:
				     * 
				     * nomeComunicazione_numeroProgessivo.jpg
				     * 
				     * Il numero progressivo serve ad identificare le varie pagine 
				     */
				}
			}
			catch(Exception e2)
			{
				//Quando viene lanciata, il pdf viene chiuso
			    document.close();
			}
	       }
	       catch (Exception e) {
	               e.printStackTrace();
	       }
	}
	
}