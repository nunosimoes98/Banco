package view;

import helper.Utils;
import model.Cliente;
import model.Conta;

public class Teste {

	public static void main(String[] args) {
		Cliente nuno = new Cliente("Nuno Simões", "nunosimoes.dev@gmail.com", "4475-407", Utils.string_para_data("17/05/1981"));
		Cliente andreia = new Cliente("Andreia Rodrigues", "andreiaa_26@gmail.com", "4475-407", Utils.string_para_data("17/05/1982"));

//		System.out.println(nuno);
//		System.out.println(andreia);

		Conta c101 = new Conta(nuno);
		Conta c102 = new Conta(andreia);
		
		// depositar um valor positivo
		c101.depositar(500.00);
		c102.depositar(500.00);		
		
		// set limite c101
		c101.set_limite(200.0);
		
		// levantar um valor maior que o da conta
//		c101.levantar(600.0);
		

		// transferir 100
		c101.transferir(c102, 100.0);
		
		System.out.println(c101);
		System.out.println(c102);


	}

}
