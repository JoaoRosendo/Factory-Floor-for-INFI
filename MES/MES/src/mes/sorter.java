package mes;

import java.util.ArrayList;

public class sorter {
	
	public static ArrayList<piece> day_pieces;
	public static void main(String[] args) {
		
		
		while (1) {
			read_vars();
			
			if(warning_start_day==1) {
				day_pieces=database.getpieces();
				decide_mach(null, day_pieces);
				update_results();
			}
			
			if(warning_mid_day==1) {
				decide_tools(null, day_pieces);
			}
			
		}
		
	
}

private static void decide_tools(Object object, ArrayList<piece> day_pieces2) {
				
	}

public int decide_mach(int[] tools, ArrayList<piece> day_pieces) {
	
	for(int j=0;j<day_pieces.length;j++) {
		for(int i=0;i<day_pieces.machines.length;i++) day_pieces[j].machines.[i]=0;		
	}
	
	for(int j=0;j<day_pieces.length;j++) {
		//PIECE 3
		if(p.final_form==3) 
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
		else if(p.final_form==4) 
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
		else if(p.final_form==5) 
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
		else if(p.final_form==6) 
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
		else if(p.final_form==7) 
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
		else if(p.final_form==8) 
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
		else if(p.final_form==9) 
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
	
}