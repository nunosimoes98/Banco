package view;

import java.util.ArrayList;
import java.util.Scanner;

import helper.Utils;
import model.Cliente;
import model.Conta;

public class Banco 
{
	static String nome = "Caixa Geral";
	static Scanner teclado = new Scanner(System.in);
	static ArrayList<Conta> contas;

	public static void main(String[] args) 
	{
		Banco.contas = new ArrayList<Conta>();
		Banco.menu();
	}
	
	public static void menu() {
		int opcao = 0;
		System.out.println("==================================");
		System.out.println("=============== ATM ==============");
		System.out.println("============" + Banco.nome + "===========");
		System.out.println("==================================");
		System.out.println("Selecione uma opção no menu: ");
		System.out.println("1 - Criar conta: ");
		System.out.println("2 - : Efetuar levantamento");
		System.out.println("3 - : Efetuar depósito");
		System.out.println("4 - : Efetuar transferência");
		System.out.println("5 - : Listar contas");
		System.out.println("6 - : Sair do sistema");
		
		try {
			opcao = Integer.parseInt(Banco.teclado.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("Por favor, informe uma opção válida.");
			Utils.pausar(1);
			Banco.menu();
		}

		switch (opcao) {
		case 1:
			Banco.criar_conta();
			break;
		case 2:
			Banco.efetuar_levantamento();
			break;
		case 3:
			Banco.efetuar_deposito();
			break;
		case 4:
			Banco.efetuar_transferencia();
			break;
		case 5:
			Banco.listar_contas();
			break;
		case 6:
			System.out.println("Até à próxima!");
			Utils.pausar(2);
			System.exit(0);
			default:
				System.out.println("Opção inválida.");
				Utils.pausar(2);
				Banco.menu();
				break;
		}
	}
	
	public static void criar_conta()
	{		
		System.out.println("Nome do cliente: ");
		String nome = Banco.teclado.nextLine();
		
		System.out.println("Email do cliente: ");
		String email = Banco.teclado.nextLine();
		
		System.out.println("Codigo Postal do cliente: ");
		String zip_code = Banco.teclado.nextLine();
		
		System.out.println("Data de nascimento do cliente: ");
		String data_nascimento = Banco.teclado.nextLine();
		
		Cliente cliente = new Cliente(nome, email, zip_code, Utils.string_para_data(data_nascimento));
		
		Conta conta = new Conta(cliente);
		
		Banco.contas.add(conta);
		
		System.out.println("Conta criada com sucesso! ");
		System.out.println("Dados da conta criada: ");
		System.out.println(conta);
		System.out.println();
		
		Utils.pausar(2);
		
		Banco.menu();
	}
	
	public static void efetuar_levantamento()
	{
		System.out.println("Numero da conta: ");
		int numero = Banco.teclado.nextInt();
		
		Conta conta = Banco.buscar_conta_por_numero(numero);
		
		if(conta != null) {
			System.out.println("Informe o valor para levantamento: ");
			Double valor = Banco.teclado.nextDouble();
			
			conta.levantar(valor);
		}
		else {
			System.out.println("Nao foi encontrada a conta número " + numero);
		}
		
		Utils.pausar(3);
		Banco.menu();
	}
	
	public static void efetuar_deposito()
	{
		System.out.println("Numero da conta: ");
		int numero = Banco.teclado.nextInt();
		
		Conta conta = Banco.buscar_conta_por_numero(numero);
		
		if(conta != null) {
			System.out.println("Informe o valor do deposito: ");
			Double valor = Banco.teclado.nextDouble();
			
			conta.depositar(valor);
		}
		else {
			System.out.println("Nao foi encontrada a conta número " + numero);
		}
		
		Utils.pausar(3);
		Banco.menu();	
	}
	
	public static void efetuar_transferencia()
	{
		System.out.println("Numero da sua conta: ");
		int numero_o = Banco.teclado.nextInt();
		
		Conta conta_o = Banco.buscar_conta_por_numero(numero_o);
		
		if (conta_o != null) {
			System.out.println("Informe o número da conta destino: ");
			int numero_d = Banco.teclado.nextInt();

			Conta conta_d = Banco.buscar_conta_por_numero(numero_d);
			
			if (conta_d != null) {
				System.out.println("Informe o valor da transferencia: ");
				Double valor = Banco.teclado.nextDouble();
				
				conta_o.transferir(conta_d, valor);

			} else {
				System.out.println("Nao foi encontrada a conta destino número " + numero_d);

			}

		} else {
			System.out.println("Nao foi encontrada a conta número " + numero_o);
		}
		
		Utils.pausar(3);
		Banco.menu();
		
	}
	
	public static void listar_contas()
	{
		if(Banco.contas.size() > 0) {
			System.out.println("Listagem de contas");
			System.out.println();
			
			for(Conta conta : Banco.contas) {
				System.out.println(conta);
				System.out.println();
				Utils.pausar(1);

			}
			System.out.println();
		} else {
			System.out.println("Nao existem contas criadas ainda");
		}
		Utils.pausar(3);
		Banco.menu();
	}
	
	private static Conta buscar_conta_por_numero(int numero) {
		Conta c = null;
		if(Banco.contas.size() > 0) {
			for (Conta conta : Banco.contas) {
				if(conta.get_numero() == numero) {
					c = conta;
				}
			}
		}
		
		return c;
	}
	

}
