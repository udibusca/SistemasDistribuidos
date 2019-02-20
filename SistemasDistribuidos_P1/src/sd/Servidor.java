/**
 * 
 */
package sd;

/**
 * @author aluno
 *
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {

		try {
			ServerSocket s = new ServerSocket(2000);
			System.out.println("Esperando conexao..........");

			Socket conexao = s.accept();
			System.out.println("Conexao aceita - esperando dados....");

			DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
			DataInputStream entrada = new DataInputStream(conexao.getInputStream());

			for (int i = 0; i < 100000; i++) {
				int entra = entrada.readInt();
				System.out.println("Entrei");
				saida.writeUTF("Seu dado foi recebido: " + entra);
			}

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

}