package test;

public class ObjetEntier {
	private int ma_valeur;

	public ObjetEntier() {
		ma_valeur = 0;
		System.out.format("Valeur partagee initialisee a %d\n", ma_valeur);
	}

	public String toString() {
		return Integer.toString(ma_valeur);
	}

	public int val() {
		return ma_valeur;
	}
//synchronized : cette déclaration empêche que plus d’un thread exécute une méthode synchrone de l’objet concerné 
	public synchronized void add(int i) {
		ma_valeur += i;
	}

}
