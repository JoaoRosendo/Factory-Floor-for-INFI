package MES;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.eclipse.milo.opcua.stack.core.UaException;

public class MyThread implements Runnable{
	private final Thread t;
	
	public MyThread() {
		t= new Thread(this);
	}
	@Override
	public void run() {
		UI info=new UI();
		
		while(true) {
			
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
			//update_stats();
			update_gui(info);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	void start() {
		t.start();
	}
	

	private void update_gui(UI info) {
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
