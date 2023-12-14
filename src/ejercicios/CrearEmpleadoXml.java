package ejercicios;

// Importamos todas las librerías necesarias
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.File;

public class CrearEmpleadoXml {

	public static void main(String[] args) {
		
		File f = new File("./src/archivosEjemplo/Empleados.xml"); // Creamos la variable del archivo en el que guardaremos el empleado
		
		// Creamos todas las variables necesarias para el empleado de manera pseudo aleatoria
		String[] nombres = {"Juan", "Elena", "Pedro", "Lucia", "Myriam", "Eli", "Andres", "Antonio", "Jose Luis"};
		String[] apellidos = {"Sanchez", "Lopez", "Rodriguez", "Perez", "Gonzalez", "Martinez", "Fernandez", "Gomez", "Hernandez"};
		String nombre = nombres[(int) (Math.random()*nombres.length)];
		String apellido = apellidos[(int) (Math.random()*apellidos.length)] + " " + apellidos[(int) (Math.random()*apellidos.length)];
		int sueldoN = (int) ((Math.random()*20+10)*100);
		String sueldo = Integer.toString(sueldoN);
		String edad = Integer.toString((int)(Math.random()*50+20));
		
		System.out.println(nombre + apellido + sueldo + edad); // Mostramos por pantalla los valores del empleado que se ha creado y vamos a guardar

	        try {
	        	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); // Creamos una variable para poder utilizar la factory api que permite recuperar documentos DOM
	        	
	 	        DocumentBuilder db = dbf.newDocumentBuilder(); // Creamos la varibale utilizará especificamente la api para recuperar documentos DOM de un xml

	 	        Document doc = db.parse(f); // Recuperamos todo el archivo xml y lo guardamos en una variable
	 	        
	 	        Element rootElement = (Element) doc.getFirstChild(); // Recuperamos el elemento raíz del documento y lo guardamos en una variable
	 	        	 	        
	 	        Element empleado = doc.createElement("empleado"); // Creamos el nuevo elemento empleado que guardaremos en el documento
	 	        
	 	        // A continuación vamos a crear una variable para el id que tendrá el empleado
	 	        // Como tiene que ser sucesivo y único, recuperamos el último elemento del nodo raíz, buscamos dentro de sus atributos y recuperamos el valor del atributo id
	 	        // Por último, añadimos 1 y lo convertimos a cadena de texto, que es el modo en el que lo guardaremos en el elemento xml
	 	        String id = Integer.toString(Integer.valueOf(rootElement.getLastChild().getAttributes().item(0).getNodeValue().toString()) + 1);
	 	        
	 	        empleado.setAttribute("id", id); // Añadimos el atributo id para el elemento empleado que hemos creado
	 	        
	 	        // Creamos el elemento nombre, le asignamos un valor y por último lo añadimos al elemento empleado
	 	        Element nombreNodo = doc.createElement("nombre");
	 	        nombreNodo.appendChild(doc.createTextNode(nombre));
	 	        empleado.appendChild(nombreNodo);
	 	        
	 	        // Creamos el elemento apellido, le asignamos un valor y por último lo añadimos al elemento empleado
	 	        Element apellidosNodo = doc.createElement("apellidos");
	 	        apellidosNodo.appendChild(doc.createTextNode(apellido));
	 	        empleado.appendChild(apellidosNodo);
	 	        
	 	        // Creamos el elemento edad, le asignamos un valor y por último lo añadimos al elemento empleado
	 	        Element edadNodo = doc.createElement("edad");
	 	        edadNodo.appendChild(doc.createTextNode(edad));
	 	        empleado.appendChild(edadNodo);
	 	        
	 	        // Creamos el elemento sueldo, le asignamos un valor y por último lo añadimos al elemento empleado
	 	        Element sueldoNodo = doc.createElement("sueldo");
	 	        sueldoNodo.appendChild(doc.createTextNode(sueldo));
	 	        empleado.appendChild(sueldoNodo);
	 	       	
	 	       	rootElement.appendChild(empleado); // Añadimos el elemento emopleado al elemento raíz del documento
	 	       	
	        	FileOutputStream output = new FileOutputStream(f); // Creamos el flujo de datos que utilizaremos para escribir en el documento
	        	
	            writeXml(doc, output); // Escribimos toda la información en el documento
	            
	            output.close();
	        } catch (Exception e) {
	            e.printStackTrace(); // Si sucede un error, lo mostramos por pantalla
	        }

	    }

	    // Esta función admite dos argumentos, el primmero del tipo Document contendrá todos los elementos que hayamos creado o recuperado.
		// El segundo es un flujo de datos de salida que será lo que se utilizará para escribir en el archivo y guardar los datos
		// Hay que saber que durante todo este proceso, se vuelve a escribir el archivo entero, no solo los datos nuevos
	    private static void writeXml(Document doc, OutputStream output) throws TransformerException {

	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult(output);

	        transformer.transform(source, result);

	    
	}

}
