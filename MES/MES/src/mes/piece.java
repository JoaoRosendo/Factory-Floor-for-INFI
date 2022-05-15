package mes;

public class piece {
	
	static int orderid;
	static int[] machines; // tem em cada posição a próxima máquinas que vai utilizar
	static int priority;
	static int final_form;
	static int curr_form;
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int[] getMachines() {
		return machines;
	}
	public void setMachines(int[] machines) {
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
	public static int getCurr_form() {
		return curr_form;
	}
	public static void setCurr_form(int curr_form) {
		piece.curr_form = curr_form;
	}
	public void setFinal_form(int final_form) {
		this.final_form = final_form;
	}

	
	
	
	
	}
