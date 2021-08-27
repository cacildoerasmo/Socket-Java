package Socket;

import java.net.*;
import java.io.*;

public class socket {

	public static void main(String[] args) {
		
	Socket meuCliente = null;
	
	try {
		meuCliente = new Socket("127.0.0.1",3322);
	
	}catch(IOException e) {
		
		System.out.println(e.getMessage());
		}
	
	}

}
