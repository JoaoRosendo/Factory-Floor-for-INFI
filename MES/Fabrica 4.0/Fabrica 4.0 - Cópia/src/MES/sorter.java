package MES;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import org.eclipse.milo.opcua.stack.core.UaException;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

class MyThread extends Thread{
	public void statistics() throws UaException, InterruptedException, ExecutionException {
		UI info=new UI();
		
		while(true) {
			sorter.day_pieces=App.check_pieces(sorter.day_pieces);			
			//update_stats();
			update_gui(info);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}

	private void update_gui(UI info) {

		info.daily_pieces1.setText("Client id:"+String.valueOf(sorter.day_pieces.get(1).clientid)
			+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(1).pieceid)
			+ "  Current form:" +String.valueOf(sorter.day_pieces.get(1).curr_form)
			+ "  Final Form:"+String.valueOf(sorter.day_pieces.get(1).final_form) 
			+ "  Array:"+String.valueOf(sorter.day_pieces.get(1).machines[0])
			+String.valueOf(sorter.day_pieces.get(1).machines[1])
			+String.valueOf(sorter.day_pieces.get(1).machines[2])
			+String.valueOf(sorter.day_pieces.get(1).machines[3])
			+String.valueOf(sorter.day_pieces.get(1).machines[4])
			+String.valueOf(sorter.day_pieces.get(1).machines[5]));
		
		info.daily_pieces2.setText("Client id:"+String.valueOf(sorter.day_pieces.get(2).clientid)
		+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(2).pieceid)
		+ "  Current form:" +String.valueOf(sorter.day_pieces.get(2).curr_form) +
		"  Final Form:"+String.valueOf(sorter.day_pieces.get(2).final_form)
		+ "  Array:"+String.valueOf(sorter.day_pieces.get(2).machines[0])
		+String.valueOf(sorter.day_pieces.get(2).machines[1])
		+String.valueOf(sorter.day_pieces.get(2).machines[2])
		+String.valueOf(sorter.day_pieces.get(2).machines[3])
		+String.valueOf(sorter.day_pieces.get(2).machines[4])
		+String.valueOf(sorter.day_pieces.get(2).machines[5]));
		
		info.daily_pieces3.setText("Client id:"+String.valueOf(sorter.day_pieces.get(3).clientid)
		+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(3).pieceid)
		+ "  Current form:" +String.valueOf(sorter.day_pieces.get(3).curr_form) +
		"  Final Form:"+String.valueOf(sorter.day_pieces.get(3).final_form) 
		+ "  Array:"+String.valueOf(sorter.day_pieces.get(3).machines[0])
		+String.valueOf(sorter.day_pieces.get(3).machines[1])
		+String.valueOf(sorter.day_pieces.get(3).machines[2])
		+String.valueOf(sorter.day_pieces.get(3).machines[3])
		+String.valueOf(sorter.day_pieces.get(3).machines[4])
		+String.valueOf(sorter.day_pieces.get(3).machines[5]));
		
		info.daily_pieces4.setText("Client id:"+String.valueOf(sorter.day_pieces.get(4).clientid)
		+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(4).pieceid)
		+ "  Current form:" +String.valueOf(sorter.day_pieces.get(4).curr_form) +
		"  Final Form:"+String.valueOf(sorter.day_pieces.get(4).final_form) 
		+ "  Array:"+String.valueOf(sorter.day_pieces.get(4).machines[0])
		+String.valueOf(sorter.day_pieces.get(4).machines[1])
		+String.valueOf(sorter.day_pieces.get(4).machines[2])
		+String.valueOf(sorter.day_pieces.get(4).machines[3])
		+String.valueOf(sorter.day_pieces.get(4).machines[4])
		+String.valueOf(sorter.day_pieces.get(4).machines[5]));
		
		info.daily_pieces5.setText("Client id:"+String.valueOf(sorter.day_pieces.get(5).clientid)
		+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(5).pieceid)
		+ "  Current form:" +String.valueOf(sorter.day_pieces.get(5).curr_form) +
		"  Final Form:"+String.valueOf(sorter.day_pieces.get(5).final_form) 
		+ "  Array:"+String.valueOf(sorter.day_pieces.get(5).machines[0])
		+String.valueOf(sorter.day_pieces.get(5).machines[1])
		+String.valueOf(sorter.day_pieces.get(5).machines[2])
		+String.valueOf(sorter.day_pieces.get(5).machines[3])
		+String.valueOf(sorter.day_pieces.get(5).machines[4])
		+String.valueOf(sorter.day_pieces.get(5).machines[5]));
		
		info.daily_pieces6.setText("Client id:"+String.valueOf(sorter.day_pieces.get(6).clientid)
		+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(6).pieceid)
		+ "  Current form:" +String.valueOf(sorter.day_pieces.get(6).curr_form) +
		"  Final Form:"+String.valueOf(sorter.day_pieces.get(6).final_form)
		+ "  Array:"+String.valueOf(sorter.day_pieces.get(6).machines[0])
		+String.valueOf(sorter.day_pieces.get(6).machines[1])
		+String.valueOf(sorter.day_pieces.get(6).machines[2])
		+String.valueOf(sorter.day_pieces.get(6).machines[3])
		+String.valueOf(sorter.day_pieces.get(6).machines[4])
		+String.valueOf(sorter.day_pieces.get(6).machines[5]));
		
		info.daily_pieces7.setText("Client id:"+String.valueOf(sorter.day_pieces.get(7).clientid)
		+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(7).pieceid)
		+ "  Current form:" +String.valueOf(sorter.day_pieces.get(7).curr_form) +
		"  Final Form:"+String.valueOf(sorter.day_pieces.get(7).final_form) 
		+ "  Array:"+String.valueOf(sorter.day_pieces.get(7).machines[0])
		+String.valueOf(sorter.day_pieces.get(7).machines[1])
		+String.valueOf(sorter.day_pieces.get(7).machines[2])
		+String.valueOf(sorter.day_pieces.get(7).machines[3])
		+String.valueOf(sorter.day_pieces.get(7).machines[4])
		+String.valueOf(sorter.day_pieces.get(7).machines[5]));
		
		info.daily_pieces8.setText("Client id:"+String.valueOf(sorter.day_pieces.get(8).clientid)
		+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(8).pieceid)
		+ "  Current form:" +String.valueOf(sorter.day_pieces.get(8).curr_form) +
		"  Final Form:"+String.valueOf(sorter.day_pieces.get(8).final_form)
		+ "  Array:"+String.valueOf(sorter.day_pieces.get(8).machines[0])
		+String.valueOf(sorter.day_pieces.get(8).machines[1])
		+String.valueOf(sorter.day_pieces.get(8).machines[2])
		+String.valueOf(sorter.day_pieces.get(8).machines[3])
		+String.valueOf(sorter.day_pieces.get(8).machines[4])
		+String.valueOf(sorter.day_pieces.get(8).machines[5]));
		
		info.daily_pieces9.setText("Client id:"+String.valueOf(sorter.day_pieces.get(9).clientid)
		+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(9).pieceid)
		+ "  Current form:" +String.valueOf(sorter.day_pieces.get(9).curr_form) +
		"  Final Form:"+String.valueOf(sorter.day_pieces.get(9).final_form) 
		+ "  Array:"+String.valueOf(sorter.day_pieces.get(9).machines[0])
		+String.valueOf(sorter.day_pieces.get(9).machines[1])
		+String.valueOf(sorter.day_pieces.get(9).machines[2])
		+String.valueOf(sorter.day_pieces.get(9).machines[3])
		+String.valueOf(sorter.day_pieces.get(9).machines[4])
		+String.valueOf(sorter.day_pieces.get(9).machines[5]));
		
		info.daily_pieces10.setText("Client id:"+String.valueOf(sorter.day_pieces.get(10).clientid)
		+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(10).pieceid)
		+ "  Current form:" +String.valueOf(sorter.day_pieces.get(10).curr_form) +
		"  Final Form:"+String.valueOf(sorter.day_pieces.get(10).final_form)
		+ "  Array:"+String.valueOf(sorter.day_pieces.get(10).machines[0])
		+String.valueOf(sorter.day_pieces.get(10).machines[1])
		+String.valueOf(sorter.day_pieces.get(10).machines[2])
		+String.valueOf(sorter.day_pieces.get(10).machines[3])
		+String.valueOf(sorter.day_pieces.get(10).machines[4])
		+String.valueOf(sorter.day_pieces.get(10).machines[5]));
		
		info.daily_pieces11.setText("Client id:"+String.valueOf(sorter.day_pieces.get(11).clientid)
		+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(11).pieceid)
		+ "  Current form:" +String.valueOf(sorter.day_pieces.get(11).curr_form) +
		"  Final Form:"+String.valueOf(sorter.day_pieces.get(11).final_form) 
		+ "  Array:"+String.valueOf(sorter.day_pieces.get(11).machines[0])
		+String.valueOf(sorter.day_pieces.get(11).machines[1])
		+String.valueOf(sorter.day_pieces.get(11).machines[2])
		+String.valueOf(sorter.day_pieces.get(11).machines[3])
		+String.valueOf(sorter.day_pieces.get(11).machines[4])
		+String.valueOf(sorter.day_pieces.get(11).machines[5]));
		
	}
}


class UI extends JFrame{
	
	JLabel daily_pieces1 =new JLabel();JLabel daily_pieces2 =new JLabel();JLabel daily_pieces3 =new JLabel();
	JLabel daily_pieces4 =new JLabel();	JLabel daily_pieces5 =new JLabel();	JLabel daily_pieces6 =new JLabel();
	JLabel daily_pieces7 =new JLabel();	JLabel daily_pieces8 =new JLabel();	JLabel daily_pieces9 =new JLabel();
	JLabel daily_pieces10 =new JLabel();JLabel daily_pieces11 =new JLabel();
	public UI(){ 
		setTitle("User Interface for Daily Information");
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setLayout(null);
		setVisible(true);
		
		
		daily_pieces1.setBounds(10, 10, 400, 20);
		daily_pieces1.setVisible(true);	
		this.add(daily_pieces1);
		
		daily_pieces2.setBounds(10, 30, 400,20);
		daily_pieces2.setVisible(true);	
		this.add(daily_pieces2);
		
		daily_pieces3.setBounds(10, 50, 400,20);
		daily_pieces3.setVisible(true);	
		this.add(daily_pieces3);
		
		daily_pieces4.setBounds(10, 70, 400,20);
		daily_pieces4.setVisible(true);	
		this.add(daily_pieces4);
		
		daily_pieces5.setBounds(10, 90, 400,20);
		daily_pieces5.setVisible(true);	
		this.add(daily_pieces5);

		daily_pieces6.setBounds(10, 110, 400,20);
		daily_pieces6.setVisible(true);	
		this.add(daily_pieces6);
		
		daily_pieces7.setBounds(10, 130, 400,20);
		daily_pieces7.setVisible(true);	
		this.add(daily_pieces7);

		daily_pieces8.setBounds(10, 150, 400,20);
		daily_pieces8.setVisible(true);	
		this.add(daily_pieces8);

		daily_pieces9.setBounds(10, 170, 400,20);
		daily_pieces9.setVisible(true);	
		this.add(daily_pieces9);

		daily_pieces10.setBounds(10, 190, 400,20);
		daily_pieces10.setVisible(true);	
		this.add(daily_pieces10);

		daily_pieces11.setBounds(10,190, 400,20);
		daily_pieces11.setVisible(true);	
		this.add(daily_pieces11);
		
	}
}


public class sorter {
    
    public static warehouse w1;
    public static ArrayList<Machine> machines;
    public static ArrayList<Piece> day_pieces;
    public static int warning_start_day=0;
    public static int nr_pieces=0;
    public static int nr_finished=0;
    
	public static void main(String[] args) throws UaException, InterruptedException, ExecutionException {
	
//		MyThread data_analisys=new MyThread();
//		data_analisys.statistics();
//		
//		while (true) {
//			warning_start_day=App.check_ToD();
//			
//			if(warning_start_day==1) {
//				nr_pieces=0;
//				Database.update_stats_EoD(day_pieces);
//				day_pieces=Database.getpieces();
//				for(int j=0;j<day_pieces.size();j++) {
//		        	if(day_pieces.get(j).final_form!=0) nr_pieces++;
//		        }
//				day_pieces=decide_mach( day_pieces);
//				
//				warning_start_day=0;
//			}
//			
//			for(int j=0;j<day_pieces.size();j++) {
//	        	if(day_pieces.get(j).finished==1) nr_finished++;
//	        }
//			nr_finished=0;
//		}
		
		day_pieces=Database.getpieces();
		print_daypieces(day_pieces);
		day_pieces=decide_mach( day_pieces);
		
		
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
		
private static void print_daypieces(ArrayList<Piece> day_pieces2) {
	int i,j;
	for(j=0;j<day_pieces.size();j++) {
		System.out.print("day piece "+day_pieces.get(j).pieceid+":   order_id:"+day_pieces.get(j).orderid+"   priority:"
				+day_pieces.get(j).priority+"   final_form:"+day_pieces.get(j).final_form
				+"   curr_form:"+day_pieces.get(j).curr_form+ "   machines:");
		for(i=0;i<day_pieces.get(j).machines.length;i++)	System.out.print(day_pieces.get(j).machines[i]);		
		System.out.print("\n");
	}

}


private static ArrayList<Piece> decide_mach(ArrayList<Piece> day_pieces) {
	
	short[] dock= {0,0,0};
	short[] a={0,0,0,0,0,0};
	
	for(int j=0;j<day_pieces.size();j++) {
		for(int i=0;i<day_pieces.get(j).machines.length;i++) day_pieces.get(j).machines[i]=0;		
	}
	
	for(int j=0;j<day_pieces.size();j++) {
		
		if(day_pieces.get(j).priority==0) {day_pieces.get(j).machines=a ;} 
		else if(day_pieces.get(j).priority!=0){
			
			day_pieces.get(j).machines[1]=day_pieces.get(j).curr_form;	
			day_pieces.get(j).machines[0]=day_pieces.get(j).pieceid;	
			day_pieces.get(j).start=Instant.now();
			if(day_pieces.get(j).final_form==3) {
				day_pieces.get(j).machines[2]=2;	
			}
			
			else if(day_pieces.get(j).final_form==4) {
				day_pieces.get(j).machines[2]=3;	
			}
			
			else if(day_pieces.get(j).final_form==5) {
				day_pieces.get(j).machines[2]=4;	
			}
			
			else if(day_pieces.get(j).final_form==6) {
				if(w1.p2>0) {
					day_pieces.get(j).machines[2]=1;
					day_pieces.get(j).curr_form=2;
					day_pieces.get(j).machines[0]=day_pieces.get(j).curr_form;					
				}
				else {
					day_pieces.get(j).machines[2]=2;
					day_pieces.get(j).machines[3]=1;	
				}
			}
			
			else if(day_pieces.get(j).final_form==7) {
				day_pieces.get(j).machines[2]=3;
				day_pieces.get(j).machines[3]=4;	
			}
			
			else if(day_pieces.get(j).final_form==8) {
				day_pieces.get(j).machines[2]=1;
				day_pieces.get(j).machines[3]=3;	
			}
			
			else if(day_pieces.get(j).final_form==9) {
				day_pieces.get(j).machines[2]=3;	
				day_pieces.get(j).machines[3]=4;	
				day_pieces.get(j).machines[4]=3;	
			}

			if(day_pieces.get(j).orderid==day_pieces.get(0).orderid) {
				if(dock[0]<4 ) {day_pieces.get(j).machines[5]=1; dock[0]++;}
				else if(dock[0]==4 && dock[1]<4 ) {day_pieces.get(j).machines[5]=2; dock[1]++;}
				else if(dock[1]==4 && dock[2]<4) {day_pieces.get(j).machines[5]=3; dock[2]++;}
		
			}
			else if(day_pieces.get(j).orderid!=day_pieces.get(0).orderid && day_pieces.get(j).orderid!=0) {
				if(dock[0]<5) {day_pieces.get(j).machines[5]=1; dock[0]++;}
				else if(dock[0]>5 ) {day_pieces.get(j).machines[5]=2; dock[1]++;}
			}
		}
		
		for(int i=0;i<day_pieces.get(j).machines.length;i++)	System.out.print(day_pieces.get(j).machines[i]);
			System.out.println();
	}
	
	for(int j=0;j<day_pieces.size();j++) {
		System.out.print("day piece "+(j+1)+":   order_id:"+day_pieces.get(j).orderid+"   priority:"
				+day_pieces.get(j).priority+"   final_form:"+day_pieces.get(j).final_form
				+"   curr_form:"+day_pieces.get(j).curr_form+ "   machines:");
		for(int i=0;i<day_pieces.get(j).machines.length;i++)	System.out.print(day_pieces.get(j).machines[i]);		
		System.out.print("\n");
	}
	
	return day_pieces;
	
}
}
