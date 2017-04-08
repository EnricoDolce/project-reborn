package variazoniOrari;

import java.awt.image.BufferedImage;
import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;


public class Variazioni {
	private String pathPdf;
	private String pathJpg;
	
	public Variazioni(String pathPdf, String pathJpg) {
		this.pathPdf = pathPdf;
		this.pathJpg = pathJpg;
	}
	
	
	public void toJpg(){
		try
	       {
			PDDocument document = PDDocument.load(new File(this.pathPdf));
			PDFRenderer pdfRenderer = new PDFRenderer(document);
 
		    BufferedImage bim = pdfRenderer.renderImageWithDPI(0, 300, ImageType.RGB);

		    ImageIOUtil.writeImage(bim, this.pathJpg, 300);
			document.close();

	       }
	       catch (Exception e) {
	               e.printStackTrace();
	       }
	}


	public String getPathPdf() {
		return pathPdf;
	}


	public void setPathPdf(String pathPdf) {
		this.pathPdf = pathPdf;
	}


	public String getPathJpg() {
		return pathJpg;
	}


	public void setPathJpg(String pathJpg) {
		this.pathJpg = pathJpg;
	}
	
}
