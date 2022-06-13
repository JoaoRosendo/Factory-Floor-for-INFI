package MES;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.eclipse.milo.opcua.stack.core.UaException;

public class MyThread implements Runnable{
	private final Thread t;
	UI info=new UI();
	static volatile ArrayList<Machine> machines=new ArrayList<>();
	public MyThread() {
		t= new Thread(this);
	}
	@Override
	public void run() {
		int nr_pieces=0;
		short[] a= {0,0,0,0,0,0,0,0,0};
		int nr_finished=0;
		Machine p =null;
		for(int i=0;i<7;i++) {
			p=new Machine((short)i, (short)0, (short)0, a, (short)0);
			machines.add(p);
		}
		while(true) {
			nr_pieces=0;
			nr_finished=0;
			for(int j=0;j<sorter.day_pieces.size();j++) {
				
				if(sorter.day_pieces.get(j).getFinal_form()!=0) nr_pieces++;
			}
			for(int j=0;j<sorter.day_pieces.size();j++) {
				 if(sorter.day_pieces.get(j).getFinished()==1) nr_finished++;
			}
			
			try {
				machines=App.mach_stats(machines);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (ExecutionException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
				
			
			try {
				sorter.day_pieces=App.check_pieces(sorter.day_pieces);
				
			} catch (UaException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
			
			update_gui(info, nr_pieces, nr_finished,machines);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	
private int calculate_optime(Object machine) {
   
   
   	for(int i=0;i<sorter.day_pieces.size();i++) {
   		if(sorter.day_pieces.get(i).getFinal_form()==0) {
   			
   		}
   	}
	return 0;
	}
	void start() {
		t.start();
	}
	

	private void update_gui(UI info, int nr_pieces, int nr_finished, ArrayList<Machine> machines2) {
		info.finished.setText("Nr pieces: "+nr_pieces+"   Nr finished: "+ nr_finished );
		
		info.mac1.setText("Machine 1:    P1:"+machines2.get(0).op_pieces[0]+"   P2:"+machines2.get(0).op_pieces[1]+"   P3:"+machines2.get(0).op_pieces[2]+
				"   P4:"+machines2.get(0).op_pieces[3]+"   P5:"+machines2.get(0).op_pieces[4]+"   P6:"+machines2.get(0).op_pieces[5]+
				"   P7:"+machines2.get(0).op_pieces[6]+"   P8:"+machines2.get(0).op_pieces[7]+"   P9:"+machines2.get(0).op_pieces[8]
				+"   Total="	+machines2.get(0).getPieces_total()	);
		info.mac2.setText("Machine 2:    P1:"+machines2.get(1).op_pieces[0]+"   P2:"+machines2.get(1).op_pieces[1]+"   P3:"+machines2.get(1).op_pieces[2]+
				"   P4:"+machines2.get(1).op_pieces[3]+"   P5:"+machines2.get(1).op_pieces[4]+"   P6:"+machines2.get(1).op_pieces[5]+
				"   P7:"+machines2.get(1).op_pieces[6]+"   P8:"+machines2.get(1).op_pieces[7]+"   P9:"+machines2.get(1).op_pieces[8]
						+"   Total="	+machines2.get(1).getPieces_total());
			
		info.mac3.setText("Machine 3:    P1:"+machines2.get(2).op_pieces[0]+"   P2:"+machines2.get(2).op_pieces[1]+"   P3:"+machines2.get(2).op_pieces[2]+
				"   P4:"+machines2.get(2).op_pieces[3]+"   P5:"+machines2.get(2).op_pieces[4]+"   P6:"+machines2.get(2).op_pieces[5]+
				"   P7:"+machines2.get(2).op_pieces[6]+"   P8:"+machines2.get(2).op_pieces[7]+"   P9:"+machines2.get(2).op_pieces[8]
						+"   Total="	+machines2.get(2).getPieces_total());
		info.mac4.setText("Machine 4:    P1:"+machines2.get(3).op_pieces[0]+"   P2:"+machines2.get(3).op_pieces[1]+"   P3:"+machines2.get(3).op_pieces[2]+
				"   P4:"+machines2.get(3).op_pieces[3]+"   P5:"+machines2.get(3).op_pieces[4]+"   P6:"+machines2.get(3).op_pieces[5]+
				"   P7:"+machines2.get(3).op_pieces[6]+"   P8:"+machines2.get(3).op_pieces[7]+"   P9:"+machines2.get(3).op_pieces[8]
						+"   Total="	+machines2.get(3).getPieces_total());
		info.mac5.setText("Machine 5:    P1:"+machines2.get(4).op_pieces[0]+"   P2:"+machines2.get(4).op_pieces[1]+"   P3:"+machines2.get(4).op_pieces[2]+
				"   P4:"+machines2.get(4).op_pieces[3]+"   P5:"+machines2.get(4).op_pieces[4]+"   P6:"+machines2.get(4).op_pieces[5]+
				"   P7:"+machines2.get(4).op_pieces[6]+"   P8:"+machines2.get(4).op_pieces[7]+"   P9:"+machines2.get(4).op_pieces[8]
						+"   Total="	+machines2.get(4).getPieces_total());
		info.mac6.setText("Machine 6:    P1:"+machines2.get(5).op_pieces[0]+"   P2:"+machines2.get(5).op_pieces[1]+"   P3:"+machines2.get(5).op_pieces[2]+
				"   P4:"+machines2.get(5).op_pieces[3]+"   P5:"+machines2.get(5).op_pieces[4]+"   P6:"+machines2.get(5).op_pieces[5]+
				"   P7:"+machines2.get(5).op_pieces[6]+"   P8:"+machines2.get(5).op_pieces[7]+"   P9:"+machines2.get(5).op_pieces[8]
						+"   Total="	+machines2.get(5).getPieces_total());
				
		
		
		info.daily_pieces0.setText("Client id:"+String.valueOf(sorter.day_pieces.get(0).getClientid())
		+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(0).getPieceid())
		+ "  Current form:" +String.valueOf(sorter.day_pieces.get(0).getCurr_form())
		+ "  Final Form:"+String.valueOf(sorter.day_pieces.get(0).getFinal_form()) 
		+ "  Array:"+String.valueOf(sorter.day_pieces.get(0).machines[0])
		+String.valueOf(sorter.day_pieces.get(0).machines[1])
		+String.valueOf(sorter.day_pieces.get(0).machines[2])
		+String.valueOf(sorter.day_pieces.get(0).machines[3])
		+String.valueOf(sorter.day_pieces.get(0).machines[4])
		+String.valueOf(sorter.day_pieces.get(0).machines[5]));
		
		info.daily_pieces1.setText("Client id:"+String.valueOf(sorter.day_pieces.get(1).getClientid())
			+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(1).getPieceid())
			+ "  Current form:" +String.valueOf(sorter.day_pieces.get(1).getCurr_form())
			+ "  Final Form:"+String.valueOf(sorter.day_pieces.get(1).getFinal_form()) 
			+ "  Array:"+String.valueOf(sorter.day_pieces.get(1).machines[0])
			+String.valueOf(sorter.day_pieces.get(1).machines[1])
			+String.valueOf(sorter.day_pieces.get(1).machines[2])
			+String.valueOf(sorter.day_pieces.get(1).machines[3])
			+String.valueOf(sorter.day_pieces.get(1).machines[4])
			+String.valueOf(sorter.day_pieces.get(1).machines[5]));
		
		info.daily_pieces2.setText("Client id:"+String.valueOf(sorter.day_pieces.get(2).getClientid())
		+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(2).getPieceid())
		+ "  Current form:" +String.valueOf(sorter.day_pieces.get(2).getCurr_form()) +
		"  Final Form:"+String.valueOf(sorter.day_pieces.get(2).getFinal_form())
		+ "  Array:"+String.valueOf(sorter.day_pieces.get(2).machines[0])
		+String.valueOf(sorter.day_pieces.get(2).machines[1])
		+String.valueOf(sorter.day_pieces.get(2).machines[2])
		+String.valueOf(sorter.day_pieces.get(2).machines[3])
		+String.valueOf(sorter.day_pieces.get(2).machines[4])
		+String.valueOf(sorter.day_pieces.get(2).machines[5]));
		
		info.daily_pieces3.setText("Client id:"+String.valueOf(sorter.day_pieces.get(3).getClientid())
		+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(3).getPieceid())
		+ "  Current form:" +String.valueOf(sorter.day_pieces.get(3).getCurr_form()) +
		"  Final Form:"+String.valueOf(sorter.day_pieces.get(3).getFinal_form()) 
		+ "  Array:"+String.valueOf(sorter.day_pieces.get(3).machines[0])
		+String.valueOf(sorter.day_pieces.get(3).machines[1])
		+String.valueOf(sorter.day_pieces.get(3).machines[2])
		+String.valueOf(sorter.day_pieces.get(3).machines[3])
		+String.valueOf(sorter.day_pieces.get(3).machines[4])
		+String.valueOf(sorter.day_pieces.get(3).machines[5]));
		
		info.daily_pieces4.setText("Client id:"+String.valueOf(sorter.day_pieces.get(4).getClientid())
		+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(4).getPieceid())
		+ "  Current form:" +String.valueOf(sorter.day_pieces.get(4).getCurr_form()) +
		"  Final Form:"+String.valueOf(sorter.day_pieces.get(4).getFinal_form()) 
		+ "  Array:"+String.valueOf(sorter.day_pieces.get(4).machines[0])
		+String.valueOf(sorter.day_pieces.get(4).machines[1])
		+String.valueOf(sorter.day_pieces.get(4).machines[2])
		+String.valueOf(sorter.day_pieces.get(4).machines[3])
		+String.valueOf(sorter.day_pieces.get(4).machines[4])
		+String.valueOf(sorter.day_pieces.get(4).machines[5]));
		
		info.daily_pieces5.setText("Client id:"+String.valueOf(sorter.day_pieces.get(5).getClientid())
		+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(5).getPieceid())
		+ "  Current form:" +String.valueOf(sorter.day_pieces.get(5).getCurr_form()) +
		"  Final Form:"+String.valueOf(sorter.day_pieces.get(5).getFinal_form()) 
		+ "  Array:"+String.valueOf(sorter.day_pieces.get(5).machines[0])
		+String.valueOf(sorter.day_pieces.get(5).machines[1])
		+String.valueOf(sorter.day_pieces.get(5).machines[2])
		+String.valueOf(sorter.day_pieces.get(5).machines[3])
		+String.valueOf(sorter.day_pieces.get(5).machines[4])
		+String.valueOf(sorter.day_pieces.get(5).machines[5]));
		
		info.daily_pieces6.setText("Client id:"+String.valueOf(sorter.day_pieces.get(6).getClientid())
		+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(6).getPieceid())
		+ "  Current form:" +String.valueOf(sorter.day_pieces.get(6).getCurr_form()) +
		"  Final Form:"+String.valueOf(sorter.day_pieces.get(6).getFinal_form())
		+ "  Array:"+String.valueOf(sorter.day_pieces.get(6).machines[0])
		+String.valueOf(sorter.day_pieces.get(6).machines[1])
		+String.valueOf(sorter.day_pieces.get(6).machines[2])
		+String.valueOf(sorter.day_pieces.get(6).machines[3])
		+String.valueOf(sorter.day_pieces.get(6).machines[4])
		+String.valueOf(sorter.day_pieces.get(6).machines[5]));
		
		info.daily_pieces7.setText("Client id:"+String.valueOf(sorter.day_pieces.get(7).getClientid())
		+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(7).getPieceid())
		+ "  Current form:" +String.valueOf(sorter.day_pieces.get(7).getCurr_form()) +
		"  Final Form:"+String.valueOf(sorter.day_pieces.get(7).getFinal_form()) 
		+ "  Array:"+String.valueOf(sorter.day_pieces.get(7).machines[0])
		+String.valueOf(sorter.day_pieces.get(7).machines[1])
		+String.valueOf(sorter.day_pieces.get(7).machines[2])
		+String.valueOf(sorter.day_pieces.get(7).machines[3])
		+String.valueOf(sorter.day_pieces.get(7).machines[4])
		+String.valueOf(sorter.day_pieces.get(7).machines[5]));
		
		info.daily_pieces8.setText("Client id:"+String.valueOf(sorter.day_pieces.get(8).getClientid())
		+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(8).getPieceid())
		+ "  Current form:" +String.valueOf(sorter.day_pieces.get(8).getCurr_form()) +
		"  Final Form:"+String.valueOf(sorter.day_pieces.get(8).getFinal_form())
		+ "  Array:"+String.valueOf(sorter.day_pieces.get(8).machines[0])
		+String.valueOf(sorter.day_pieces.get(8).machines[1])
		+String.valueOf(sorter.day_pieces.get(8).machines[2])
		+String.valueOf(sorter.day_pieces.get(8).machines[3])
		+String.valueOf(sorter.day_pieces.get(8).machines[4])
		+String.valueOf(sorter.day_pieces.get(8).machines[5]));
		
		info.daily_pieces9.setText("Client id:"+String.valueOf(sorter.day_pieces.get(9).getClientid())
		+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(9).getPieceid())
		+ "  Current form:" +String.valueOf(sorter.day_pieces.get(9).getCurr_form()) +
		"  Final Form:"+String.valueOf(sorter.day_pieces.get(9).getFinal_form()) 
		+ "  Array:"+String.valueOf(sorter.day_pieces.get(9).machines[0])
		+String.valueOf(sorter.day_pieces.get(9).machines[1])
		+String.valueOf(sorter.day_pieces.get(9).machines[2])
		+String.valueOf(sorter.day_pieces.get(9).machines[3])
		+String.valueOf(sorter.day_pieces.get(9).machines[4])
		+String.valueOf(sorter.day_pieces.get(9).machines[5]));
		
		info.daily_pieces10.setText("Client id:"+String.valueOf(sorter.day_pieces.get(10).getClientid())
		+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(10).getPieceid())
		+ "  Current form:" +String.valueOf(sorter.day_pieces.get(10).getCurr_form()) +
		"  Final Form:"+String.valueOf(sorter.day_pieces.get(10).getFinal_form())
		+ "  Array:"+String.valueOf(sorter.day_pieces.get(10).machines[0])
		+String.valueOf(sorter.day_pieces.get(10).machines[1])
		+String.valueOf(sorter.day_pieces.get(10).machines[2])
		+String.valueOf(sorter.day_pieces.get(10).machines[3])
		+String.valueOf(sorter.day_pieces.get(10).machines[4])
		+String.valueOf(sorter.day_pieces.get(10).machines[5]));
		
		info.daily_pieces11.setText("Client id:"+String.valueOf(sorter.day_pieces.get(11).getClientid())
		+ "  Piece Id:" +String.valueOf(sorter.day_pieces.get(11).getPieceid())
		+ "  Current form:" +String.valueOf(sorter.day_pieces.get(11).getCurr_form()) +
		"  Final Form:"+String.valueOf(sorter.day_pieces.get(11).getFinal_form()) 
		+ "  Array:"+String.valueOf(sorter.day_pieces.get(11).machines[0])
		+String.valueOf(sorter.day_pieces.get(11).machines[1])
		+String.valueOf(sorter.day_pieces.get(11).machines[2])
		+String.valueOf(sorter.day_pieces.get(11).machines[3])
		+String.valueOf(sorter.day_pieces.get(11).machines[4])
		+String.valueOf(sorter.day_pieces.get(11).machines[5]));
		
	}
}
