package mes;
import java.util.ArrayList;

public class sorter {
	
	public static ArrayList<piece> day_pieces;
	public static void main(String[] args) {
		
		
//		while (1) {
//			read_vars();
//			
//			if(warning_start_day==1) {
//				day_pieces=database.getpieces();
//				decide_mach(null, day_pieces);
//				update_results();
//			}
//			
//			if(warning_mid_day==1) {
//				decide_tools(null, day_pieces);
//			}
//	 		
//		}
		day_pieces=database.getpieces();
		int[] tools= {1,1,2,2,3,3};
		int i,j;
		day_pieces=decide_mach(tools, day_pieces);
		for(j=0;j<day_pieces.size();j++) {
			System.out.print("day piece "+j+":ordee_id:"+day_pieces[j].orderid+"   priority:"
					+day_pieces[j].priority+"   final_form:"+day_pieces[j].final_form
					+"   curr_form:"+day_pieces[j].curr_form+ "   machines:");
			for(i=0;i<day_pieces[j].machines.size();i++)	System.out.print(day_pieces[j].machines[i]);		
			System.out.println();
		}
}

private static void decide_tools(Object object, ArrayList<piece> day_pieces2) {
				
	}

private static ArrayList<piece> decide_mach(int[] tools, ArrayList<piece> day_pieces) {
	
	for(int j=0;j<day_pieces.size();j++) {
		for(int i=0;i<day_pieces[j].machines.size();i++) day_pieces[j].machines[i]=0;		
	}
	
	for(int j=0;j<day_pieces.size();j++) {
		//PIECE 3
		if(day_pieces[j].final_form==3) 
		{
			for (int i =1; i<6; i++) 
			{
				if(tools[i]==2) {
					day_pieces[j].machines[0]=i;
					break;
				}
			}
		}
		
		//PIECE 4
		else if(day_pieces[j].final_form==4) 
		{
			for (int i =1; i<6; i++) 
			{
				if(tools[i]==3) {
					day_pieces[j].machines[0]=i;
					break;
				}
			}
		}
		
		//PIECE 5
		else if(day_pieces[j].final_form==5) 
		{
			for (int i =1; i<6; i++) 
			{
				if(tools[i]==4) {
					day_pieces[j].machines[0]=i;
					break;
				}
			}
		}
		
		//PIECE 6
		else if(day_pieces[j].final_form==6) 
		{	
			if(warehouse.p1>0) {
				for (int i =1; i<6; i++) 
				{
					if(tools[i]==1) {
						day_pieces[j].machines[0]=i;
						break;
					}
				}
			}
			else {
				for (int i =1; i<6; i++) 
				{
					if(tools[i]==2) {
						day_pieces[j].machines[0]=i;
					}
					else if(tools[i]==1 && day_pieces[j].machines[0]!=0) {
						day_pieces[j].machines[1]=i;
						break;
					}
				}
			}
		}
			
		//PIECE 7
		else if(day_pieces[j].final_form==7) 
		{
			for (int i =1; i<6; i++) 
			{
				if(tools[i]==3) {
					day_pieces[j].machines[0]=i;
				}
				else if(tools[i]==4 && day_pieces[j].machines[0]!=0) {
					day_pieces[j].machines[1]=i;
					break;
				}
			}
		}	
		
		//PIECE 8
		else if(day_pieces[j].final_form==8) 
		{
			for (int i =1; i<6; i++) 
			{
				if(tools[i]==1) {
					day_pieces[j].machines[0]=i;
				}
				else if(tools[i]==3 && day_pieces[j].machines[0]!=0) {
					day_pieces[j].machines[1]=i;
					break;
				}
			}
		}	
		
		//PIECE 9
		else if(day_pieces[j].final_form==9) 
		{
			for (int i =1; i<6; i++) 
			{
				if(tools[i]==3) {
					day_pieces[j].machines[0]=i;
				}
				else if(tools[i]==4 && day_pieces[j].machines[0]!=0) {
					day_pieces[j].machines[1]=i;
				}
				else if(tools[i]==3 && day_pieces[j].machines[1]!=0) {
					day_pieces[j].machines[2]=i;
					break;
				}
			}
		}
	}
	return day_pieces;
}
}