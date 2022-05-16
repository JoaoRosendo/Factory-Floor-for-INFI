package mes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class database {
	
	private static String url = "jdbc:postgresql://db.fe.up.pt:5432/up201707358";
    private static String user = "up201707358";
    private static String password = "G229Gee2h";
	protected static int count;
	
	public static ArrayList<piece> getpieces(){
		ArrayList<piece> pieces= new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String query="SELECT * FROM day_pieces ";
						
			PreparedStatement ps = con.prepareStatement(query);
			piece newEntry;
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int[] buff;
				for(int i=0;i<rs.getInt("nr_pieces");i++) {
					newEntry = new piece(rs.getInt("order_id"), buff, rs.getInt("priority"), rs.getInt("final_form"), 0);
					pieces.add(newEntry);
				}
				
			
			}
			con.close();
		}
		catch(SQLException e) {
			System.out.println("ComputerData.homePage: "+e.getMessage());
		}
		
		
		
		return pieces;
	}

}
