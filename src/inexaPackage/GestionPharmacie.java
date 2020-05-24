package inexaPackage;


import java.util.Scanner;

class GestionPharmacie {
    protected static Scanner scanner = new Scanner(System.in);
    
    public static void main (String args[]) {
        Client[]  clients = new Client[2];
        Medicament[]  medicaments = new Medicament[2];
 
        clients[0] = new Client("Malfichu",0.0);
        clients[1] = new Client("Palichon",0.0);
 
        medicaments[0] = new Medicament("Aspiron", 20.40, 5);
        medicaments[1] = new Medicament("Rhinoplexil",19.15, 5);
        int choix;
        
        Pharmacie1 pharmacie1 = new Pharmacie1(clients, medicaments);
 
        do {
            choix = menu();
 
            switch (choix) {
            case 1 :
            	pharmacie1.achat(clients, medicaments);
                break;
            case 2 :
            	pharmacie1.approvisionnement(medicaments);
                break;
            case 3 :
            	pharmacie1.affichage(clients, medicaments);
                break;
            case 4:
                pharmacie1.quitter();
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
    
   
    
    
 
}
