//student: 214404255

import java.io.*;
import java.net.*;
import java.text.DecimalFormat;

public class In2cmServer2 {
	
	public static void main( String argv[] ) throws Exception{
		String inch, thanks;
		double cm;
		
		DecimalFormat df = new DecimalFormat("#.00"); //formats value to 2 decimal places
		
		ServerSocket serverSocket = new ServerSocket(24255);
		
		while(true) {
			
			Socket connectionSocket = serverSocket.accept();
			
			DataOutputStream ToClient = new DataOutputStream(connectionSocket.getOutputStream());
			DataInputStream FromClient = new DataInputStream(connectionSocket.getInputStream());
			
			ToClient.writeUTF("Welcome!"); //sends welcome to client
	
			inch = FromClient.readUTF(); //reads client input
			
			cm = Double.parseDouble(inch) * 2.54; //converts inches to cms
			
			ToClient.writeUTF(df.format(cm)); //sends answer to client
			
			thanks = FromClient.readUTF(); //reads thanks from client
			System.out.println(thanks);
			
			ToClient.writeUTF("Bye!"); //sends bye to client
			
			ToClient.close(); //closes client stream
			connectionSocket.close(); //closes connection socket to client
		}
		//IMPORTANT! make sure to close server after testing is done!
	}
}
