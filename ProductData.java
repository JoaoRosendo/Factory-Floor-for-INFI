import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductData{

	private static String url = "jdbc:postgresql://db.fe.up.pt:5432/up201707358";
    private static String user = "up201707358";
    private static String password = "G229Gee2h";

    
    //cat=1 computers
    //cat=2 mobile
    //cat=3 components
    //cat=0 all products
    
    //value=1 bad
    //value=2 med
    //value=3 good
    
    //ranking=1 Batrank
    //ranking=2 Procrank
    //ranking=3 ranking
    
    //(0,0,4) Keyboard

    //(0,0,5) Mouse

    //(0,0,6) Processors

    //(0,0,7) Graphics Cards
    
    
    
	public static ArrayList<ProductList> homePage(int cat) {
		ArrayList<ProductList> list= new ArrayList<>();
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
				newEntry = new ProductList(rs.getString("brand"), rs.getString("model"), rs.getDouble("price"), 
							rs. getInt("stock"),rs.getString("description"), rs.getInt("batrank"), rs.getInt("procrank"),rs.getString("type"), rs.getInt("ranking"), rs.getString("category"));
			
			list.add(newEntry);
			
			}
			con.close();
		}
		catch(SQLException e) {
			System.out.println("ComputerData.homePage: "+e.getMessage());
		}
		
		
		
		return list;

	}
	
	public static ArrayList<ProductList> filters(int cat, int value, int ranking) {
		ArrayList<ProductList> list= new ArrayList<>();
		try {
			
			Connection con = DriverManager.getConnection(url, user, password);
			String query="SELECT * FROM tblproduct ";
			
			////////////////////////////////////Batrank///////////////////
			
			//Computers batrank filters
			if(cat==1&&value==1&&ranking==1) {
				query+="WHERE batrank<50 AND category = 'computers' ORDER BY productid DESC";
			}
			
			if(cat==1&&value==2&&ranking==1) {
				query+="WHERE 50<=batrank<75 AND category = 'computers' ORDER BY productid DESC";
			}
			
			if(cat==1&&value==3&&ranking==1) {
				query+="WHERE batrank>=75 AND category = 'computers' ORDER BY productid DESC";
			}
			
			//'mobile' Batrank Filters
			if(cat==2&&value==1&&ranking==1) {
				query+="WHERE batrank<50 AND category = 'mobile' ORDER BY productid DESC";
			}
			
			if(cat==2&&value==2&&ranking==1) {
				query+="WHERE 50<=batrank<75 AND category = 'mobile' ORDER BY productid DESC";
			}
			
			if(cat==2&&value==3&&ranking==1) {
				query+="WHERE batrank>=75 AND category = 'mobile' ORDER BY productid DESC";
			}
			
			//Components Barank filters
			if(cat==3&&value==1&&ranking==1) {
				query+="WHERE batrank<50 AND category = 'components' ORDER BY productid DESC";
			}
			
			if(cat==3&&value==2&&ranking==1) {
				query+="WHERE 50<=batrank<75 AND category = 'components' ORDER BY productid DESC";
			}
			
			if(cat==3&&value==3&&ranking==1) {
				query+="WHERE batrank>=75 AND category = 'components' ORDER BY productid DESC";
			}
			
			
			
			
			///////////////////////////////////// PRocrank/////////////////////
			
			//'computers' Procrank Filters
			if(cat==1&&value==1&&ranking==2) {
				query+="WHERE procrank<50 AND category = 'computers' ORDER BY productid DESC";
			}
			
			if(cat==1&&value==2&&ranking==2) {
				query+="WHERE 50<procrank>=75 AND category = 'computers' ORDER BY productid DESC";
			}
			
			if(cat==1&&value==3&&ranking==2) {
				query+="WHERE procrank>=75 AND category = 'computers' ORDER BY productid DESC";
			}
			
			//Mobie Procrank FIleters
			if(cat==2&&value==1&&ranking==2) {
				query+="WHERE procrank<50 AND category = 'mobile' ORDER BY productid DESC";
			}
			
			if(cat==2&&value==2&&ranking==2) {
				query+="WHERE 50<=procrank>75 AND category = 'mobile' ORDER BY productid DESC";
			}
			
			if(cat==2&&value==3&&ranking==2) {
				query+="WHERE procrank>=75 AND category = 'mobile' ORDER BY productid DESC";
			}
			
			
			//'components' Barank filters
			if(cat==3&&value==1&&ranking==2) {
				query+="WHERE procrank<50 AND category = 'components' ORDER BY productid DESC";
			}
			
			if(cat==3&&value==2&&ranking==2) {
				query+="WHERE 50<=procrank<75 AND category = 'components' ORDER BY productid DESC";
			}
			
			if(cat==3&&value==3&&ranking==2) {
				query+="WHERE procrank>=75 AND category = 'components' ORDER BY productid DESC";
			}
			
			
			
			
			/////////////////////////Ranking///////////////
						
			//'computers' Procrank Filters
			if(cat==1&&value==1&&ranking==3) {
				query+="WHERE ranking=1 AND category = 'computers' ORDER BY productid DESC";
			}
			
			if(cat==1&&value==2&&ranking==3) {
				query+="WHERE ranking=2 AND category = 'computers' ORDER BY productid DESC";
			}
			
			if(cat==1&&value==3&&ranking==3) {
				query+="WHERE ranking=3 AND category = 'computers' ORDER BY productid DESC";
			}
			
			//Mobie Procrank FIleters
			if(cat==2&&value==1&&ranking==3) {
				query+="WHERE ranking=1 AND category = 'mobile' ORDER BY productid DESC";
			}
			
			if(cat==2&&value==2&&ranking==3) {
				query+="WHERE ranking=2 AND category = 'mobile' ORDER BY productid DESC";
			}
			
			if(cat==2&&value==3&&ranking==3) {
				query+="WHERE ranking=3 AND category = 'mobile' ORDER BY productid DESC";
			}
			
			
			//'components' Procrank Filters
			if(cat==3&&value==1&&ranking==3) {
				query+="WHERE ranking=1 AND category = 'components' ORDER BY productid DESC";
			}
			
			if(cat==3&&value==2&&ranking==3) {
				query+="WHERE ranking=2 AND category = 'components' ORDER BY productid DESC";
			}
			
			if(cat==3&&value==3&&ranking==3) {
				query+="WHERE ranking=3 AND category = 'components' ORDER BY productid DESC";
			}
			
			if(cat==0&&value==0&&ranking==4) {
				query+="WHERE type='keyboard' AND category = 'components' ORDER BY productid DESC";
			}
			
			if(cat==0&&value==0&&ranking==5) {
				query+="WHERE type='mouse' AND category = 'components' ORDER BY productid DESC";
			}
			
			if(cat==0&&value==0&&ranking==6) {
				query+="WHERE type='processor' AND category = 'components' ORDER BY productid DESC";
			}
			
			if(cat==0&&value==0&&ranking==7) {
				query+="WHERE type='graphics card' AND category = 'components' ORDER BY productid DESC";
			}
			
			PreparedStatement ps = con.prepareStatement(query);
			ProductList newEntry;
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				newEntry = new ProductList(rs.getString("brand"), rs.getString("model"), rs.getDouble("price"), 
						rs. getInt("stock"),rs.getString("description"), rs.getInt("batrank"), rs.getInt("procrank"),rs.getString("type"), rs.getInt("ranking"), rs.getString("category"));
			
			list.add(newEntry);
			con.close();
			}
		}
		catch(SQLException e) {
			System.out.println("ComputerData.filters: "+e.getMessage());
		}
		
		
		
		return list;
	}
	
}