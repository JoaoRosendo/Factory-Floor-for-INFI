package erp;

import java.sql.SQLException;

public class MPS /*extends Thread*/ {
	
	//public static int day = 1;
	public int warehouse_p1 = 24;
	public int warehouse_p2 = 24;
	
	/*MPS day_counter = new MPS();
    day_counter.start();*/
	
	public int time_needed(int piece) {
		int time = 0;
		
		if (piece==3) { 		// P3 > P1
			time = 10;
		} else if (piece==4) { 	// P4 > P2
			time = 10;
		} else if (piece==5) { 	// P5 > P2
			time = 15;
		} else if (piece==6) { 	// P6 > P1
			time = 20;
		} else if (piece==7) { 	// P7 > P4 > P2 + TOOL CHANGE
			time = 10+10+30;
		} else if (piece==8) { 	// P8 > P6 > P1 + TOOL CHANGE
			time = 30+20+30;
		} else if (piece==9) { 	// P9 > P7 > P4 > P2 + TOOL CHANGE
			time = 10+10+10+30+30;
		}
			
		return time;
	}
	
	public double days_needed_to_finish_order(int id) throws SQLException {
		double days = 0;
		
		Database db = new Database();
	    db.ConnectDB();
	 
	    order order = new order();
	    order = db.getOrder(id);
	    int piece = order.getWorkpiece();
	    int qty = order.getQty();
	    
	    days = (time_needed(piece)*qty)/60;
	    days = Math.ceil(days); // rounds up
	    return days;
	}
	
	public int set_start_date(int id) throws SQLException {
		int start = 0;
		
		Database db = new Database();
	    db.ConnectDB();
	 
	    order order = new order();
	    order = db.getOrder(id);
	    int due = order.getDueDate();
	    double days_needed = days_needed_to_finish_order(id);
	    start = (int) (due-days_needed);
	    
	    return start;
	}
	
	public int order_p1_from_supplier(int id) throws SQLException {
		Database db = new Database();
	    db.ConnectDB();
	    
	    int qty_P1 = db.numberOfP1(id);
	    
	    supplier s_P1 = new supplier();
	    s_P1.SupplierC_P1();
	    
	    if(qty_P1-warehouse_p1 > s_P1.getMinQty()) {
	    	s_P1.setQty(qty_P1-warehouse_p1);
	    } else if (qty_P1 == 0) {
	    	s_P1.setQty(0);
	    } else {
	    	s_P1.setQty(s_P1.getMinQty());
	    }
	    
	    //calculate cost
	    return s_P1.getQty();
	}
	 
	public int order_p2_from_supplier(int id) throws SQLException {
		Database db = new Database();
	    db.ConnectDB();
	    
	    int qty_P2 = db.numberOfP2(id);
	    
	    supplier s_P2 = new supplier();
	    s_P2.SupplierC_P2();
	    
	    if(qty_P2-warehouse_p2 > s_P2.getMinQty()) {
	    	s_P2.setQty(qty_P2-warehouse_p2);
	    } else if (qty_P2 == 0) {
	    	s_P2.setQty(0);
	    } else {
	    	s_P2.setQty(s_P2.getMinQty());
	    }
	    
	    //calculate cost
	    
	    return s_P2.getQty();
	}
	
	public void place_order_to_supplier(int n) {
		
	}
	
	public float cost (int id) {
		float cost = 0;
		return cost;
	}
	
	
	
	
	
	
	// DAY COUNTER
	/*public void run() { 
    	double t0 = System.currentTimeMillis(), t1; 
    	
    	while(true) { 
    		if((t1 = System.currentTimeMillis()) - t0 >= 1000 * 60) { 
    			day++; 
    	        t0 = t1; 
    	    } 
    	}
    }*/
	
}
