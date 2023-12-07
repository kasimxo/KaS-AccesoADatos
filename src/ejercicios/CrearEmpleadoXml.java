package ejercicios;

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
		
		File f = new File("./src/archivosEjemplo/Empleados.xml");
		
		String[] nombres = {"Juan", "Elena", "Pedro", "Lucia", "Myriam", "Eli", "Andres", "Antonio", "Jose Luis"};
		String[] apellidos = {"Sanchez", "Lopez", "Rodriguez", "Perez", "Gonzalez", "Martinez", "Fernandez", "Gomez", "Hernandez"};
		String nombre = nombres[(int) (Math.random()*nombres.length)];
		String apellido = apellidos[(int) (Math.random()*apellidos.length)] + " " + apellidos[(int) (Math.random()*apellidos.length)];
		int sueldoN = (int) ((Math.random()*20+10)*100);
		String sueldo = Integer.toString(sueldoN);
		String edad = Integer.toString((int)(Math.random()*50+20));
		
		System.out.println(nombre + apellido + sueldo + edad);

	        try {
	        	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	 	        DocumentBuilder db = dbf.newDocumentBuilder();

	 	        // root elements
	 	        Document doc = db.parse(f);
	 	        
	 	        Element rootElement = (Element) doc.getFirstChild();
	 	        
	 	        //doc.appendChild(rootElement);

	 	        //doc.createElement("empleado");
	 	        Element empleado = doc.createElement("empleado");
	 	        
	 	        String id = Integer.toString(Integer.valueOf(rootElement.getLastChild().getAttributes().item(0).getNodeValue().toString()) + 1);
	 	        
	 	        empleado.setAttribute("id", id);
	 	        
	 	        
	 	        Element nombreNodo = doc.createElement("nombre");
	 	        nombreNodo.appendChild(doc.createTextNode(nombre));
	 	        empleado.appendChild(nombreNodo);
	 	        
	 	        Element apellidosNodo = doc.createElement("apellidos");
	 	        apellidosNodo.appendChild(doc.createTextNode(apellido));
	 	        empleado.appendChild(apellidosNodo);
	 	        
	 	        Element edadNodo = doc.createElement("edad");
	 	        edadNodo.appendChild(doc.createTextNode(edad));
	 	        empleado.appendChild(edadNodo);
	 	      
	 	        Element sueldoNodo = doc.createElement("sueldo");
	 	        sueldoNodo.appendChild(doc.createTextNode(sueldo));
	 	        empleado.appendChild(sueldoNodo);
	 	       	
	 	       	rootElement.appendChild(empleado);
	 	       	
	        	FileOutputStream output = new FileOutputStream(f); 
	        	
	            writeXml(doc, output);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }

	    // write doc to output stream
	    private static void writeXml(Document doc, OutputStream output) throws TransformerException {

	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult(output);

	        transformer.transform(source, result);

	    
	}

}
