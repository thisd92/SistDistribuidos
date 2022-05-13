import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.rmi.Naming;

public class ClienteRMINumero
{

	public static void menu(){
		System.out.println("Escolha uma opção");
		System.out.println("1 - Fatorial");
		System.out.println("2 - Data");
		System.out.println("3 - Hora");
		System.out.println("4 - Bem Vindo");
		System.out.println("5 - Ordena Lista");
		System.out.println("6 - CPF");
		System.out.println("7 - Sair\n");
	}
	static public void main (String rmi[])
	{
		try 
		{
			//String localizacao = "//192.168.25.92/data";
                        //String localizacao = "127.0.0.1/data";
			InterfaceRMINumero objeto = (InterfaceRMINumero) Naming.lookup ("rmi://localhost:1099/data");
			
			int opcao;
			Scanner entrada = new Scanner(System.in);
			
			do{
				menu();
				opcao = entrada.nextInt();

				switch(opcao){
					case 1:
						Scanner scan = new Scanner(System.in);
						System.out.println("\nDigite um número:");
						int num;
						num = scan.nextInt();
						//objeto.fatorial(num);
						int res = objeto.fatorial(num);
						System.out.println("Resultado do fatorial: " + res + "\n");
						break;
					case 2:
						System.out.println("\n" + objeto.data() + "\n");
						break;
					case 3:
						System.out.println("\n" + objeto.hora() + "\n");
						break;
					case 4:
						Scanner scan4 = new Scanner(System.in);
						System.out.println("\nDigite seu nome:");
						String nome;
						nome = scan4.next();
						System.out.println("\n" + objeto.bemvindo(nome) + "\n");
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
		} 
		catch (Exception exc) 
		{
			System.err.println (exc.toString());
		}
	}	
}
