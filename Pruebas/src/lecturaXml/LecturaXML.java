package lecturaXml;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class LecturaXML {

 public static void main(String argv[]) {
	 String texto;
  try {
	  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	  Document doc = dBuilder.parse(new File("src/lecturaXml/ejemplo.xml"));
	  doc.getDocumentElement().normalize();
	  Element root=doc.getDocumentElement();
	  System.out.println("El elemento raíz es: " + root.getNodeName());
	  NodeList listaPersonas = root.getChildNodes();//doc.getElementsByTagName("persona");
	  System.out.println("Numero de nodos: "+listaPersonas.getLength());
	  for (int i = 0; i < listaPersonas.getLength(); i ++) {

	    Node persona = listaPersonas.item(i);

	    if (persona.getNodeType() == Node.ELEMENT_NODE) {

            Element elemento = (Element) persona;
            System.out.println("Nacionalidad : "+ elemento.getAttribute("nacionalidad"));
            System.out.println("Nombre : " + getTagValue("nombre", elemento));
            System.out.println("Apellido : " + getTagValue("apellido", elemento));
            System.out.println("Edad : " + getTagValue("edad", elemento));

	    }
	    else{ 
	    	texto=persona.getTextContent().replaceAll("[\n\t\r]*", "");
	    	//if(texto.compareTo("")!=0)
	    		System.out.println(texto);
	    
	    }
    }
  } catch (Exception e) {
    e.printStackTrace();
  }

 }

 private static String getTagValue(String sTag, Element eElement) {
	  NodeList nlList= eElement.getElementsByTagName(sTag).item(0).getChildNodes();
	  return nlList.item(0).getNodeValue();
 }

}
