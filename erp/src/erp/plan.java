package erp;

public class plan {
	private int id;
	private int number;
    private String client;
	private int qty;
    private int finalForm;
    private int startingForm;
    private int dueDate;
    private int plcmntDate;
    private int startDate;
    private int cost;
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getFinalForm() {
		return finalForm;
	}
	public void setFinalForm(int finalForm) {
		this.finalForm = finalForm;
	}
	public int getStartingForm() {
		return startingForm;
	}
	public void setStartingForm(int startingForm) {
		this.startingForm = startingForm;
	}
	public int getDueDate() {
		return dueDate;
	}
	public void setDueDate(int dueDate) {
		this.dueDate = dueDate;
	}
	public int getStartDate() {
		return startDate;
	}
	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getPlcmntDate() {
		return plcmntDate;
	}
	public void setPlcmntDate(int plcmntDate) {
		this.plcmntDate = plcmntDate;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
	public int set_start_piece(int final_form) {
		plan order = new plan();
    	
    	if(final_form==1 || final_form==6 || final_form==8) {
			order.setStartingForm(1);
			return 1;
		} else {
			order.setStartingForm(2);
			return 2;
		}
    }
}
