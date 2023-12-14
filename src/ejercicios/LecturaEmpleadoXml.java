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

			NodeList nl = doc.getElementsByTagName("empleado"); // Recuperamos todos los elementos xml con nombre empleado

			for (int i = 0; i < nl.getLength(); i++) { // Recorremos todos los nodos recuperados con nomrbe empleado

				Node node = nl.item(i); // Creamos una variable para el elemento que estamos recorriendo en este momento

				if (node.getNodeType() == Node.ELEMENT_NODE) { // Comprobamos que el elemento en cuestión es un elemento y no un comentario

					Element element = (Element) node; // Como hemos comprobado que se trata de un elemento, creamos una variable del tipo elemento

					String id = element.getAttribute("id"); // Recuperamos el valor del atributo id del elemento recuperado

					String nombre = element.getElementsByTagName("nombre").item(0).getTextContent(); // Recuperamos el valor del elemento nombre 
					String apellidos = element.getElementsByTagName("apellidos").item(0).getTextContent(); // Recuperamos el valor del eleme
					String edad = element.getElementsByTagName("edad").item(0).getTextContent(); // Recuperamos el valor del elemento edad
					String sueldo = element.getElementsByTagName("sueldo").item(0).getTextContent(); // Recuperamos el valor del elemetno sueldo

					// A continuación mostramos toda la información recuperada del elemento empleado
					System.out.println("Id de empleado: " + id); 
					System.out.println("Nombre completo: " + nombre + " " + apellidos);
					System.out.println("Edad: " + edad);
					System.out.println("Sueldo: " + sueldo);
					System.out.println();
				}
			}
			
		

		} catch (Exception e) {
			e.printStackTrace(); // Si ocurre un error, lo mostramos por pantalla
		}

	}

}
