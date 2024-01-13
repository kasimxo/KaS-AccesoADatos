package ejercicios;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.util.*;
import java.io.*;



public class SaxMaipulacion {

	public static void main(String[] args) {
		
		 SAXParserFactory factory = SAXParserFactory.newInstance();
		
		try {
			File f = new File("./src/archivosEjemplo/pedidos.xml"); // Creamos la variable del archivo xml que vamos a leer
			
			SAXParser saxParser = factory.newSAXParser();

            SAXHandler handler = new SAXHandler();

            saxParser.parse(f, handler);
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
