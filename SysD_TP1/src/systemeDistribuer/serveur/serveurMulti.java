package systemeDistribuer.serveur;


import java.io.IOException;
import java.net.ServerSocket;

public class serveurMulti {
	// run a chaque fin de socket sans thread
	public static void main(String[] args) {
			ServerSocket socket;
			try {
			socket = new ServerSocket(2009);
			Thread t = new Thread(new Accepter_clients(socket));
			t.start();
			System.out.println("Ecoute");
			
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

		


