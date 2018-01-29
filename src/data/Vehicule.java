package data;

public class Vehicule {
	
	// ----- Parameters -------------------------
	
	private int ID;
    private String model;
    private int year;
    	
	// ----- Getters and Setters ----------------
    
    public int getID() {
		return ID;
	}
    
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
}
