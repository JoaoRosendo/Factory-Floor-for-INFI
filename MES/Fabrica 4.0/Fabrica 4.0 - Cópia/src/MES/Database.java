package MES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class Database {
    private static String url = "jdbc:postgresql://db.fe.up.pt:5432/up201806577";
    private static String user = "up201806577";
    private static String password = "dpPk0HcRN";
	protected static int count;
	
	public static ArrayList<Piece> getpieces(){
		
		
		ArrayList<Piece> pieces= new ArrayList<>();
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
			System.out.println("database.update_stats at copying intermed to day_pieces: "+r.getMessage());
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
			System.out.println("database.update_stats at deleting day_pieces: "+w.getMessage());
		}

		
		try {
			Connection con = DriverManager.getConnection(url, user, password);

			String query="INSERT INTO day_pieces (SELECT order_id, priority, final_form,days_to_finish, nr_pieces,client_id FROM day_pieces_intermed)";
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
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String query="SELECT * FROM day_pieces ORDER BY nr_pieces DESC";
						
			PreparedStatement ps = con.prepareStatement(query);
			Piece newEntry;
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				short i=0;
				short[] buff = {0,0,0,0,0,0};
				for(i=1;i<=rs.getInt("nr_pieces");i++) {
					
					newEntry = new Piece(rs.getString("client_id"),(short)rs.getInt("order_id"),i, buff, /*rs.getInt("priority")*/(short)1, (short)rs.getInt("final_form"), (short)1
							, (short)0, Instant.now(), (double)0 	);
					pieces.add(newEntry);
					if(i==12) return pieces;
				}
				if (i<=12) {
					while(i<=12) {
						
						newEntry = new Piece("00",(short)0,(short)0, buff, (short)0, (short)0, (short)0, (short)0, Instant.now(),(double)0);
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
		long[] time={0,0};
		int instance_dif_id=0;
		Instant now=Instant.now();
		
		try {
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			for(int i=0;i>day_pieces.size();i++) {
				System.out.println("time"+i+"   "+(sorter.day_pieces.get(i).getStart().toEpochMilli()-now.toEpochMilli()));
				System.out.println("clientid i:"+sorter.day_pieces.get(i).getClientid()+"==== clientid 0="+sorter.day_pieces.get(0).getClientid());
				if((sorter.day_pieces.get(i).getClientid().equals(sorter.day_pieces.get(0).getClientid())) && (sorter.day_pieces.get(i).getOrderid()==sorter.day_pieces.get(0).getOrderid())) {
					time[0]=time[0]+(long)(sorter.day_pieces.get(i).getStart().toEpochMilli());
					System.out.println("milis add");

				}
				else {
					time[1]=time[1]+Duration.between(sorter.day_pieces.get(i).start, now).toMillis();
					instance_dif_id=i;
				}
				
			}	
			time[0]=(time[0]/1000)/12;
			
			if(time[1]!=0) {
				time[1]=(time[2]/1000)/12;
				System.out.println("milis avg"+time[0]);
				System.out.println("milis avg2"+time[1]);
				PreparedStatement ps = con.prepareStatement("INSERT INTO day_stats (avg_time_piece,orderid,client_id) VALUES (?,?,?)");
				
				ps.setInt(1, (int)time[0] );
				ps.setInt(2, (int)day_pieces.get(0).getOrderid() );
				ps.setString(3, day_pieces.get(0).getClientid() );
				ps.addBatch();        	
				ps.executeBatch();
				
				ps = con.prepareStatement("INSERT INTO day_stats (avg_time_piece,orderid,client_id) VALUES (?,?,?)");

				ps.setInt(1, (int)time[1] );
				ps.setInt(2, (int)day_pieces.get(instance_dif_id).getOrderid() );
				ps.setString(3, day_pieces.get(instance_dif_id).getClientid() );
				ps.addBatch();        	
				ps.executeBatch();
				con.close();
			}
			else {
				System.out.println("milis avg:"+time[0]);
				PreparedStatement ps = con.prepareStatement("INSERT INTO day_stats (avg_time_piece,orderid,client_id) VALUES (?,?,?)");

				ps.setInt(1, (int)time[0] );
				ps.setInt(2, (int)day_pieces.get(0).getOrderid() );
				ps.setString(3, day_pieces.get(0).getClientid() );
				ps.addBatch();        	
				ps.executeBatch();

				con.close();
			}
			
			
			
		}
		catch(SQLException q) {
			System.out.println("database.update_stats: "+q.getMessage());
		}
		
		
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);

			String query="INSERT INTO day_pieces (SELECT order_id, priority, final_form,days_to_finish, nr_pieces,client_id FROM day_pieces_intermed)";
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

		return count;
		
	}

	
}
