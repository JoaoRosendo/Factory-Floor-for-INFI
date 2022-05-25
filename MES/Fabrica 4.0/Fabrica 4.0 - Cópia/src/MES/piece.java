package MES;

public class piece {
    
	short orderid;
	
	short[] machines; // tem em cada posição a próxima máquinas que vai utilizar
	short priority;
	short final_form;
	short curr_form;
	
	public piece(short orderid, short[] machines, short priority, short final_form, short curr_form) {
		super();
		this.orderid = orderid;
		this.machines = machines;
		this.priority = priority;
		this.final_form = final_form;
		this.curr_form = curr_form;
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
