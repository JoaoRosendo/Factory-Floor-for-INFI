package erp;

public class order {
	private int id;
    private int number;
    private String client;
    private int workpiece;
    private int qty;
    private int dueDate;
    private int latePen;
    private int earlyPen;
  	
    public int getId() {
        return id;
    }
    public void setId(int n) {
        this.id = n;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int n) {
        this.number = n;
    }   
  	public String getClient() {
        return client;
    }
    public void setClient(String client) {
        this.client = client;
    }
    public int getWorkpiece() {
        return workpiece;
    }
    public void setWorkpiece(int workpiece) {
        this.workpiece = workpiece;
    }
    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
    public int getDueDate() {
        return dueDate;
    }
    public void setDueDate(int dueDate) {
        this.dueDate = dueDate;
    }
    public int getLatePenalty() {
        return latePen;
    }
    public void setLatePenalty(int pen) {
        this.latePen = pen;
    }
    public int getEarlyPenalty() {
        return earlyPen;
    }
    public void setEarlyPenalty(int pen) {
        this.earlyPen = pen;
    }
    
}

