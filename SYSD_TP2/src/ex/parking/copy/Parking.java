package ex.parking.copy;

public class Parking {
	public int nbPlace;
	public int nbVoiture;

	public Parking(int n) {
		this.nbPlace = n;
		this.nbVoiture = 0;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public int getNbVoiture() {
		return nbVoiture;
	}

	public void setNbVoiture(int nbVoiture) {
		this.nbVoiture = nbVoiture;
	}
	
	public synchronized boolean enter(){
		if(getNbPlace() > getNbVoiture()){
			setNbVoiture(getNbVoiture()+1);
			return true;
		}
		else{
			return false;
		}
	}
	
	public synchronized void leave(){
		setNbVoiture(getNbVoiture()-1);
	}
	

}
