import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.rmi.RemoteException;
import java.util.Date;
import java.rmi.registry.*;
import java.io.Serializable;
import java.rmi.Naming;

public class ServidorRMINumero extends UnicastRemoteObject implements InterfaceRMINumero, Serializable
{
    
    public ServidorRMINumero() throws RemoteException
	{
		super();
	}
	
    static public void main (String rmi[])
    {
            try 
            {
                    ServidorRMINumero objetoServidor = new ServidorRMINumero();
                    System.setProperty("java.rmi.server.hostname", "localhost");
                    LocateRegistry.createRegistry(1099);
                    //UnicastRemoteObject.exportObject(objetoServidor);
                    //String localizacao = "192.168.25.92/data";
                    Naming.bind ("data", objetoServidor);
            } 
            catch (Exception exc) 
            {
                    System.err.println (exc.toString());
            }
    }

    public int fatorial(int num){
            if(num == 1){
                    return 1;
            }
            return fatorial(num - 1)* num;
    }

    public String bemvindo(String nome){
        return "Bem Vindo, " + nome;    
    }

    public String data()
    {
        Date datahoje = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = dateFormat.format(datahoje);
        
        return dataFormatada;
        }

    public String hora()
    {
        Date datahoje = new Date();
        DateFormat horaFormat = new SimpleDateFormat("HH:mm:ss");
        String horaFormatada = horaFormat.format(datahoje);
        return horaFormatada;
    }

    public void cpf(String numCpf)
    {
            System.out.println("CPF Válido");
    }

    public void ordenar(int[] num)
    {
        System.out.println(num);
    }
}
