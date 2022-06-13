package erp;

import java.sql.SQLException;

public class MPS {
	
	//public int warehouse_p1 = 24;
	//public int warehouse_p2 = 24;
	
	public int time_needed(int final_piece) {
		int time = 0;
		
		if (final_piece==3) { 		// P3 > P1
			time = 10;
		} else if (final_piece==4) { 	// P4 > P2
			time = 10;
		} else if (final_piece==5) { 	// P5 > P2
			time = 15;
		} else if (final_piece==6) { 	// P6 > P1
			time = 20;
		} else if (final_piece==7) { 	// P7 > P4 > P2 + TOOL CHANGE
			time = 10+10+30;
		} else if (final_piece==8) { 	// P8 > P6 > P1 + TOOL CHANGE
			time = 30+20+30;
		} else if (final_piece==9) { 	// P9 > P7 > P4 > P2 + TOOL CHANGE
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
	    
	    if (start < db.getDate()) start = db.getDate();
	    
	    return start;
	}
	
	public supplier order_p1_from_supplier(int qty) throws SQLException {
		Database db = new Database();
	    db.ConnectDB();
	    
	    int warehouse_p1 = db.numberOfPiecesInWarehouse(1);
	    
	    supplier s_P1 = new supplier();
	    s_P1.SupplierC_P1();
	    
	    if(warehouse_p1 < qty) {
		    if((qty-warehouse_p1) > s_P1.getMinQty()) {
		    	s_P1.setQty((qty-warehouse_p1));
		    } else if (qty == 0) {
		    	s_P1.setQty(0);
		    } else {
		    	s_P1.setQty(s_P1.getMinQty());
		    }
	    }
	    
	    s_P1.setDlvrDate(db.getDate() + s_P1.getDlvrTime());
	    db.insertOrdersToSupplier(s_P1);
	    
	    //calculate cost
	    return s_P1;
	}
	 
	public supplier order_p2_from_supplier(int qty) throws SQLException {
		Database db = new Database();
	    db.ConnectDB();
	    
	    int warehouse_p2 = db.numberOfPiecesInWarehouse(2);
	    
	    supplier s_P2 = new supplier();
	    s_P2.SupplierC_P2();
	    
	    if(warehouse_p2 < qty) {
		    if((qty-warehouse_p2) > s_P2.getMinQty()) {
		    	s_P2.setQty((qty-warehouse_p2));
		    } else if (qty == 0) {
		    	s_P2.setQty(0);
		    } else {
		    	s_P2.setQty(s_P2.getMinQty());
		    }
	    }
	    //calculate cost
	    
	    s_P2.setDlvrDate(db.getDate() + s_P2.getDlvrTime());
	    db.insertOrdersToSupplier(s_P2);
	    
	    return s_P2;
	}
	
	public int orderPieces(int piece, int qty) throws SQLException {
		supplier s = new supplier();
		
		int pieces_ordered = 0;
		
		if(piece==1) {
			s = order_p1_from_supplier(qty);
			pieces_ordered = s.getQty();
		} else {
			s = order_p2_from_supplier(qty);
			pieces_ordered = s.getQty();
		}
		
		return pieces_ordered;
	}
	
	public float cost (int id) {
		float cost = 0;
		return cost;
	}
	
}
