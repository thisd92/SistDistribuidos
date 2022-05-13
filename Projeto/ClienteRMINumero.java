import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.rmi.Naming;

public class ClienteRMINumero
{

	public static void menu(){
		System.out.println("1 - Fatorial");
		System.out.println("2 - Data");
		System.out.println("3 - Hora");
		System.out.println("4 - Bem Vindo");
		System.out.println("5 - Ordena Lista");
		System.out.println("6 - CPF");
		System.out.println("7 - Sair");
	}
	static public void main (String rmi[])
	{
		try 
		{
			//String localizacao = "//192.168.25.92/data";
                        //String localizacao = "127.0.0.1/data";
			InterfaceRMINumero objeto = (InterfaceRMINumero) Naming.lookup ("rmi://localhost:1099/Servico");
			
			int opcao;
			Scanner entrada = new Scanner(System.in);
			do{
				menu();
				opcao = entrada.nextInt();

				switch(opcao){
					case 1:
						Scanner scan = new Scanner(System.in);
						System.out.println("Digite o número:");
						int num;
						num = scan.nextInt();
						objeto.fatorial(num);
						break;
					case 2:
						objeto.data();
						break;
					case 3:
						objeto.hora();
						break;
					case 4:
                                                Scanner scan4 = new Scanner(System.in);
						System.out.println("Digite o número:");
						String nome;
						nome = scan4.next();
						objeto.bemvindo(nome);
						break;
					case 5:
                                                Scanner scan3 = new Scanner(System.in);
						System.out.println("Digite o número:");
                                                int[] arrNum = null;
						objeto.ordenar(arrNum);
						break;

					case 6:
						Scanner scan2 = new Scanner(System.in);
						System.out.println("Digite o CPF:");
						String numCpf = scan2.next();
						objeto.cpf(numCpf);
						break;
					case 7:
						break;
					default:
						System.out.println("Opção inválida");
				}
			}while(opcao != 7);

			//System.out.println ("2 ao quadrado eh: " + objeto.quadrado(2));
			//System.out.println ("2 ao cubo eh: " + objeto.cubo(2));
		} 
		catch (Exception exc) 
		{
			System.err.println (exc.toString());
		}
	}	
}
