package inexaPackage;



import java.util.Scanner;

class Pharmacie {
    private static Scanner scanner = new Scanner(System.in);
    public static void main (String args[]) {
        Client[]  clients = new Client[2];
        Medicament[]  medicaments = new Medicament[2];
 
        clients[0] = new Client("Malfichu",0.0);
        clients[1] = new Client("Palichon",0.0);
 
        medicaments[0] = new Medicament("Aspiron", 20.40, 5);
        medicaments[1] = new Medicament("Rhinoplexil",19.15, 5);
        int choix;
 
        do {
            choix = menu();
 
            switch (choix) {
            case 1 :
                achat(clients, medicaments);
                break;
            case 2 :
                approvisionnement(medicaments);
                break;
            case 3 :
                affichage(clients, medicaments);
                break;
            case 4:
                quitter();
            }
        }
        while (choix < 4);
    }
    // Les méthodes utilitaires
 
    static int menu() {
        int choix = 0;
        System.out.println();
        System.out.println();
        System.out.println("1 : Achat de médicament");
        System.out.println("2 : Approvisionnement en  médicaments");
        System.out.println("3 : Etats des stocks et des crédits");
        System.out.println("4 : Quitter");
        while ((choix != 1) && (choix != 2) && (choix != 3) && (choix != 4)) {
        	choix = scanner.nextInt();
        
            
        }
        return choix;
    }
    
    static void achat(Client[] clients , Medicament[] medicaments){
    	Client client = lireClient(clients);
    	Medicament medicament = lireMedicament(medicaments);
    	
    	
    	System.out.println("Quel est le montant du paiement?"); 
    	double montant_payement =scanner.nextDouble();
    	
    	System.out.println("Quelle est la quantité achetée?"); 
    	int quantite_achetee =scanner.nextInt();
    	
    	if(quantite_achetee>medicament.getStock()){
    		System.out.println("Achat Impossible. Quantité insuffisante");
    	}
    	else {
    		medicament.setStock(medicament.getStock()-quantite_achetee);
    		double credit = (quantite_achetee * medicament.getPrix()) - montant_payement;
    		client.setCredit(credit+client.getCredit());
    	}
    	
    	
    			
    }
    
    static void approvisionnement(Medicament[] medicaments) {
    	Medicament medicament = lireMedicament(medicaments);
    	System.out.println("Donnez la quantité : "); 
    	int quantite_medicament =scanner.nextInt(); 
    	medicament.setStock(medicament.getStock() + quantite_medicament);
    }
    
	
    static Medicament lireMedicament(Medicament[] medicaments){
    	 
    	boolean medicament_trouve = false;
    	System.out.println("Nom du medicament : ");
    	while(!medicament_trouve){
    		
	    	String nom_medicament = scanner.nextLine();
	    	
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
    
    
    static Client lireClient(Client[] clients){
    	
    	boolean client_trouve = false;
    	System.out.println("Nom du client : ");
    	while(!client_trouve){
    		
	    	String nom_client = scanner.nextLine();
	    	
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
   
	 
    
    static void affichage(Client[] clients , Medicament[] medicaments) {
    	System.out.println("Affichage des stocks");
    	for (Medicament medicament : medicaments) {
    		System.out.println("Stock du médicament  "+ medicament.getNom()+" : "+ medicament.getStock());
    	}
    	
    	System.out.println("Affichage des crédits");
    	for (Client client : clients) {
    		System.out.println("Crédit du client "+ client.getNom()+" : "+ client.getCredit());
    	}
    	
    	
    	
    }
    
    
    static void quitter() {
    	System.out.println("Programme terminé! ");
	}
 
}
