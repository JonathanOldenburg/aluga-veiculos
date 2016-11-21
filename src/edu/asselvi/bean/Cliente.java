package edu.asselvi.bean;

public class Cliente {
	
	private int id; // adicionado por Diogão dos algoritmos inteligentes e infaliveis
	private String nome;
	private String endereco;
	private String email;
	private String telefone;
	private int cpf;

	public String getNome() {
		return nome;
	}

	public Cliente(int id, String nome, String endereco, int cpf, int telefone) {
		setId(id);
		setNome(nome);
		setEndereco(endereco);
		setCpf(cpf);
		setTelefone(telefone);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente() {
		this("Sem nome", "Sem endereço", 0, null);
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
		return "Nome..........: " + getNome() 
			 + "Endereço......: " + getEndereco() 
			 + "CPF...........: " + getCpf()
			 + "Telefone......: " + getTelefone();
	}

}
