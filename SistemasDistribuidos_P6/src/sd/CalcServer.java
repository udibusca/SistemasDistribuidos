package sd;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class CalcServer extends UnicastRemoteObject implements Calc {
	private static final long serialVersionUID = 1L;

	public CalcServer() throws RemoteException {
		super();
	}

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(2335);
			
			CalcServer f = new CalcServer();
			
			Naming.rebind("//localhost:2335/calc", f);
			
			System.out.println("Servidor Calculadora pronto");
		} catch (RemoteException ex) {
			System.out.println("Exception in " + ex);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getSoma(int a, int b) throws RemoteException {
		return (a + b);
	}

	@Override
	public int getSubtracao(int a, int b) throws RemoteException {
		return (a - b);
	}

	@Override
	public int getMultiplicacao(int a, int b) throws RemoteException {
		return (a * b);
	}

	@Override
	public double getDivisao(int a, int b) throws RemoteException {
		if (a != 0)
			return (a / b);
		else
			return (0);
	}
}