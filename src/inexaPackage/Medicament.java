package inexaPackage;

public class Medicament {
	private String nom;
	private double prix;
	private int stock;
	public Medicament(String nom, double prix, int stock) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
	
}
