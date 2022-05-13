import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRMINumero extends Remote
{
	public int fatorial(int num) throws RemoteException;
	public void data() throws RemoteException;
	public void hora() throws RemoteException;
	public String bemvindo(String nome) throws RemoteException;
	public void ordenar(int[] arrNum) throws RemoteException;
	public void cpf(String numCPF) throws RemoteException;
}
