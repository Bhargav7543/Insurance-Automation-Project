package utility;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;


public class CommonFunctions {

	//Reading content for PDF File from Web URL
	public static void PdfReaderFromURL(String pdfURL, String text) throws Exception {
		URL url = new URL(pdfURL);

		InputStream is = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(is);
		PDDocument document = null;

		try {
			document = PDDocument.load(fileParse);
			String pdfContent = new PDFTextStripper().getText(document);
			System.out.println(pdfContent);

			Assert.assertTrue(pdfContent.contains(text));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Reading content for PDF from File
	public static void PdfReader(String pdfFilePath, String text) throws Exception {
		File file = new File(pdfFilePath);

		FileInputStream fis = new FileInputStream(file);

		PDDocument doc = null;

		try {
			doc = PDDocument.load(fis);
			String output = new PDFTextStripper().getText(doc);
			System.out.println(output);
			Assert.assertTrue(output.contains(text));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}