package systemeDistribuer.m1.miage.copy;

public class DumbClass  implements Runnable{
    String nom="Toto";
    int maxIter= 100 ;
    int direction;
    public DumbClass(String  nom, int direction)    {
    	this.nom=nom;
    	this.direction=direction;
    	
    }

    public void run() {
	System.out.format("Ici le  thread %s, je debute!\n", nom);
	if(direction == 0){
		for (int i = 0; i < maxIter; i++) {
		    System.out.format("[%s] dit  je suis Ici %d\n",nom,i);
		}
	}
	else{
		for (int i = maxIter; i > 0; i--) {
		    System.out.format("[%s] dit  je suis Ici %d\n",nom,i);
		}
	}
	System.out.format("Ici le  thread %s, je  Termine!\n", nom);
    }

    public static void main(String[] args)  throws  Exception {
	String jobName= String.format("1");
	String jobName2= String.format("2");
	DumbClass  objetExec  = new DumbClass(jobName, 0);
	DumbClass  objetExec2  = new DumbClass(jobName2, 1);
	Thread job = new Thread(objetExec);
	Thread job2 = new Thread(objetExec2);
	System.out.format("Creating thread %s\n", jobName);
	job.start();
	System.out.format("Creating thread %s\n", jobName2);
	job2.start();
	
    }

}

