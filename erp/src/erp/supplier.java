package erp;

public class supplier {
	private int id;
    private String supplier;
	private int piece;
    private int minQty;
    private int price;
    private int dlvrTime;
    private int qty;
    private int dlvrDate;
    
    public int getId() {
        return id;
    }
    public void setId(int n) {
        this.id = n;
    }
    public int getDlvrDate() {
        return dlvrDate;
    }
    public void setDlvrDate(int dlvrDate) {
        this.dlvrDate = dlvrDate;
    }    
    public int getQty() {
    	return qty;
    }
    public void setQty(int n) {
    	this.qty = n;
    }
  	public String getSupplier() {
        return supplier;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    public int getPiece() {
        return piece;
    }
    public void setPiece(int piece) {
        this.piece = piece;
    }
    public int getMinQty() {
        return minQty;
    }
    public void setMinQty(int minQty) {
        this.minQty = minQty;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getDlvrTime() {
        return dlvrTime;
    }
    public void setDlvrTime(int dlvrTime) {
        this.dlvrTime = dlvrTime;
    }
   
    public void SupplierA_P1() {
    	setSupplier("A");
    	setPiece(1);
    	setMinQty(16);
    	setPrice(30);
    	setDlvrTime(4);
    } 
    public void SupplierA_P2() {
    	setSupplier("A");
    	setPiece(2);
    	setMinQty(16);
    	setPrice(16);
    	setDlvrTime(4);
    }
    public void SupplierB_P1() {
    	setSupplier("B");
    	setPiece(1);
    	setMinQty(8);
    	setPrice(45);
    	setDlvrTime(2);
    }
    public void SupplierB_P2() {
    	setSupplier("B");
    	setPiece(2);
    	setMinQty(8);
    	setPrice(15);
    	setDlvrTime(2);
    }
    public void SupplierC_P1() {
    	setSupplier("C");
    	setPiece(1);
    	setMinQty(4);
    	setPrice(55);
    	setDlvrTime(1);
    }
    public void SupplierC_P2() {
    	setSupplier("C");
    	setPiece(2);
    	setMinQty(4);
    	setPrice(18);
    	setDlvrTime(1);
    }
    
    
    
}

