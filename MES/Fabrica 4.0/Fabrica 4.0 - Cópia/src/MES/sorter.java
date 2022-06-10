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
				Thread.sleep(500);
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
		setLayout(null);
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
	static volatile ArrayList<Piece> day_pieces;
	static volatile warehouse w1 = new warehouse(10, 10);
	static volatile ArrayList<Machine> machines;
	
	
	public static void main(String[] args) throws UaException, InterruptedException, ExecutionException {

//		MyThread data_analisys=new MyThread();
//		data_analisys.statistics();
//		
//		while (true) {
//			warning_start_day=App.check_ToD();
//			nr_finished=0;
//			nr_pieces=0;
		// for(int j=0;j<day_pieces.size();j++) {
		// if(day_pieces.get(j).final_form!=0) nr_pieces++;
		// }
//		 for(int j=0;j<day_pieces.size();j++) {
//		 if(day_pieces.get(j).finished==1) nr_finished++;
//		 }

		// if(warning_start_day==1 && nr_finished==nr_pieces) {
		// nr_pieces=0;
		// Database.update_stats_EoRequests(day_pieces);
		// day_pieces=Database.getpieces();
		//
		// day_pieces=decide_mach( day_pieces);
		//
		// warning_start_day=0;
		// }
//			
//			nr_finished=0;
//			nr_pieces=0;
//		}
		App.start();
		short[] aux = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		short[] dock = { 0, 0, 0 };
		int warning_start_day = 0;
		int nr_pieces = 0;
		int nr_finished = 0;
		

		day_pieces = Database.getpieces();
		for(int j=0;j<day_pieces.size();j++) {
        	if(day_pieces.get(j).final_form!=0) nr_pieces++;
        }
		 for(int j=0;j<day_pieces.size();j++) {
			 if(day_pieces.get(j).finished==1) nr_finished++;
		}
		//day_pieces.get(5).setFinal_form((short) 5);
		print_daypieces(day_pieces);
		System.out.println("///////////////////////////------////////////////////////////");
		for (int i = 0; i < 12; i++) {
			 aux=(decide_mach(day_pieces.get(i), w1,dock));
			 day_pieces.get(i).setMachines(aux);
			 day_pieces.get(i).setCurr_form(aux[1]);
			dock[0] = aux[6];
			dock[1] = aux[7];
			dock[2] = aux[8];
			
		}
		print_daypieces(day_pieces);
		App.send_pieces(day_pieces);

//		data_analisys.start();
	}

	private static void print_daypieces(ArrayList<Piece> day_pieces) {
		int i, j;
		for (j = 0; j < day_pieces.size(); j++) {
			System.out.print("day piece " + day_pieces.get(j).pieceid + ":   order_id:" + day_pieces.get(j).orderid
					+ "   priority:" + day_pieces.get(j).priority + "   final_form:" + day_pieces.get(j).final_form
					+ "   curr_form:" + day_pieces.get(j).curr_form + "   machines:");
			for (i = 0; i < day_pieces.get(j).machines.length; i++)
				System.out.print(day_pieces.get(j).machines[i]);
			System.out.print("\n");
		}

	}

	private static short[] decide_mach(Piece p1, warehouse w1, short[] dock) {
		
		short a[] = { 0, 0, 0, 0, 0, 0 };
		short aux[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		aux[6] = dock[0];
		aux[7] = dock[1];
		aux[8] = dock[2];
		
		if (p1.priority == 0) {
			p1.setMachines(a);
			;
		} else if (p1.priority != 0) {
			aux[1] = p1.getCurr_form();
			aux[0] = p1.getPieceid();
			p1.setStart(Instant.now());
			if (p1.getFinal_form() == 3) {
				aux[2] = 2;
			}

			else if (p1.getFinal_form() == 4) {
				aux[2] = 3;
			}

			else if (p1.getFinal_form() == 5) {
				aux[2] = 4;
			}

			else if (p1.getFinal_form() == 6) {
				if (w1.p2 > 0) {
					aux[2] = 1;
					aux[1] = 2;
				} else {
					aux[2] = 2;
					aux[3] = 1;
				}
			}

			else if (p1.getFinal_form() == 7) {
				aux[2] = 3;
				aux[3] = 4;
			}

			else if (p1.getFinal_form() == 8) {
				aux[2] = 1;
				aux[3] = 3;
			}

			else if (p1.getFinal_form() == 9) {
				aux[2] = 3;
				aux[3] = 4;
				aux[4] = 3;
				aux[1] =2;
			}

			if (dock[0] < 4) {
				aux[5] = 1;
				aux[6]++;
			} else if (dock[0] == 4 && dock[1] < 4) {
				aux[5] = 2;
				aux[7]++;
			} else if (dock[1] == 4 && dock[2] < 4) {
				aux[5] = 3;
				aux[8]++;
			}
			
		}
		
		return aux;
	}
}
