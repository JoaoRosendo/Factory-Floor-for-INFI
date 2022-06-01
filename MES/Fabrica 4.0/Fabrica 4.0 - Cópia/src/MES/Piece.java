package MES;

import java.time.Instant;

public class Piece {
    
	short orderid;
	short pieceid;
	short[] machines; // tem em cada posição a próxima máquinas que vai utilizar
	short priority;
	short final_form;
	short curr_form=1;
	short finished=0; //1 if finished
	Instant start;
	double cost;
	
	
	
	public Piece(short orderid, short pieceid, short[] machines, short priority, short final_form, short curr_form,
			short finished, Instant start, double cost) {
		super();
		this.orderid = orderid;
		this.pieceid = pieceid;
		this.machines = machines;
		this.priority = priority;
		this.final_form = final_form;
		this.curr_form = curr_form;
		this.finished = finished;
		this.start = start;

	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public short getFinished() {
		return finished;
	}

	public void setFinished(short finished) {
		this.finished = finished;
	}

	public Instant getStart() {
		return start;
	}

	public void setStart(Instant start) {
		this.start = start;
	}

	
	public short getPieceid() {
		return pieceid;
	}

	public void setPieceid(short pieceid) {
		this.pieceid = pieceid;
	}

	public short getOrderid() {
		return orderid;
	}
	public void setOrderid(short orderid) {
		this.orderid = orderid;
	}
	public short[] getMachines() {
		return machines;
	}
	public void setMachines(short[] machines) {
		this.machines = machines;
	}
	public short getPriority() {
		return priority;
	}
	public void setPriority(short priority) {
		this.priority = priority;
	}
	public short getFinal_form() {
		return final_form;
	}
	public short getCurr_form() {
		return curr_form;
	}
	public void setCurr_form(short curr_form) {
		this.curr_form = curr_form;
	}
	public void setFinal_form(short final_form) {
		this.final_form = final_form;
	}
}
