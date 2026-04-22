package tp.poo;

// 1. Classe abstraite Animal
abstract class Animal {
    private String nom;

    public Animal(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public abstract void faireDuBruit();
}

// 2. Classe Mammifère
class Mammifère extends Animal {
    public Mammifère(String nom) {
        super(nom);
    }

    @Override
    public void faireDuBruit() {
        System.out.println(getNom() + " grogne.");
    }
}

// 3. Classe Oiseau
class Oiseau extends Animal {
    public Oiseau(String nom) {
        super(nom);
    }

    @Override
    public void faireDuBruit() {
        System.out.println(getNom() + " chante.");
    }

    public void voler() {
        System.out.println("L'oiseau vole.");
    }
}

// 4. Classe principale
public class Zoo {
    public static void main(String[] args) {
        Animal tigre = new Mammifère("Tigre");
        Animal perroquet = new Oiseau("Perroquet");

        tigre.faireDuBruit();
        perroquet.faireDuBruit();

        Oiseau perroquetOiseau = new Oiseau("Perroquet");
        perroquetOiseau.voler();
    }
}