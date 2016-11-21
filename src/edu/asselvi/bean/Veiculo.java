package edu.asselvi.bean;

public class Veiculo {

	private int id;
	private String placa;
	private String modelo;
	private int ano;
	private String cor;
	private double diaria;
	private boolean ativo;

	public Veiculo(int id, String placa, String modelo, int ano, String cor, double diaria, boolean ativo){
		setId(id);
		setPlaca(placa);
		setModelo(modelo);
		setAno(ano);
		setCor(cor);
		setDiaria(diaria);
		
	}
	
	public Veiculo(){
		this(0,"ZZZ0000", "Sem modelo", 0, "Sem cor", 0.0, false);
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
		this.placa = placa.toUpperCase().substring(0,7);
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
		return "Placa.........: " + getPlaca() 
			 + "Modelo........: " + getModelo() 
			 + "Ano...........: " + getAno()
			 + "Cor...........: " + getCor()
			 + "Diaria........: " + getDiaria()
			 + "Ativo.........: " +  (isAtivo() ? "S" : "N");
	}

}
