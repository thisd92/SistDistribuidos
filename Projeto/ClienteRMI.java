import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.rmi.Naming;

public class ClienteRMI
{

	static int array[];
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
			InterfaceRMI objeto = (InterfaceRMI) Naming.lookup ("rmi://localhost:1099/data");
			
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
						System.out.println("Digite a lista de números separados apenas por virgula:");
						String arrNum = scan3.next();
						String[] arrayString = arrNum.split(arrNum, ',');
						//int[] array;
						for(int i = 0; i < arrayString.length; i++){
							array[i] = Integer.parseInt(arrayString[i]);
						}
						System.out.println(objeto.ordenar(array));
						break;
					case 6:
						Scanner scan2 = new Scanner(System.in);
						System.out.println("Digite o CPF:");
						String numCpf = scan2.next();
						System.out.println(objeto.cpf(numCpf));
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
