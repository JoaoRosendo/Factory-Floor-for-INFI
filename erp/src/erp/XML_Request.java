package erp;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class XML_Request {

	//public static InputStream inputStream;
	
	//private static final String FILENAME = "command1.xml";
	//private static String FILENAME = this.received;

	public void run(InputStream inputStream) throws SQLException {
	  
	  String clientNameId = null;
	  
	  Database db = new Database();
	  db.ConnectDB();

      // Instantiate the Factory
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      
      try {
          // parse XML file
          DocumentBuilder docbuilder = dbf.newDocumentBuilder();
          //Document doc = docbuilder.parse(new File(FILENAME));
          Document doc = docbuilder.parse(inputStream);

          // optional, but recommended
          // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
          doc.getDocumentElement().normalize();

          //System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
          System.out.println();
       
          NodeList client = doc.getElementsByTagName("Client");          
          for (int temp = 0; temp < client.getLength(); temp++) {
        	  
        	  Node node = client.item(temp);
              
              if (node.getNodeType() == Node.ELEMENT_NODE) {
                 
            	  Element el = (Element) node;
                  
                  String NameId = (el.getAttributeNode("NameId")).toString();                
                  clientNameId = NameId.substring(15, NameId.length()-1);
              }
          }
          
          NodeList order = doc.getElementsByTagName("Order");
          for (int temp = 0; temp < order.getLength(); temp++) {
        	  
              Node node = order.item(temp);
              
              if (node.getNodeType() == Node.ELEMENT_NODE) {
              
            	  Element el = (Element) node;
                  
            	  System.out.println("---- INCOMING ORDER ----");
                  String Number = (el.getAttributeNode("Number")).toString();
                  String WorkPiece = (el.getAttributeNode("WorkPiece")).toString();
                  String Quantity = (el.getAttributeNode("Quantity")).toString();
                  String DueDate = (el.getAttributeNode("DueDate")).toString();
                  String LatePen = (el.getAttributeNode("LatePen")).toString();
                  String EarlyPen = (el.getAttributeNode("EarlyPen")).toString();
                  
                  order newOrder = new order();
                  newOrder.setClient(clientNameId);
                  
                  int n = Integer.valueOf(Number.substring(8, Number.length()-1));
                  newOrder.setNumber(n);
                  int workpiece = Integer.valueOf(WorkPiece.substring(12, WorkPiece.length()-1));
                  newOrder.setWorkpiece(workpiece);
                  int qty = Integer.valueOf(Quantity.substring(10, Quantity.length()-1));
                  newOrder.setQty(qty);
                  int due = Integer.valueOf(DueDate.substring(9, DueDate.length()-1));
                  newOrder.setDueDate(due);
                  int late = Integer.valueOf(LatePen.substring(9, LatePen.length()-1));
                  newOrder.setLatePenalty(late);
                  int early = Integer.valueOf(EarlyPen.substring(10, EarlyPen.length()-1));
                  newOrder.setEarlyPenalty(early);
                  
                  System.out.println("Order Number : " + newOrder.getNumber());
                  System.out.println("Client : " + newOrder.getClient());
                  System.out.println("WorkPiece : P" + newOrder.getWorkpiece());
                  System.out.println("Quantity : " + newOrder.getQty());
                  System.out.println("DueDate : " + newOrder.getDueDate());
                  System.out.println("LatePen : " + newOrder.getLatePenalty());
                  System.out.println("EarlyPen : " + newOrder.getEarlyPenalty());
                  System.out.println();
                  
                  db.insertOrder(newOrder);
                  //db.getPlan();
                  
              }
          }

      } catch (ParserConfigurationException | SAXException | IOException e) {
          e.printStackTrace();
      }
	}
}
