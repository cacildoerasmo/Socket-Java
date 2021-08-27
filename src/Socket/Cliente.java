package Socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		

		try {
			System.out.println("Estabelendo a conexao...");
			Socket socket = new Socket("localhost",5555);
			System.out.println("Conexao estabelecida.");
			
				ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream input= new ObjectInputStream(socket.getInputStream());
			Scanner sc = new Scanner(System.in);
			System.out.println("Enviando numeros...");
			//String msg = "Hello";
			System.out.println("numero1");
			int n1 = sc.nextInt();
			output.writeInt(n1);
			
			System.out.println("numero2");
			int n2 = sc.nextInt();
			output.writeInt(n2);
			
			System.out.println("numero3");
			int n3 = sc.nextInt();
			output.writeInt(n3);
			//output.writeUTF(msg);
			
			output.flush();
			//System.out.println("Mensagem "+msg+" enviada.");
			//System.out.println("Numero");
						
			int nn = input.readInt();
			System.out.println("Menor: "+nn);
			//msg = input.readUTF();
			//System.out.println("Resposta: "+msg);
			
			output.close();
			input.close();
			socket.close();
			
		} catch (IOException e) {
			System.out.println("Erro no cliente: "+e);
			e.printStackTrace();
		}

	}

}
