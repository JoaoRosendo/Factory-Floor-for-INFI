package MES;

public class piece {
    
    int orderid;
	
	short[] machines; // tem em cada posição a próxima máquinas que vai utilizar
	int priority;
	int final_form;
	int curr_form;
	
	public piece(int orderid, short[] machines, int priority, int final_form, int curr_form) {
		super();
		this.orderid = orderid;
		this.machines = machines;
		this.priority = priority;
		this.final_form = final_form;
		this.curr_form = curr_form;
	}
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public short[] getMachines() {
		return machines;
	}
	public void setMachines(short[] machines) {
		this.machines = machines;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getFinal_form() {
		return final_form;
	}
	public int getCurr_form() {
		return curr_form;
	}
	public void setCurr_form(int curr_form) {
		this.curr_form = curr_form;
	}
	public void setFinal_form(int final_form) {
		this.final_form = final_form;
	}
}
