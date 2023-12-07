package ejercicios;

// Importamos la librerías necesarias
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class LecturaEmpleadoXml {

	public static void main(String[] args) {

		File f = new File("./src/archivosEjemplo/Empleados.xml"); // Creamos la variable del archivo xml que vamos a leer
		

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); // Creamos la variable de la api para manejar el documento

		try {

			DocumentBuilder db = dbf.newDocumentBuilder(); // Creamos la variable que construye el documento xml

			Document doc = db.parse(f); // Creamos la varibale que va a parsear el documento y le pasamos comoargumento el archivo xml especificado
			
			System.out.println("Listado de empleados:\n"); // Mostaramos un mensaje de cabecera

			NodeList list = doc.getElementsByTagName("empleado");

			for (int temp = 0; temp < list.getLength(); temp++) {

				Node node = list.item(temp);

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element element = (Element) node;

					String id = element.getAttribute("id");

					String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
					String apellidos = element.getElementsByTagName("apellidos").item(0).getTextContent();
					String edad = element.getElementsByTagName("edad").item(0).getTextContent();
					String sueldo = element.getElementsByTagName("sueldo").item(0).getTextContent();

					System.out.println("Id de empleado: " + id);
					System.out.println("Nombre completo: " + nombre + " " + apellidos);
					System.out.println("Edad: " + edad);
					System.out.println("Sueldo: " + sueldo);
					System.out.println();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
