//student: 214404255

import java.io.*;
import java.net.*;

public class In2cmClient2 {
    
	public static void main(String argv[]) throws Exception {
		String welcome, cm, goodbye;
		
		if (argv.length != 2) {
			System.out.println("Usage: In2cmClient [inches] [host name]");
		}
		
		Socket clientSocket = new Socket(argv[1], 24255);
		
        DataInputStream FromClient = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream ToServer = new DataOutputStream(clientSocket.getOutputStream());
        
        welcome = FromClient.readUTF(); //reads welcome from server
		System.out.println("From Server: " + welcome);
		
		ToServer.writeUTF(argv[0]); //sends input to server
		System.out.println("To Server: " + argv[0]);
	
		cm = FromClient.readUTF(); //reads answer from server
		System.out.println("From Server: " + cm);
		
		ToServer.writeUTF("Thanks!"); //sends thanks to server
		System.out.println("To Server: Thanks!");
		
		goodbye = FromClient.readUTF(); //reads bye from server
		System.out.println("From Server: " + goodbye);
		
		FromClient.close(); //closes client 
		ToServer.close(); //closes server
		clientSocket.close(); //closes client socket
	}
}

