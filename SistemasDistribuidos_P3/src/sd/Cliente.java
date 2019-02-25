package sd;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("192.168.43.233", 2001);

			DataOutputStream saida = new DataOutputStream(s.getOutputStream());
			DataInputStream entrada = new DataInputStream(s.getInputStream());

			String linha;
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("> ");
				linha = teclado.readLine();
				saida.writeUTF(linha);
				linha = entrada.readUTF();
				
				if(linha.equalsIgnoreCase("")) {
					System.out.println("Conex�o encerrada ...");
					break;
				}
				System.out.println(linha);
			}

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
