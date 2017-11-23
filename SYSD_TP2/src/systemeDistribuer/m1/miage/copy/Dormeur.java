package systemeDistribuer.m1.miage.copy;

public class Dormeur extends Thread {
	int id;
	Thread predeceseur;

	public Dormeur(int i, Thread t) {
		this.id = i;
		this.predeceseur = t;

	}

	public void run() {
		System.out.format("Dormeur %d : debute\n", id);
		if (predeceseur != null) {
			try {
				predeceseur.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.format("Dormeur %d : terminer!\n", id);
	}

	public static void main(String[] args) throws Exception {

		Dormeur c = new Dormeur(3, null);
		Dormeur b = new Dormeur(2, c);
		Dormeur a = new Dormeur(1, b);
		a.start();
		b.start();
		c.start();

	}
}
