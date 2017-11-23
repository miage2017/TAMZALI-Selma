package systemeDistribuer.serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Accepter_clients implements Runnable {

	   private ServerSocket socketserver;
	   private Socket socket;
	   private int nbrclient = 1;
	   
	   public Accepter_clients(ServerSocket s){
		   socketserver = s;
		}
	   
		public void run() {
	        try {
				socket = socketserver.accept();  //serveur accept les conections
				
				//Création de la stream de messages entrants
				InputStreamReader irs = new InputStreamReader(socket.getInputStream(), "UTF-8");
				BufferedReader fluxEntrant = new BufferedReader(irs);
				String messageEntrant = fluxEntrant.readLine();
				
				PrintWriter out = new PrintWriter(socket.getOutputStream() , true);
				out.println("vous etes conecté a ServeurJouer");
			    
			    while(messageEntrant.compareTo("stop") != 0){
			    	System.out.println(messageEntrant);
			    	messageEntrant = fluxEntrant.readLine();
				}           
				socket.close();
	        } catch (IOException e) {
				e.printStackTrace();
			}
		}
}
