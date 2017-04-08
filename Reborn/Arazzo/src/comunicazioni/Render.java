package comunicazioni;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;


public class Render {
	private final String pathJpg;
	
	public Render(String pathJpg) {
		this.pathJpg = pathJpg;
	}
	
	
	public void toJpg(String pathPdf){
		System.out.println(pathPdf);
		String nomeFile=pathPdf.split("/")[6];
		System.out.println(nomeFile);
		nomeFile=nomeFile.substring(0, nomeFile.length()-4);
		try
	       {
			//InputStream t=getClass().getResource("/pdf/018 - somme a disposizione reparti 2016.17.pdf").openStream();
			File f = new File(pathPdf);
			System.out.println(f.toURI());
			PDDocument document = PDDocument.load(f);
			PDFRenderer pdfRenderer = new PDFRenderer(document);
			try
			{
				for(int i=0;true;i++) //necessario per creare le immagini di pdf a più pagine
				{
				    BufferedImage bim = pdfRenderer.renderImageWithDPI(i, 300, ImageType.RGB);
				    // suffix in filename will be used as the file format
				    ImageIOUtil.writeImage(bim, pathJpg+nomeFile+"_"+i+".jpg", 300);
				  //  System.out.println(i);
				}
			}
			catch(Exception e2)
			{
			    document.close();
			}
	       }
	       catch (Exception e) {
	               e.printStackTrace();
	       }
	}
	
}