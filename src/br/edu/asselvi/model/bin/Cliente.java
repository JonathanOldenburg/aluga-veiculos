package br.edu.asselvi.model.bin;

public class Cliente {

	private String nome ;
	private String endereco;
	private int cpf;
	private int telefone ;
	
	public String getNome() {
		return nome;
	}
	
	public Cliente(String nome, String endereco, int cpf, int telefone){
		setNome(nome);
		setEndereco(endereco);
		setCpf(cpf);
		setTelefone(telefone);		
	}
	
	public Cliente(){
		this("Sem nome", "Sem endereço", 0,0);
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString() { 
		return  "Nome........: " + getNome() +
				"Endereço....: " + getEndereco() +
				"CPF.........: " + getCpf() +
				"Telefone....: " + getTelefone();
	}
	
}
