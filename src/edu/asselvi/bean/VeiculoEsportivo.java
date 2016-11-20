package br.edu.asselvi.model.bean;

public class VeiculoEsportivo extends Veiculo {

	private double aceleracao;

	VeiculoEsportivo(String placa, String modelo, int ano, String cor, double diaria, double aceleracao) {
		super(placa, modelo, ano, cor, diaria);
		setAceleracao(aceleracao);
	}

	public VeiculoEsportivo() {
		this("Sem placa", "Sem modelo", 0, "Sem cor", 0.0, 0.0);
	}

	public double getAceleracao() {
		return aceleracao;
	}

	public void setAceleracao(double aceleracao) {
		this.aceleracao = aceleracao;
	}
	
	@Override
	public String toString() {
		return "Placa.........: " + getPlaca() 
			 + "Modelo........: " + getModelo() 
			 + "Ano...........: " + getAno()
			 + "Cor...........: " + getCor()
			 + "Diaria........: " + getDiaria()
			 + "Acelera��o.... :" + getAceleracao();
	}

}
