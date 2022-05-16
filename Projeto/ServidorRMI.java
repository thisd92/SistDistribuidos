import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Date;
import java.rmi.registry.*;
import java.io.Serializable;
import java.rmi.Naming;
import static java.lang.Math.toIntExact;

public class ServidorRMI extends UnicastRemoteObject implements InterfaceRMI, Serializable
{
    
    public ServidorRMI() throws RemoteException
	{
		super();
	}
	
    static public void main (String rmi[])
    {
            try 
            {
                    ServidorRMI objetoServidor = new ServidorRMI();
                    System.setProperty("java.rmi.server.hostname", "localhost");
                    LocateRegistry.createRegistry(1099);
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

    public String cpf(String numCpf)
    {
        int[] vcpf = new int[11];
        long nCPF;
        long num=10000000000L;
        long resto;    
        int j;   
        int i;
        int dig1=0;
        int dig2=0;

        nCPF = Long.parseLong(numCpf);
        for (j = 0; j < 11; j++){        
            resto = (nCPF % num);
            i= toIntExact(nCPF / num);
            num = num/10;
            nCPF = resto;         
            vcpf[j] = i;     
        }

        i=10;
        for (j = 0; j < 9; j++){            
          dig1 = dig1 + (vcpf[j] * i);
          i = i - 1;            
        }

        i=11;        
        for (j=0;j<10;j++){            
            dig2=dig2+(vcpf[j]*i);           
            i=i-1;
        }

        dig1 = dig1 * 10 % 11; 
        dig2 = dig2 * 10 % 11;
        
        if (dig1==10) dig1=0;
        
        if (dig2==10) dig2=0;

        if (dig1==vcpf[9] && (dig2==vcpf[10])){
            return "\nCPF Válido\n";
        } else return "\nCPF inválido\n";
        
    }

    public String ordenar(String arrNum)
    {
        return arrNum;
    }
}