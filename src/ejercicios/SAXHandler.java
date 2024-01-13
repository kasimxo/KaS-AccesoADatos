package ejercicios;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.util.*;
import java.io.*;

public class SAXHandler extends DefaultHandler {
	
	private int tabs = 0;

	 private StringBuilder currentValue = new StringBuilder();

	  @Override
	  public void startDocument() {
	      //System.out.print("Start Document:");
	  }

	  @Override
	  public void endDocument() {
	      //System.out.println("End Document");
	  }

	  @Override
	  public void startElement(
	          String uri,
	          String localName,
	          String qName,
	          Attributes attributes) {

		  System.out.println();
		  
		  
		  
	      // reset the tag value
	      currentValue.setLength(0);
	      for (int i = 0; i< tabs; i++) {
			  System.out.print("\t");
		  }
	      System.out.printf(" %s %s", qName, localName);
	      
	      if(attributes.getLength() > 0) {
	    	  for (int i = 0; i<attributes.getLength(); i++) {
	    		  System.out.printf("%s: %s; ",attributes.getQName(i),attributes.getValue(i));
	    	  }
	      }
	      
	      tabs++;
	  }

	  @Override
	  public void endElement(String uri,
	                         String localName,
	                         String qName) {
		  if(currentValue.length()>1) {
		   
			  //System.err.println(currentValue.length());
			  System.out.print(currentValue);
			  
			  
		  }
		  
		  System.out.printf(" %s", qName);
		  tabs--;
	      
	  }
	  
	  @Override
	  public void characters(char ch[], int start, int length) {
		  currentValue.append(ch, start, length);

	  }
	
	
}
