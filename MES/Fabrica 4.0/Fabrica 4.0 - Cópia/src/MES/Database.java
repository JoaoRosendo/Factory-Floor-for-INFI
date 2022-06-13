package MES;

import static org.mockito.ArgumentMatchers.longThat;

import java.sql.Connection;
import java.util.Random;
import java.time.Duration;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Clock;
import java.util.ArrayList;


public class Database {
    private static String url = "jdbc:postgresql://db.fe.up.pt:5432/up201806577";
    private static String user = "up201806577";
    private static String password = "dpPk0HcRN";
	protected static int count;
	
	public static ArrayList<Piece> getpieces(){
		
		// |||||||||||||||||||||||||||||||||||||CODE TO TEST|||||||||||||||||||~
		
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("inserting into Day_pieces_intermed");
			PreparedStatement ps = con.prepareStatement("INSERT INTO day_pieces_intermed (order_id,priority,final_form, days_to_finish, "
					+ "nr_pieces, client_id, start_date,warehouse_pieces,pieces_ordered) VALUES (?,?,?,?,?,?,?,?,?)");

			ps.setInt(1, (int)  (int)(Math.random()*(9-1+1)+1) );
			ps.setInt(2, (int) 1 );
			ps.setInt(3, (int)  (int)(Math.random()*(9-3+1)+3));
			ps.setInt(4, (int)	1 );
			ps.setInt(5, (int) (int)(Math.random()*(12-3+1)+3));
			ps.setString(6, "AA"  );
			ps.setInt(7, 1  );
			ps.setInt(8, 1  );
			ps.setInt(9, 6  );
			ps.addBatch();        	
			ps.executeBatch();
			ps.close();
		}
		catch(SQLException e) {
			System.out.println("database.getpieces random gen: "+e.getMessage());
		}
//		try {
//			Connection con = DriverManager.getConnection(url, user, password);
//			System.out.println("inserting into Day_pieces_intermed");
//			PreparedStatement ps = con.prepareStatement("INSERT INTO day_pieces_intermed (order_id,priority,final_form, days_to_finish, "
//					+ "nr_pieces, client_id, start_date,warehouse_pieces,pieces_ordered) VALUES (?,?,?,?,?,?,?,?,?)");
//
//			ps.setInt(1, (int)  (int)(Math.random()*(9-1+1)+1) );
//			ps.setInt(2, (int) 1 );
//			ps.setInt(3, (int)  6);
//			ps.setInt(4, (int)	1 );
//			ps.setInt(5, (int) 3);
//			ps.setString(6, "AA"  );
//			ps.setInt(7, 1  );
//			ps.setInt(8, 1  );
//			ps.setInt(9, 6  );
//			ps.addBatch();        	
//			ps.executeBatch();
//			ps.close();
//		}
//		catch(SQLException e) {
//			System.out.println("database.getpieces random gen: "+e.getMessage());
//		}
		// ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
		
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			
			String query="SELECT COUNT(*) FROM day_pieces_intermed";
			System.out.println("check if empty Day_pieces_intermed");
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			int exists=0;
			rs.next();
			exists=rs.getInt(1);
			System.out.println("Waiting for new orders");
			while(exists==0) {
				ps = con.prepareStatement(query);
				rs = ps.executeQuery();
				exists=0;
				rs.next();
				exists=rs.getInt(1);
			}
			
			con.close();

		}
		catch(SQLException r) {
			System.out.println("database.getpieces at waiting fo intermed not empty: "+r.getMessage());
		}
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);

			System.out.println("DELETE Day_pieces");
			String query="TRUNCATE TABLE day_pieces";

			PreparedStatement ps = con.prepareStatement(query);
			ps.addBatch();        	
			ps.executeBatch();

			
		}
		catch(SQLException w) {
			System.out.println("database.getpieces at deleting day_pieces: "+w.getMessage());
		}

		
		try {
			Connection con = DriverManager.getConnection(url, user, password);

			String query="INSERT INTO day_pieces (SELECT order_id, priority, final_form,days_to_finish, nr_pieces,client_id,warehouse_pieces, pieces_ordered FROM day_pieces_intermed)";
			System.out.println("Copy Day_pieces_intermed");
			PreparedStatement ps = con.prepareStatement(query);
			ps.addBatch();        	
			ps.executeBatch();

			
		}
		catch(SQLException r) {
			System.out.println("database.update_stats at copying intermed to day_pieces: "+r.getMessage());
		}
		try {
			Connection con = DriverManager.getConnection(url, user, password);

			String query="TRUNCATE TABLE day_pieces_intermed";

			PreparedStatement ps = con.prepareStatement(query);
			ps.addBatch();        	
			ps.executeBatch();

			
		}
		catch(SQLException t) {
			System.out.println("database.update_stats at deleting intermed: "+t.getMessage());
		}
		ArrayList<Piece> pieces= new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String query="SELECT * FROM day_pieces ORDER BY nr_pieces DESC";
						
			PreparedStatement ps = con.prepareStatement(query);
			Piece newEntry;
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				short i=0;
				short[] buff = {-1,-1,-1,-1,-1,-1};
				sorter.nr_pieces_ordered=rs.getInt("pieces_ordered");
				for(i=1;i<=rs.getInt("nr_pieces");i++) {
					Clock now= Clock.systemUTC();
					long time=now.millis();
					newEntry = new Piece(rs.getString("client_id"),(short)rs.getInt("order_id"),i, buff, /*rs.getInt("priority")*/(short)1, (short)rs.getInt("final_form"), (short)1
							, (short)0, time, (double)0 	);
					pieces.add(newEntry);
					if(i==12) {
						con.close();
						return pieces;
					}
				}
				if (i<=12) {
					while(i<=12) {
						newEntry = new Piece("00",(short)0,(short)0, buff, (short)0, (short)0, (short)0, (short)0, 0,(double)0);
						pieces.add(newEntry);
						if(i==12) return pieces;
						i++;
					}
				}
			
			}
			con.close();
		}
		catch(SQLException e) {
			System.out.println("database.day_pieces: "+e.getMessage());
		}
		
		
		
		return pieces;
	}

	public static int update_stats_EoRequests(ArrayList<Piece> day_pieces) {
		long time0=0;
		int iteration=0;
		for(int i=0; i< day_pieces.size(); i++) {
			if(!day_pieces.get(i).getClientid().equals(day_pieces.get(0).getClientid())||day_pieces.get(i).getOrderid()!=(day_pieces.get(0).getOrderid())) {
				iteration=i;
			}
			
		}
			try {

				Connection con = DriverManager.getConnection(url, user, password);
				Clock now= Clock.systemUTC();

				long aux1=now.millis()/1000;
				long aux2=sorter.day_pieces.get(0).now/1000;
				time0=aux1-aux2;

				//System.out.println("milis: "+Long.toString(aux1)+"-"+Long.toString(aux2)+"="+Long.toString(time0));

				PreparedStatement ps = con.prepareStatement("INSERT INTO day_stats (avg_time_piece,orderid,client_id) VALUES (?,?,?)");

				ps.setInt(1, (int)time0 );
				ps.setInt(2, (int)day_pieces.get(0).getOrderid() );
				ps.setString(3, day_pieces.get(0).getClientid() );
				ps.addBatch();        	
				ps.executeBatch();
				if(iteration!=0) {
					ps = con.prepareStatement("INSERT INTO day_stats (avg_time_piece,orderid,client_id) VALUES (?,?,?)");

					ps.setInt(1, (int)time0 );
					ps.setInt(2, (int)day_pieces.get(iteration).getOrderid() );
					ps.setString(3, day_pieces.get(iteration).getClientid() );
					ps.addBatch();        	
					ps.executeBatch();
				}
				con.close();
			}

		catch(SQLException q) {
			System.out.println("database.update_stats: "+q.getMessage());
		}



		//		try {
		//			Connection con = DriverManager.getConnection(url, user, password);
		//
		//			String query="INSERT INTO day_pieces (SELECT order_id, priority, final_form,days_to_finish, nr_pieces,client_id FROM day_pieces_intermed)";
		//			System.out.println("Copy Day_pieces_intermed");
		//			PreparedStatement ps = con.prepareStatement(query);
		//			ps.addBatch();        	
		//			ps.executeBatch();
		//
		//			
		//		}
		//		catch(SQLException r) {
		//			System.out.println("database.update_stats at copying intermed to day_pieces: "+r.getMessage());
		//		}
		//		try {
		//			Connection con = DriverManager.getConnection(url, user, password);
		//
		//			String query="TRUNCATE TABLE day_pieces_intermed";
		//
		//			PreparedStatement ps = con.prepareStatement(query);
		//			ps.addBatch();        	
		//			ps.executeBatch();
		//
		//			
		//		}
		//		catch(SQLException t) {
		//			System.out.println("database.update_stats at deleting intermed: "+t.getMessage());
		//		}	

		return count;

	}

	
}
