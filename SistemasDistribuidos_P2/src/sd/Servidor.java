package sd;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {

		try {

			ServerSocket s = new ServerSocket(2000);
			System.out.println("Esperando conexao..........");

			Socket conexao = s.accept();
			System.out.println("Conexao aceita - esperando dados....");

			InetAddress address = conexao.getInetAddress();
			int porta_remota = conexao.getPort();
			
			    FileWriter arq = new FileWriter("D:\\Adress.txt");
			    PrintWriter gravarArq = new PrintWriter(arq);
			 
			    gravarArq.printf("+--------------------------Resultado------------------------+%n");
			    
			    gravarArq.printf("Nome da Maquina Remota : " + address.getHostName() + "%n");
			    gravarArq.printf("Ip da Maquina Remota : " + address.getHostAddress() + "%n");
			    gravarArq.printf("Porta da Maquina Remota : " + porta_remota + "%n");
	
			    gravarArq.printf("+-----------------------------------------------------------+%n");			 
			    arq.close();

			DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
			DataInputStream entrada = new DataInputStream(conexao.getInputStream());

			for (int i = 0; i < 200; i++) {
				int entra = entrada.readInt();
				System.out.println("Entrei");
				saida.writeUTF("Seu dado foi recebido: " + entra);
			}

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

}