package sd;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) {
		try {

			Socket s = new Socket("localhost", 2000);

			DataOutputStream saida = new DataOutputStream(s.getOutputStream());
			DataInputStream entrada = new DataInputStream(s.getInputStream());

			for (int i = 0; i < 100000; i++) {
				saida.writeInt(i);
				System.out.println("Enviei: " + i);
				String en = entrada.readUTF();
				System.out.println("Recebi: " + en);
			}

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
