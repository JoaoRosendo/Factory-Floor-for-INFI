package MES;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import org.eclipse.milo.opcua.stack.core.UaException;
import java.util.*;


class MyThread extends Thread{
	public void statistics() {
		
		while(true) {
			
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}

public class sorter {
    public static ArrayList<piece> day_pieces;
    public static warehouse w1;
    public static ArrayList<machine> machines;
    public static short[] dock={0,0,0,0,0,0,0,0,0};
    
	public static void main(String[] args) {
	
		
		MyThread data_analisys=new MyThread();
		
		
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
//		print_daypieces(day_pieces);
//		System.out.println();
//		System.out.println();
		day_pieces=decide_mach( day_pieces);
		
		print_daypieces(day_pieces);
		
//		try {
//			//App.send_pieces(day_pieces);
//		} catch (UaException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		data_analisys.start();
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


private static ArrayList<piece> decide_mach(ArrayList<piece> day_pieces) {
	short i=0;
	short[] dock= {0,0,0};
	short[] a={0,0,0,0,0,0};
	
//	for(int j=0;j<day_pieces.size();j++) {
//		for(i=0;i<day_pieces.get(j).machines.length;i++) day_pieces.get(j).machines[i]=0;		
//	}

	for(int j=0;j<day_pieces.size();j++) {
		
		if(day_pieces.get(j).priority==0) {day_pieces.get(j).machines=a ;} 
		else if(day_pieces.get(j).priority!=0){
					
			day_pieces.get(j).machines[1]=day_pieces.get(j).pieceid;	
		
			if(day_pieces.get(j).final_form==3) {
				day_pieces.get(j).machines[2]=2;	
			}
			
			if(day_pieces.get(j).final_form==4) {
				day_pieces.get(j).machines[2]=3;	
			}
			
			if(day_pieces.get(j).final_form==5) {
				day_pieces.get(j).machines[2]=4;	
			}
			
			if(day_pieces.get(j).final_form==6) {
				if(w1.p2>0) {
					day_pieces.get(j).machines[2]=1;	
				}
				else {
					day_pieces.get(j).machines[2]=2;
					day_pieces.get(j).machines[3]=1;	
				}
			}
			
			if(day_pieces.get(j).final_form==7) {
				day_pieces.get(j).machines[2]=3;
				day_pieces.get(j).machines[3]=4;	
			}
			
			if(day_pieces.get(j).final_form==8) {
				day_pieces.get(j).machines[2]=1;
				day_pieces.get(j).machines[3]=3;	
			}
			
			if(day_pieces.get(j).final_form==9) {
				day_pieces.get(j).machines[2]=3;	
				day_pieces.get(j).machines[3]=4;	
				day_pieces.get(j).machines[4]=3;	
			}

			if(day_pieces.get(j).orderid==day_pieces.get(0).orderid) {
				if(dock[0]<4 ) {day_pieces.get(j).machines[5]=1; dock[0]++;System.out.print("dock:1  \n");}
				else if(dock[0]==4 && dock[1]<4 ) {day_pieces.get(j).machines[5]=2; dock[1]++;System.out.print("dock:2  \n");}
				else if(dock[1]==4 && dock[2]<4) {day_pieces.get(j).machines[5]=3; dock[2]++;}
		
			}
			if(day_pieces.get(j).orderid!=day_pieces.get(0).orderid && day_pieces.get(j).orderid!=0) {
				if(dock[0]<5) {day_pieces.get(j).machines[5]=1; dock[0]++;}
				else if(dock[0]>5 ) {day_pieces.get(j).machines[5]=2; dock[1]++;}
			}
		}
		
		for(i=0;i<day_pieces.get(j).machines.length;i++)	System.out.print(day_pieces.get(j).machines[i]);
		System.out.println();
	}
	
	return day_pieces;
	
}
}
