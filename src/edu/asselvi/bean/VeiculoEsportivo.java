package edu.asselvi.bean;

public class VeiculoEsportivo extends Veiculo {

	private double aceleracao;

	VeiculoEsportivo(int id, String placa, String modelo, int ano, String cor, double diaria, double aceleracao, boolean ativo) {
		super(id, placa, modelo, ano, cor, diaria, ativo);
		setAceleracao(aceleracao);
	}

	public VeiculoEsportivo() {
		this(0,"Sem placa", "Sem modelo", 0, "Sem cor", 0.0, 0.0, false);
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
