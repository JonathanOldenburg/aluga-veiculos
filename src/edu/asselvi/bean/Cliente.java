package edu.asselvi.bean;

public class Cliente {
	
	private int id; // adicionado por Diog�o dos algoritmos inteligentes e infaliveis
	private String nome;
	private String endereco;
	private int cpf;
	private String telefone;

	public Cliente(int id, String nome, String endereco, int cpf, String telefone) {
		setId(id);
		setNome(nome);
		setEndereco(endereco);
		setCpf(cpf);
		setTelefone(telefone);
	}
	
	public Cliente() {
		this(0,"Sem nome", "Sem endere�o", 0, ""); // ficou esse erro aq q eu n entendi
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Nome..........: " + getNome() 
			 + "Endere�o......: " + getEndereco() 
			 + "CPF...........: " + getCpf()
			 + "Telefone......: " + getTelefone();
	}

}
