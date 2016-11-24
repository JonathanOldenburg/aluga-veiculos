package edu.asselvi.model.bean;

public class Veiculo {

	private int id;
	private int ano;
	private int idCor;	
	private double diaria;
	private boolean ativo;
	private String placa;
	private String modelo;
	private String cor;

	public Veiculo(int id, String placa, String modelo, int ano, int id_Cor, String cor, double diaria, boolean ativo){
		setId(id);
		setPlaca(placa);
		setModelo(modelo);
		setAno(ano);
		setIdCor(id_Cor);
		setCor(cor);
		setDiaria(diaria);
		
	}
	
	public Veiculo(){
		this(0,"ZZZ0000", "Sem modelo", 0, 0,"Sem cor", 0.0, false);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
	    if (placa != null) {
	        this.placa = placa.toUpperCase().substring(0,7);
        }
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getIdCor() {
		return idCor;
	}

	public void setIdCor(int idCor) {
		this.idCor = idCor;
	}

	
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public double getDiaria() {
		return diaria;
	}

	public void setDiaria(double diaria) {
		this.diaria = diaria;
	}
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	@Override
	public String toString() {
		return "ID............:" + getId()
		     + "\nPlaca.........: " + getPlaca() 
			 + "\nModelo........: " + getModelo() 
			 + "\nAno...........: " + getAno()
			 + "\nCor...........: " + getCor()
			 + "\nDiaria........: " + getDiaria()
			 + "\nAtivo.........: " +  (isAtivo() ? "S" : "N");
	}

}
