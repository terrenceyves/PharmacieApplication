package inexaPackage;



public class Pharmacie1 {
	private Client[]  clients ;
    private Medicament[]  medicaments;
    
    
	
	public Pharmacie1(Client[] clients, Medicament[] medicaments) {
		super();
		this.clients = clients;
		this.medicaments = medicaments;
	}
	
	

	public Client[] getClients() {
		return clients;
	}



	public void setClients(Client[] clients) {
		this.clients = clients;
	}



	public Medicament[] getMedicaments() {
		return medicaments;
	}



	public void setMedicaments(Medicament[] medicaments) {
		this.medicaments = medicaments;
	}



	void achat(Client[] clients , Medicament[] medicaments){
    	Client client = lireClient(clients);
    	Medicament medicament = lireMedicament(medicaments);
    	
    	
    	System.out.println("Quel est le montant du paiement?"); 
    	double montant_payement =GestionPharmacie.scanner.nextDouble();
    	
    	System.out.println("Quelle est la quantité achetée?"); 
    	int quantite_achetee =GestionPharmacie.scanner.nextInt();
    	
    	if(quantite_achetee>medicament.getStock()){
    		System.out.println("Achat Impossible. Quantité insuffisante");
    	}
    	else {
    		medicament.setStock(medicament.getStock()-quantite_achetee);
    		double credit = (quantite_achetee * medicament.getPrix()) - montant_payement;
    		client.setCredit(credit+client.getCredit());
    	}
    	
    	
    			
    }
    
    void approvisionnement(Medicament[] medicaments) {
    	Medicament medicament = lireMedicament(medicaments);
    	System.out.println("Donnez la quantité : "); 
    	int quantite_medicament =GestionPharmacie.scanner.nextInt(); 
    	medicament.setStock(medicament.getStock() + quantite_medicament);
    }
    
	
    Medicament lireMedicament(Medicament[] medicaments){
    	 
    	boolean medicament_trouve = false;
    	System.out.println("Nom du medicament : ");
    	while(!medicament_trouve){
    		
	    	String nom_medicament = GestionPharmacie.scanner.nextLine();
	    	
	    	for (Medicament medicament : medicaments) {
	    		if(medicament.getNom().equals(nom_medicament)) {  
	    			return medicament;
	    		}
	    	}
	    	if(nom_medicament.length()>0) {
	    		System.out.println("Medicament inconnu. Veuilliez recommencer : ");
	    	}
	    	
	    	
    	 }
    	return null;
	 }
    
    
    Client lireClient(Client[] clients){
    	
    	boolean client_trouve = false;
    	System.out.println("Nom du client : ");
    	while(!client_trouve){
    		
	    	String nom_client = GestionPharmacie.scanner.nextLine();
	    	
	    	for (Client client : clients) {
	    		if(client.getNom().equals(nom_client)) {    			
	    			return client;
	    		}
	    	}
	    	if(nom_client.length()>0) {
	    		System.out.println("Client inconnu. Veuilliez recommencer : ");
	    	}
	    	
	    	
    	 }
    	return null;
    	
    }
   
	 
    
     void affichage(Client[] clients , Medicament[] medicaments) {
    	System.out.println("Affichage des stocks");
    	for (Medicament medicament : medicaments) {
    		System.out.println("Stock du médicament  "+ medicament.getNom()+" : "+ medicament.getStock());
    	}
    	
    	System.out.println("Affichage des crédits");
    	for (Client client : clients) {
    		System.out.println("Crédit du client "+ client.getNom()+" : "+ client.getCredit());
    	}
    	
    	
    	
    }
     
    void quitter() {
     	System.out.println("Programme terminé! ");
 	}
    
    
   
}
