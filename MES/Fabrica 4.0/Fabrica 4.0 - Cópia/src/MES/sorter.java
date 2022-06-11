package MES;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import org.eclipse.milo.opcua.stack.core.UaException;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;




class UI extends JFrame{
	JLabel daily_pieces0 =new JLabel();
	JLabel daily_pieces1 =new JLabel();JLabel daily_pieces2 =new JLabel();JLabel daily_pieces3 =new JLabel();
	JLabel daily_pieces4 =new JLabel();	JLabel daily_pieces5 =new JLabel();	JLabel daily_pieces6 =new JLabel();
	JLabel daily_pieces7 =new JLabel();	JLabel daily_pieces8 =new JLabel();	JLabel daily_pieces9 =new JLabel();
	JLabel daily_pieces10 =new JLabel();JLabel daily_pieces11 =new JLabel();
	
	JLabel curr_op =new JLabel();
	JLabel running =new JLabel();
	
	public UI(){ 
		setTitle("User Interface for Daily Information");
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		
		daily_pieces0.setBounds(10, 10, 400, 20);
		daily_pieces0.setVisible(true);	
		this.add(daily_pieces0);
		
		daily_pieces1.setBounds(10, 30, 400, 20);
		daily_pieces1.setVisible(true);	
		this.add(daily_pieces1);
		
		daily_pieces2.setBounds(10, 50, 400,20);
		daily_pieces2.setVisible(true);	
		this.add(daily_pieces2);
		
		daily_pieces3.setBounds(10, 70, 400,20);
		daily_pieces3.setVisible(true);	
		this.add(daily_pieces3);
		
		daily_pieces4.setBounds(10, 90, 400,20);
		daily_pieces4.setVisible(true);	
		this.add(daily_pieces4);
		
		daily_pieces5.setBounds(10, 110, 400,20);
		daily_pieces5.setVisible(true);	
		this.add(daily_pieces5);

		daily_pieces6.setBounds(10, 130, 400,20);
		daily_pieces6.setVisible(true);	
		this.add(daily_pieces6);
		
		daily_pieces7.setBounds(10, 150, 400,20);
		daily_pieces7.setVisible(true);	
		this.add(daily_pieces7);

		daily_pieces8.setBounds(10, 170, 400,20);
		daily_pieces8.setVisible(true);	
		this.add(daily_pieces8);

		daily_pieces9.setBounds(10, 190, 400,20);
		daily_pieces9.setVisible(true);	
		this.add(daily_pieces9);

		daily_pieces10.setBounds(10, 210, 400,20);
		daily_pieces10.setVisible(true);	
		this.add(daily_pieces10);

		daily_pieces11.setBounds(10,230, 400,20);
		daily_pieces11.setVisible(true);	
		this.add(daily_pieces11);
		
		curr_op.setBounds(500,10, 200,100);
		curr_op.setVisible(true);	
		this.add(curr_op);
		
		running.setBounds(500,50, 200,100);
		running.setVisible(true);	
		this.add(running);
		
	}
}

public class sorter {
	static volatile ArrayList<Piece> day_pieces;
	static volatile warehouse w1 = new warehouse(10, 10);
	static volatile ArrayList<Machine> machines;
	static volatile MyThread data_analisys=new MyThread();
	
	public static void main(String[] args) throws UaException, InterruptedException, ExecutionException {

		short[] aux = { -1, -1, -1, -1, -1, -1, 0, 0, 0 };
		short[] dock = { 0, 0, 0 };
		int nr_pieces = 0;
		int nr_finished = 0;
		App.start();
		
		
		int start=0;
		while (true) {
			nr_finished=0;
			nr_pieces=0;
			if (start==1) {				
				for(int j=0;j<day_pieces.size();j++) {
			
				if(day_pieces.get(j).final_form!=0) nr_pieces++;
				}
				 for(int j=0;j<day_pieces.size();j++) {
				 if(day_pieces.get(j).finished==1) nr_finished++;
				}
				
				
			}

			 if(nr_finished==nr_pieces) {
				 if(start==1) {
					 nr_pieces=0;
					 data_analisys.info.curr_op.setText("Updating stats on DB");
					 Database.update_stats_EoRequests(day_pieces);	
					 System.out.println("Going into Waiting for new orders");
					 while(App.workpieces_count()!=0){data_analisys.info.curr_op.setText("Waiting for new orders");};
					 data_analisys.info.curr_op.setText("Getting new Orders");
				 }
				 System.out.println("Going into getpieces");
				 day_pieces=Database.getpieces();
				 
				 
				 //print_daypieces(day_pieces);
				 for (int k = 0; k < aux.length; k++) {
					aux[k]=-1;
					
				}
				 for (int j = 0; j < dock.length; j++) {
					dock[j]=0;
				}
				 for (int i = 0; i < 12; i++) {
					 aux=(decide_tools(day_pieces.get(i), w1,dock));
					 day_pieces.get(i).setMachines(aux);
					 day_pieces.get(i).setCurr_form(aux[1]);
					dock[0] = aux[6];
					dock[1] = aux[7];
					dock[2] = aux[8];
					
				}
				 
				if(start==0) {
					data_analisys.start();
				}
				data_analisys.info.curr_op.setText("Sending order to PLC");
				//print_daypieces(day_pieces);
				System.out.println("Going into send_pieces");
				int errors=App.send_pieces(day_pieces);
				if (errors>0)
					System.out.println("Some Pieces coudnt be sent correctly");
				start=1;
			 }
			
		}
		
	}

	private static void print_daypieces(ArrayList<Piece> day_pieces) {
		int i, j;
		for (j = 0; j < day_pieces.size(); j++) {
			System.out.print("day piece " + day_pieces.get(j).pieceid + ":   order_id:" + day_pieces.get(j).orderid
					+ "   Client id:"+ day_pieces.get(j).getClientid()+"   priority:" + day_pieces.get(j).priority + "   final_form:" + day_pieces.get(j).final_form
					+ "   curr_form:" + day_pieces.get(j).curr_form
					+ "   finished:" + day_pieces.get(j).getFinished() 
					+ "   Start_time: "+ (day_pieces.get(j).getStart().toEpochMilli()/1000)
					+ "   machines:");
			for (i = 0; i < day_pieces.get(j).machines.length; i++)
				System.out.print(day_pieces.get(j).machines[i]);
			System.out.print("\n");
		}

	}

	private static short[] decide_tools(Piece p1, warehouse w1, short[] dock) {
		
		short a[] = {-1,-1,-1,-1,-1,-1 };
		short aux[] = { -1, -1, -1, -1, -1, -1, 0, 0, 0 };
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
				aux[1] = 2;
				aux[2] = 2;
			}

			else if (p1.getFinal_form() == 4) {
				aux[1] = 2;
				aux[2] = 3;
			}

			else if (p1.getFinal_form() == 5) {
				aux[1] = 2;
				aux[2] = 4;
			}

			else if (p1.getFinal_form() == 6) {
				if (w1.p1 > 0) {
					aux[2] = 1;
					
				} else {
					aux[1] = 2;
					aux[2] = 2;
					aux[3] = 1;
				}
			}

			else if (p1.getFinal_form() == 7) {
				aux[1] = 2;
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
