package model;

import helper.Utils;

public class Conta {
	private static int codigo = 1001; 
	
	private int numero;
	private Cliente cliente;
	private Double saldo = 0.0;
	private Double saldo_total;
	
	
	public Conta(Cliente cliente) {
		this.numero = Conta.codigo;
		this.cliente = cliente;
		Conta.codigo++;
		this.atualiza_saldo_total();
	}
	
	
	public Cliente get_cliente() {
		return cliente;
	}
	public void set_cliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Double get_saldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public int get_numero() {
		return numero;
	}
	public Double get_saldo_total() 
	{
		return saldo_total;
	}
	
	private void atualiza_saldo_total() 
	{
		this.saldo_total = this.get_saldo();
	}
	
	public String toString() 
	{
		return "Numero da Conta: " + this.get_numero() + 
				"\nCliente: " + this.cliente.get_nome() +
				"\nSaldo Total" + Utils.doubleParaString(this.get_saldo_total());
	}
	
	public void depositar(Double valor) 
	{
		if(valor > 0) 
		{
			this.saldo = this.get_saldo() + valor;
			this.atualiza_saldo_total();
			System.out.println("Depósito efetuado com sucesso!");
		} 
		else 
		{
			System.out.println("Erro ao efetuar deposito. Tente novamente!");
		}
	}
	
	public void levantar(Double valor) {
		if (valor > 0 && this.get_saldo_total() >= valor) 
		{
				this.saldo = this.get_saldo() - valor;
				this.atualiza_saldo_total();
				System.out.println("Levantamento efetuado com sucesso!");
		} 
		else
		{
			System.out.println("Levantamento não realizado. Tente novamente!");
		}
	}
	
	public void transferir(Conta destino, Double valor) {
		if (valor > 0 && this.get_saldo_total() >= valor) 
		{
				this.saldo = this.get_saldo() - valor;
				destino.saldo = destino.get_saldo() + valor;
				this.atualiza_saldo_total();
				destino.atualiza_saldo_total();
				System.out.println("Transferencia realizada com sucesso!");
		}
		else 
		{
			System.out.println("Transferencia não realizada. Tente novamente!");
		}
	}
	
	
}
