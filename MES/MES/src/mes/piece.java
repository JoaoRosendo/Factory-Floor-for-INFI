package mes;

public class piece {
	
	int orderid;
	
	int[] machines; // tem em cada posi��o a pr�xima m�quinas que vai utilizar
	int priority;
	int final_form;
	int curr_form;
	
	public piece(int orderid, int[] machines, int priority, int final_form, int curr_form) {
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
