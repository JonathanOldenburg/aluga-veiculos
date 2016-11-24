package edu.asselvi.model.bean;

public class Cliente {
	
	private int id; 
	private String nome;
	private String endereco;
	private String email;
	private int cpf;
	private String telefone;


	public Cliente(int id, String nome, String endereco, int cpf, String telefone) {
		setId(id);
		setNome(nome);
		setEndereco(endereco);
		setCpf(cpf);
		setTelefone(telefone);
	}
	
	public Cliente(){
		this(0,"Sem nome", "Sem endereço", 0, ""); 
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

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
		return "ID............:" + getId()
		     + "\nNome..........: " + getNome() 
			 + "\nEndereço......: " + getEndereco() 
			 + "\nCPF...........: " + getCpf()
			 + "\nTelefone......: " + getTelefone();
	}

}
