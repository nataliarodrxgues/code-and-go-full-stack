package com.agencia.models;

public class Clientes {
	private int id_Cliente;
	private String CPF_Cliente;
	private String Nome_Cliente;
	private String Telefone_Cliente;
	private String Email_Cliente;
	private String Senha_Cliente; 
	private String Endereco_Cliente;
	
	
	public int getId_Cliente() {
		return id_Cliente;
	}
	public void setId_Cliente(int id_Cliente) {
		this.id_Cliente = id_Cliente;
	}
	public String getCPF_Cliente() {
		return CPF_Cliente;
	}
	public void setCPF_Cliente(String cPF_Cliente) {
		CPF_Cliente = cPF_Cliente;
	}
	public String getNome_Cliente() {
		return Nome_Cliente;
	}
	public void setNome_Cliente(String nome_Cliente) {
		Nome_Cliente = nome_Cliente;
	}
	public String getTelefone_Cliente() {
		return Telefone_Cliente;
	}
	public void setTelefone_Cliente(String telefone_Cliente) {
		Telefone_Cliente = telefone_Cliente;
	}
	public String getEmail_Cliente() {
		return Email_Cliente;
	}
	public void setEmail_Cliente(String email_Cliente) {
		Email_Cliente = email_Cliente;
	}
	public String getSenha_Cliente() {
		return Senha_Cliente;
	}
	public void setSenha_Cliente(String senha_Cliente) {
		Senha_Cliente = senha_Cliente;
	}
	public String getEndereco_Cliente() {
		return Endereco_Cliente;
	}
	public void setEndereco_Cliente(String endereco_Cliente) {
		Endereco_Cliente = endereco_Cliente;
	}
}