package erp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.sql.SQLException;

public class UDP extends Thread {
	
	public static int day = 1;
	
    public static void main(String[] args) throws SQLException {
    	
    	final int PORT = 54321;
    	byte[] buf = new byte[65535];
    	
    	UDP thread = new UDP();
        thread.start();
	    	
    	try (DatagramSocket dsock = new DatagramSocket(PORT)) {
			DatagramPacket data = new DatagramPacket(buf, buf.length);
			
			while (dsock.isClosed() == false) {
			    dsock.receive(data);
			    String dataS = new String(data.getData(), 0, data.getLength(), "UTF-8");
			    InputStream inputStream = new ByteArrayInputStream(dataS.getBytes());
			    
			    XML_Request xml_Request = new XML_Request();
				xml_Request.run(inputStream);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	    	
    }
    
    public void run() { //DAY COUNTER
    	double t0 = System.currentTimeMillis(), t1; 
    	System.out.println("-------------- DAY "+day+" --------------");
    	Database db = new Database();
    	db.ConnectDB();
    	try {
			db.updateDate(day);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			db.getPlan();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	try {
			db.startWarehouse();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
    	while(true) { 
    		if((t1 = System.currentTimeMillis()) - t0 >= 1000 * 60) { 
    			day++;
    			System.out.println("----------------- DAY "+day+" ----------------"); 
    			t0 = t1; 
    			
    			try {
					db.updateDate(day);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
    			try {
    				db.getPlan();
    			} catch (SQLException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
    			
    			try {
					db.checkForDelivery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	    } 
    	}
    }
    
    
}
	