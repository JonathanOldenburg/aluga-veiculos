package br.edu.asselvi.model.bean;

public class Veiculo {

	private String placa;
	private String modelo;
	private int ano;
	private String cor;
	private double diaria;
	
	public Veiculo(String placa, String modelo, int ano, String cor, double diaria){
		setPlaca(placa);
		setModelo(modelo);
		setAno(ano);
		setCor(cor);
		setDiaria(diaria);		
	}
	
	public Veiculo(){
		this("Sem placa", "Sem modelo", 0, "Sem cor", 0.0);
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
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
	
	@Override
	public String toString() {
		return "Placa.........: " + getPlaca() 
			 + "Modelo........: " + getModelo() 
			 + "Ano...........: " + getAno()
			 + "Cor...........: " + getCor()
			 + "Diaria........: " + getDiaria();
	}

}
