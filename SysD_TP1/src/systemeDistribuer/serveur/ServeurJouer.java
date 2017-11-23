package systemeDistribuer.serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurJouer {

	public static void main(String[] args) {
			
		ServerSocket socketserver  ;
		Socket socketduserveur ;
		BufferedReader fluxEntrant;
		PrintWriter out;
				
		try {
		
			socketserver = new ServerSocket(2009); //creation serveur ecoute sur le port 
			System.out.println("Le serveur est à l'écoute du port "+socketserver.getLocalPort());
			socketduserveur = socketserver.accept();  //serveur accept les conections
			
			//Création de la stream de messages entrants
			InputStreamReader irs = new InputStreamReader(socketduserveur.getInputStream(), "UTF-8");
			fluxEntrant = new BufferedReader(irs);
			String messageEntrant = fluxEntrant.readLine();
			
			out = new PrintWriter(socketduserveur.getOutputStream() , true);
			out.println("vous etes conecté a ServeurJouer");
		    
			int i = 0;
		    while(messageEntrant.compareTo("stop") != 0){
		    	System.out.println(i+". "+messageEntrant);
		    	messageEntrant = fluxEntrant.readLine();
		    	i++;
			}           
			socketduserveur.close();
	        socketserver.close();
		        
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
