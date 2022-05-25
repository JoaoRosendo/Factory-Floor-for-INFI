package MES;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.eclipse.milo.opcua.stack.core.UaException;

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
		int[] tools= {1,3,4,2,3,2};
		
		day_pieces=decide_mach(tools, day_pieces);
		print_daypieces(day_pieces);
		
		try {
			App.send_pieces(day_pieces);
		} catch (UaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
private static void print_daypieces(ArrayList<piece> day_pieces2) {
	int i,j;
	for(j=0;j<day_pieces.size();j++) {
		System.out.print("day piece "+j+":   order_id:"+day_pieces.get(j).orderid+"   priority:"
				+day_pieces.get(j).priority+"   final_form:"+day_pieces.get(j).final_form
				+"   curr_form:"+day_pieces.get(j).curr_form+ "   machines:");
		for(i=0;i<day_pieces.get(j).machines.length;i++)	System.out.print(day_pieces.get(j).machines[i]);		
		System.out.print("\n");
	}

}

private static void decide_tools(Object object, ArrayList<piece> day_pieces2) {
				
	}

private static ArrayList<piece> decide_mach(int[] tools, ArrayList<piece> day_pieces) {
	short i=0;
	for(int j=0;j<day_pieces.size();j++) {
		for(i=0;i<day_pieces.get(j).machines.length;i++) day_pieces.get(j).machines[i]=0;		
	}
	for(int j=0;j<day_pieces.size();j++) {
	day_pieces.get(j).machines[1]=day_pieces.get(j).curr_form;	
	day_pieces.get(j).machines[2]=day_pieces.get(j).final_form;	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!ORdem e qual a informação a passar	
	}
	
	int[] contador= {0,0,0,0,0,0};
	int[] maq_min= {0,0,0,0};
	
 	short[] n= {0,0,0,0,0};
	
	for(int j=0;j<day_pieces.size();j++) {
		
		if(day_pieces.get(j).final_form==0) {
			day_pieces.get(j).machines=n;
			break;
		}
		maq_min=check_maq_min(maq_min, contador, tools);
		//PIECE 3
		if(day_pieces.get(j).final_form==3) 
		{
			for (i=0; i<6; i++) 
			{
				if(tools[i]==2) {
					day_pieces.get(j).machines[2]=(short) maq_min[1];
					contador[i]++;
					break;
				}
			}
		}
		
		//PIECE 4
		else if(day_pieces.get(j).final_form==4) 
		{
			for (i=0; i<6; i++) 
			{
				if(tools[i]==3) {
					day_pieces.get(j).machines[2]=(short) maq_min[2];
					contador[i]++;
					break;
				}
			}
		}
		
		//PIECE 5
		else if(day_pieces.get(j).final_form==5) 
		{
			for (i=0; i<6; i++) 
			{
				if(tools[i]==4) {
					day_pieces.get(j).machines[2]=(short) maq_min[3];
					contador[i]++;
					break;
				}
			}
		}
		
		//PIECE 6
		else if(day_pieces.get(j).final_form==6) 
		{	
			if(warehouse.p2<1) {
				for (i=0; i<6; i++) 
				{
					if(tools[i]==1) {
						day_pieces.get(j).machines[2]=(short) maq_min[0];
						contador[i]++;
						break;
					}
				}
			}
			else {
				for (i=0; i<6; i++) 
				{
					if(tools[i]==2) {
						day_pieces.get(j).machines[2]=(short) maq_min[1];
						contador[i]++;
						for(i=0;i<6;i++) {
							if(tools[i]==1 && day_pieces.get(j).machines[2]!=0) {
								day_pieces.get(j).machines[3]=(short) maq_min[0];
								contador[i]++;
								break;
							}
						}
					}
				}
			}
		}
			
		//PIECE 7
		else if(day_pieces.get(j).final_form==7) 
		{
			for (i=0; i<6; i++) 
			{
				if(tools[i]==3) {
					day_pieces.get(j).machines[2]=(short) maq_min[2];
					contador[i]++;
					for(i=0;i<6;i++) {
						if(tools[i]==4 && day_pieces.get(j).machines[2]!=0) {
							day_pieces.get(j).machines[3]=(short) maq_min[3];
							contador[i]++;
							break;
						}
					}
				}
				
			}
		}	
		
		//PIECE 8
		else if(day_pieces.get(j).final_form==8) 
		{
			for (i=0; i<6; i++) 
			{
				if(tools[i]==1) {
					day_pieces.get(j).machines[2]=(short) maq_min[0];
					contador[i]++;
					for(i=0;i<6;i++) {
						if(tools[i]==3 && day_pieces.get(j).machines[2]!=0) {
							day_pieces.get(j).machines[3]=(short) maq_min[2];
							contador[i]++;
							break;
						}
					}
				}
			}
		}	
		
		//PIECE 9
		else if(day_pieces.get(j).final_form==9) 
		{
			for (i=0; i<6; i++) 
			{
				if(tools[i]==3) {
					day_pieces.get(j).machines[2]=(short) maq_min[2];
					contador[i]++;
					for (i=0; i<6; i++) {
						if(tools[i]==4 && day_pieces.get(j).machines[2]!=0) {
							day_pieces.get(j).machines[3]=(short) maq_min[3];
							contador[i]++;
							for (i=0; i<6; i++) {
								if(tools[i]==4 && day_pieces.get(j).machines[3]!=0) {
									day_pieces.get(j).machines[4]=(short) maq_min[3];
									contador[i]++;
									break;
								}
							}
						}
					}
					
				}
			}
				
		}
	}
	return day_pieces;
}

private static int[] check_maq_min(int[] maq_min, int[] contador, int[] tools ) {
	
	for(int i=0;i<tools.length;i++) {
		
		if(tools[i]==1) {
			for(int j=0;j<6;j++) {
				if(contador[i]<contador[j])maq_min[0]=i;
				else maq_min[0]=j;
			}
		}
		if(tools[i]==2) {
			for(int j=0;j<6;j++) {
				if(contador[i]<contador[j])maq_min[1]=i;
				else maq_min[1]=j;
			}
		}
		if(tools[i]==3) {
			for(int j=0;j<6;j++) {
				if(contador[i]<maq_min[2])maq_min[2]=i;
				else maq_min[2]=j;
			}
		}		
		if(tools[i]==4) {
			for(int j=0;j<6;j++) {
				if(contador[i]<maq_min[3])maq_min[3]=i;
				else maq_min[3]=j;
			}
		}		
		
	}
	
	return maq_min;
}
}
