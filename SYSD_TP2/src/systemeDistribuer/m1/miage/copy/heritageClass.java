package systemeDistribuer.m1.miage.copy;

public class heritageClass extends Thread {
	String nom = "Toto";
	int maxv = 10;

	public heritageClass(String nom) {
		this.nom = nom;
	}

	public void run() {
		System.out.format("Ici le  thread %s, je debute!\n", nom);
		for (int i = 0; i < maxv; i++) {
			System.out.format("[%s] dit  je suis la %d\n", nom, i);
		}
	}

	public static void main(String[] args) throws Exception {
		String jobname = String.format("1");
		String jobname2 = String.format("2");
		heritageClass objet_executable = new heritageClass(jobname);
		heritageClass objet_executable2 = new heritageClass(jobname2);
		System.out.format("Creating thread %s\n", jobname);
		objet_executable.start();
		objet_executable2.start();
		System.out.format("Main :Fini ici  !\n");
	}
}
