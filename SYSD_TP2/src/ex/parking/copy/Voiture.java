package ex.parking.copy;

import test.PetitJob;

public class Voiture extends Thread {
	public int id;
	public Parking parking;

	public Voiture(int id, Parking p) {
		this.id = id;
		this.parking = p;
	}

	public static void waithere(int num) {
		try {
			int delay = (int) (Math.random() * num);
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			// status 0 veut enter // status 1 est entrer
			int status = 0;
			while (status == 0) {
				if (parking.enter()) {
					System.out.format("Voirure %d est entrer\n", id);
					status = 1;
				} else {
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.format("Voiture %d ne peut pas enter \n", id);
					System.out.format("Nombre de place libre : %d\n", parking.getNbVoiture());
					System.out.format("Nombre de voitures : %d\n", parking.getNbVoiture());
				}
			}
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			waithere(100);
			parking.leave();
			System.out.format("Voiture %d est sortie\n", id);
			status = 0;
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void main(String[] args) throws InterruptedException {
		Parking p = new Parking(10);
		sleep(1000);
		for (int i = 0; i < 20; i++) {
			Voiture v = new Voiture(i, p);
			v.start();
		}
	}

}
