package model;

import java.util.Date;

import helper.Utils;

public class Cliente {
	private static int contador = 101;
	
	private int codigo;
	private String nome;
	private String email;
	private String zip_code;
	private Date data_nascimento;
	private Date data_criacao;
	
	public Cliente(String nome, String email, String zip_code, Date data_nascimento) {
		this.codigo = Cliente.contador;
		this.nome = nome;
		this.email = email;
		this.zip_code = zip_code;
		this.data_nascimento = data_nascimento;
		this.data_criacao = new Date();
		Cliente.contador += 1;
	}
	
	public int get_codigo() {
		return this.codigo;
	}
	
	public String get_nome() {
		return nome;
	}
	public void set_nome(String nome) {
		this.nome = nome;
	}
	public String get_email() {
		return email;
	}
	public void set_email(String email) {
		this.email = email;
	}
	public String get_zip_code() {
		return zip_code;
	}
	public void set_zip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public Date get_data_nascimento() {
		return data_nascimento;
	}
	public void set_data_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public Date get_data_criacao() {
		return data_criacao;
	}
	public void set_data_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}
	
	public Date data_criacao() {
		return this.data_criacao;
	}
	
	public String toString() {
		return "Codigo: " + this.get_codigo() + 
				"\nNome: " + this.get_nome() +
				"\nEmail: " + this.get_email() + 
				"\nCodigo Postal: " + this.get_zip_code() + 
				"\nData de Nascimento: " + Utils.dateParaString(this.get_data_nascimento()) +
				"\nData de Criacao: " + Utils.dateParaString(this.data_criacao() )+ "\n";
	}
	
	

}
