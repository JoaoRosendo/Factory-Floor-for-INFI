package mes;

public class piece {
	
	private int orderid;
	private int[] machines; // tem em cada posição a próxima máquinas que vai utilizar
	private int priority;
	private int final_form;
	
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
	public void setFinal_form(int final_form) {
		this.final_form = final_form;
	}

	
	
	public int decide_mach(int[] tools) {
		
		if(piece.this.final_form==6) 
		{	
			if(warehouse.p1>0) {
				for (int i =1; i<6; i++) 
				{
					if(tools[i]==1) {
						piece.this.machines[0]=i;
					}
				}
			}
			else {
				for (int i =1; i<6; i++) 
				{
					if(tools[i]==2) {
						piece.this.machines[0]=i;
					}
					else if(tools[i]==1 && piece.this.machines[0]!=0) {
						piece.this.machines[1]=i;
					}
				}
			}
		
		
		if(piece.this.final_form==9) 
		{
			for (int i =1; i<6; i++) 
			{
				if(tools[i]==3) {
					piece.this.machines[0]=i;
				}
				else if(tools[i]==4 && piece.this.machines[0]!=0) {
					piece.this.machines[1]=i;
				}
				else if(tools[i]==3 && piece.this.machines[1]!=0) {
					piece.this.machines[2]=i;
				}
			}
		}
	}
	
}
