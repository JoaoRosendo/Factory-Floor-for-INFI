package erp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/*
 * 
CREATE TABLE orders (
id SERIAL PRIMARY KEY,
number INT,
client VARCHAR(2),
workpiece INT,
quantity INT,
due_date INT,
late_penalty INT,
early_penalty INT
);
 * 
 * 
DELETE FROM orders;
DELETE FROM day_pieces_intermed;
ALTER SEQUENCE orders_id_seq RESTART WITH 1; 
 * 
 */

//https://www.tutorialspoint.com/postgresql/postgresql_java.htm
public class Database {

	public Connection ConnectDB() {
		Connection c = null;
	      try {
	    	  Class.forName("org.postgresql.Driver");
	    	  String url = "jdbc:postgresql://db.fe.up.pt:5432/up201806577";
	    	  String username = "up201806577";
	    	  String password = "dpPk0HcRN";
	    	  
	    	  c = DriverManager.getConnection(url,username,password);
	    	  	    	  
	    	  //System.out.println(c.getSchema());
	    	  //c.close();
	      } catch (Exception e) {
	    	  e.printStackTrace();
	          System.err.println(e.getClass().getName()+": "+e.getMessage());
	          System.exit(0);
	      }
	      
	      return c;
	}
	
	public void insertOrder(order order) throws SQLException {
		Connection c = ConnectDB();
		Statement stmt = c.createStatement();
			
		String sql = "INSERT INTO Orders "
						+ "(Number,Client,WorkPiece,Quantity,Due_Date,Late_Penalty,Early_Penalty) "
		        		+ "VALUES ('"+order.getNumber()+"','"
		        					 +order.getClient()+"','"
		        					 +order.getWorkpiece()+"','"
		        					 +order.getQty()+"','"
		        					 +order.getDueDate()+"','"
		        					 +order.getLatePenalty()+"','"
		        					 +order.getEarlyPenalty()+"');";
		stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		order.setId(rs.getInt(1));
		
		sendToMES(order);
		
	}
	
	public void sendToMES(order order) throws SQLException {
		Connection c = ConnectDB();
		Statement stmt = c.createStatement();
		String sql;
		MPS mps = new MPS();
		
		int start_date = mps.set_start_date(order.getId());
		int warehouse_pieces = 0;
		int pieces_ordered = 0;
		int starting_piece = 0;
		
		if(order.getWorkpiece()==1 || order.getWorkpiece()==6 || order.getWorkpiece()==8) {
			starting_piece = 1;
			warehouse_pieces = mps.warehouse_p1;
		} else {
			starting_piece = 2;
			warehouse_pieces = mps.warehouse_p2;
		}
		
		if(starting_piece == 1) {
			pieces_ordered = mps.order_p1_from_supplier(order.getId());
			
		} else {
			pieces_ordered = mps.order_p2_from_supplier(order.getId());
		}
		
		
		
		sql = "INSERT INTO day_pieces_intermed (order_id,priority,final_form,days_to_finish,nr_pieces,client_id,start_date,warehouse_pieces,pieces_ordered,starting_piece) "
        		+ "VALUES ('"+order.getId()+"','"
        					 +1+"','"// 	ALTERAR AQUI QUANDO SOUBERES O QUE ESTÁS A FAZER KAKAKAKA
        					 +order.getWorkpiece()+"','"
        					 +order.getDueDate()+"','"
        					 +order.getQty()+"','"
        					 +order.getClient()+"','"
        					 +start_date+"','"
        					 +warehouse_pieces+"','"
        					 +pieces_ordered+"','"
        					 +starting_piece+"');";
		stmt.executeUpdate(sql);
	}
	
	public order getOrder(int id) throws SQLException {
		Connection c = ConnectDB();
		Statement stmt = c.createStatement();
		
		order order = new order();
		
		ResultSet rs = stmt.executeQuery( "SELECT * FROM orders WHERE id='"+id+"';" );
		
		while(rs.next()) {
			order.setNumber(rs.getInt("number"));
			order.setClient(rs.getString("client"));
			order.setWorkpiece(rs.getInt("workpiece"));
			order.setQty(rs.getInt("quantity"));
			order.setDueDate(rs.getInt("due_date"));
			order.setLatePenalty(rs.getInt("late_penalty"));
			order.setEarlyPenalty(rs.getInt("early_penalty"));
		}
		
		return order;
	}
	
	public int numberOfP1(int id) throws SQLException {
		int P1_qty = 0;
		
		Connection c = ConnectDB();
		Statement stmt = c.createStatement();
		
		ResultSet rs = stmt.executeQuery( "SELECT Quantity FROM orders WHERE id='"+id+"' and (workpiece=1 or workpiece=6 or workpiece=8);" );
		
		while(rs.next()) {
			P1_qty += rs.getInt("quantity");
		}
		
		return P1_qty;
	}
	
	public int numberOfP2(int id) throws SQLException {
		int P2_qty = 0;
		
		Connection c = ConnectDB();
		Statement stmt = c.createStatement();
		
		ResultSet rs = stmt.executeQuery( "SELECT Quantity FROM orders WHERE id='"+id+"' and (workpiece=2 or "
				+ "workpiece=4 or workpiece=5 or workpiece=7 or workpiece=9);" );
		
		while(rs.next()) {
			P2_qty += rs.getInt("quantity");
		}
		
		return P2_qty;
	}
	
}

