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
			String query="SELECT * FROM day_pieces ORDER BY nr_pieces DESC";
						
			PreparedStatement ps = con.prepareStatement(query);
			Piece newEntry;
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				short i=0;
				short[] buff = {0,0,0,0,0,0};
				for(i=1;i<=rs.getInt("nr_pieces");i++) {
					
					newEntry = new Piece((short)rs.getInt("client_id"),(short)rs.getInt("order_id"),i, buff, /*rs.getInt("priority")*/(short)1, (short)rs.getInt("final_form"), (short)1
							, (short)0, Instant.now(), (double)0 	);
					pieces.add(newEntry);
					if(i==12) return pieces;
				}
				if (i<=12) {
					while(i<=12) {
						
						newEntry = new Piece((short)0,(short)0,(short)0, buff, (short)0, (short)0, (short)0, (short)0, Instant.now(),(double)0);
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
				if(day_pieces.get(i).getClientid()==day_pieces.get(0).getClientid()&&day_pieces.get(i).getOrderid()==day_pieces.get(0).getOrderid()) {
					time[1]=time[1]+Duration.between(day_pieces.get(i).start, now).toMillis();
				}
				else {
					time[2]=time[2]+Duration.between(day_pieces.get(i).start, now).toMillis();
					instance_dif_id=i;
				}
				
			}	
			time[1]=(time[1]/1000)/12;
			time[2]=(time[2]/1000)/12;
			if(time[2]!=0) {
				PreparedStatement ps = con.prepareStatement("INSERT INTO day_stats (avg_time_piece,orderid,clientid) VALUES (?,?,?)");

				ps.setInt(1, (int)time[1] );
				ps.setInt(2, (int)day_pieces.get(0).getClientid() );
				ps.setInt(3, (int)day_pieces.get(0).getClientid() );
				ps.addBatch();        	
				ps.executeBatch();
				
				ps = con.prepareStatement("INSERT INTO day_stats (avg_time_piece,orderid,clientid) VALUES (?,?,?)");

				ps.setInt(1, (int)time[2] );
				ps.setInt(2, (int)day_pieces.get(instance_dif_id).getClientid() );
				ps.setInt(3, (int)day_pieces.get(instance_dif_id).getClientid() );
				ps.addBatch();        	
				ps.executeBatch();
				con.close();
			}
			else {
				PreparedStatement ps = con.prepareStatement("INSERT INTO day_stats (avg_time_piece,orderid,clientid) VALUES (?,?,?)");

				ps.setInt(1, (int)time[1] );
				ps.setInt(2, (int)day_pieces.get(0).getClientid() );
				ps.setInt(3, (int)day_pieces.get(0).getClientid() );
				ps.addBatch();        	
				ps.executeBatch();

				con.close();
			}
			
			
			
		}
		catch(SQLException e) {
			System.out.println("database.update_stats: "+e.getMessage());
		}

		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String query="DELETE FROM day_pieces";

			PreparedStatement ps = con.prepareStatement(query);
			ps.addBatch();        	
			ps.executeBatch();

			con.close();
		}
		catch(SQLException e) {
			System.out.println("database.update_stats: "+e.getMessage());
		}

		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String query="INSERT INTO \"up201806577\".\"day_pieces\" (SELECT * FROM \"up201806577\".\"day_pieces_intermed\");";

			PreparedStatement ps = con.prepareStatement(query);
			ps.addBatch();        	
			ps.executeBatch();

			con.close();
		}
		catch(SQLException e) {
			System.out.println("database.update_stats: "+e.getMessage());
		}

		return count;
		
	}

	
}
