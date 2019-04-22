package sd;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CalcClient {
	public static void main(String[] args) {

		Calc calculadora;

		try {
			calculadora = (Calc) Naming.lookup("rmi://localhost:2335/calc");
			int a = 3;
			int b = 4;
			int f = calculadora.getSoma(a, b);
			System.out.println("A soma eh: " + f);
		} catch (MalformedURLException e) {
			System.out.println("não é uma UI valida");
		} catch (RemoteException re) {
			System.out.println("Objeto remoto travou a execução " + re);
		} catch (NotBoundException no) {
			System.out.println("Não foi possivel achar o objeto remoto " + no);
		}

	}
}