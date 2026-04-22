package tp.poo;

// Classe de base
class CompteBancaire {
    protected String numeroCompte;
    protected double solde;

    public CompteBancaire(String numeroCompte, double soldeInitial) {
        this.numeroCompte = numeroCompte;
        this.solde = soldeInitial;
    }

    public void deposer(double montant) {
        solde += montant;
        System.out.println("Dépôt de " + montant + " € effectué. Nouveau solde : " + solde + " €");
    }

    public void retirer(double montant) {
        if (montant <= solde) {
            solde -= montant;
            System.out.println("Retrait de " + montant + " € effectué. Nouveau solde : " + solde + " €");
        } else {
            System.out.println("Solde insuffisant pour retirer " + montant + " €");
        }
    }

    public void afficherSolde() {
        System.out.println("Compte " + numeroCompte + " - Solde : " + solde + " €");
    }
}

// Classe CompteCourant (demandée dans l'énoncé)
class CompteCourant extends CompteBancaire {
    public CompteCourant(String numeroCompte, double soldeInitial) {
        super(numeroCompte, soldeInitial);
    }
    
    // Les comptes courants peuvent avoir un découvert autorisé
    // Mais l'énoncé ne demande pas d'attribut supplémentaire
}

// Classe CompteEpargne
class CompteEpargne extends CompteBancaire {
    public CompteEpargne(String numeroCompte, double soldeInitial) {
        super(numeroCompte, soldeInitial);
    }

    public void calculerInterets(double taux) {
        double interets = solde * taux / 100;
        solde += interets;
        System.out.println("Intérêts de " + interets + " € ajoutés. Nouveau solde : " + solde + " €");
    }
}

// Classe principale
public class Banque {
    public static void main(String[] args) {
        // Création d'un CompteCourant (comme demandé dans l'énoncé)
        CompteCourant compteCourant = new CompteCourant("CC123", 1000);
        
        // Création d'un CompteEpargne
        CompteEpargne compteEpargne = new CompteEpargne("CE456", 2000);

        System.out.println("=== TEST COMPTE COURANT ===");
        compteCourant.afficherSolde();
        compteCourant.deposer(200);
        compteCourant.retirer(300);
        compteCourant.retirer(1000);  // Test solde insuffisant

        System.out.println("\n=== TEST COMPTE EPARGNE ===");
        compteEpargne.afficherSolde();
        compteEpargne.calculerInterets(5);
        compteEpargne.retirer(500);
        compteEpargne.afficherSolde();
    }
}