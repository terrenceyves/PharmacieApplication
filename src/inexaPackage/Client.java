package inexaPackage;

public class Client {

	private String nom;
	private double credit;
	
	public Client(String nom, double credit) {
		super();
		this.nom = nom;
		this.credit = credit;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}

}
