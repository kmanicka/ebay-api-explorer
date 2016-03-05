package common;

import java.io.OutputStreamWriter;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import core.IeBayCallContext;
import play.libs.XML;

public class Util implements IConstants {
	
	public static String getEnvVariable(String name) {
		String value = System.getenv(name);
		System.out.println("Env Variable : " + name + " = " + value);
		return value;
	}

	public static String prettyXml(String unformatedXml) {
		Document document = XML.getDocument(unformatedXml);
		return prettyXml(document);
	}

	public static String prettyXml(Document document) {
		String prettyXml = null;

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			StringWriter stringWriter = new StringWriter();
			transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(new DOMSource(document), new StreamResult(stringWriter));
			prettyXml = stringWriter.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prettyXml;
	}

}
