package Socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
	
	private ServerSocket serverSocket;

	
	private void criarServerSocket(int porta)throws IOException{
		serverSocket = new ServerSocket(porta);
	}
	private Socket esperaConexao() throws IOException {
		Socket socket = serverSocket.accept();
		return socket;
	}
	private void fechaSocket(Socket s) throws IOException{
		s.close();
		
	}
	private void trataConexao(Socket socket) throws IOException {
		try {
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			output.flush();
		
			System.out.println("Tratando...");
			//String msg = input.readUTF();
			//System.out.println("Mensagem recebida..."+msg);
			//output.writeUTF("Hello World! Tudo bem?");
			int n1 = input.readInt();
			System.out.println("Numero recebido (1): "+n1);
			
			int n2 = input.readInt();
			System.out.println("Numero recebido (2): "+n2);
			
			int n3 = input.readInt();
			System.out.println("Numero recebido (3): "+n3);
			
			if(n1<n2 && n1<n3) {
				output.writeInt(n1);
			}else {
				if(n2<n1 && n2<n3) {
					output.writeInt(n2);
				}else {
					if(n3<n1 && n3<n2) {
						output.writeInt(n3);
					}
				}
			}
			
			output.flush();
			
			
			output.close();
			input.close();
			
			
		}catch(IOException e){
			
			System.out.println("Problema no tratamento da conexao com o cliente: "+socket.getInetAddress());
			System.out.println("Erro: "+e.getMessage());
		}finally {

			
			fechaSocket(socket);
		}
		
	}
	
	public static void main(String[]args) throws Exception{
		try {
				Server server = new Server();
				System.out.println("Aguardando a conexao...");
				
		server.criarServerSocket(5555);
		Socket socket = server.esperaConexao();
			System.out.println("Cliente conectado.");	
		server.trataConexao(socket);
		
		System.out.println("Cliente finalizado.");
		
		}catch(IOException e){
			e.getMessage();
		}
	
		
	}
	

}
