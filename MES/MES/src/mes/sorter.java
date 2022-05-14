package mes;

import java.util.ArrayList;

public class sorter {
	
	
	public static void main(String[] args) {
		
		ArrayList<piece> day_pieces=database.getpieces();
		decide_mach()
	}
	
}

public int decide_mach(int[] tools, ArrayList<piece> day_pieces) {
	
	for(int i=0;i<day_pieces.machines.length;i++) p.machines[i]=0;		
	
	//PIECE 3
	if(p.final_form==3) 
	{
		for (int i =1; i<6; i++) 
		{
			if(tools[i]==2) {
				p.machines[0]=i;
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
				p.machines[0]=i;
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
				p.machines[0]=i;
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
					p.machines[0]=i;
					break;
				}
			}
		}
		else {
			for (int i =1; i<6; i++) 
			{
				if(tools[i]==2) {
					p.machines[0]=i;
				}
				else if(tools[i]==1 && p.machines[0]!=0) {
					p.machines[1]=i;
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
				p.machines[0]=i;
			}
			else if(tools[i]==4 && p.machines[0]!=0) {
				p.machines[1]=i;
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
				p.machines[0]=i;
			}
			else if(tools[i]==3 && p.machines[0]!=0) {
				p.machines[1]=i;
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
				p.machines[0]=i;
			}
			else if(tools[i]==4 && p.machines[0]!=0) {
				p.machines[1]=i;
			}
			else if(tools[i]==3 && p.machines[1]!=0) {
				p.machines[2]=i;
				break;
			}
		}
	}
}