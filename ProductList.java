
public class ProductList {
    private String brand;
    private String model;
    private double price;
    private int qty;
    private String description;
    private int batRank;
    private int procRank;
    private String type;
    private int rank;
    private String category;

  	public ProductList(String brand, String model, double price, int qty, String description, int batRank, int procRank, String type, int rank, String category ) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.qty = qty;
        this.description = description;
        this.batRank=batRank;
        this.procRank=procRank;
        this.type=type;
        this.rank=rank;
        this.category=category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public int getBatRank() {
		return batRank;
	}

	public void setBatRank(int batRank) {
		this.batRank = batRank;
	}

	public int getProcRank() {
		return procRank;
	}

	public void setProcRank(int procRank) {
		this.procRank = procRank;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
    
    
    
}
