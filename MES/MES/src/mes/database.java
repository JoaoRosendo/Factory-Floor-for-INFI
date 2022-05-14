package mes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class database {

	public static ArrayList<piece> getpieces(){
		ArrayList<ProductList> pieces= new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String query="SELECT * FROM tblproduct ";
			if(cat==1) {
				query+="WHERE category = 'computers' ORDER BY productid DESC LIMIT 3";
			}
			
			if(cat==2) {
				query+="WHERE category = 'mobile' ORDER BY productid DESC LIMIT 3";
			}
			
			if(cat==3) {
				query+="WHERE category = 'components' ORDER BY productid DESC LIMIT 3";
			}
			
			if(cat==0) {
				query+="ORDER BY productid DESC";
			}
			
			PreparedStatement ps = con.prepareStatement(query);
			ProductList newEntry;
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				newEntry = new piece(rs.getString("brand"), rs.getString("model"), rs.getDouble("price"), 
							rs. getInt("stock"),rs.getString("description"), rs.getInt("batrank"), rs.getInt("procrank"),rs.getString("type"), rs.getInt("ranking"), rs.getString("category"));
			
			list.add(newEntry);
			
			}
			con.close();
		}
		catch(SQLException e) {
			System.out.println("ComputerData.homePage: "+e.getMessage());
		}
		
		
		
		return pieces;
	}

}
