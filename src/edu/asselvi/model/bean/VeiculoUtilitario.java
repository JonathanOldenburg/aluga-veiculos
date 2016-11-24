package edu.asselvi.model.bean;

public class VeiculoUtilitario extends Veiculo{
	
	private double cargaMaxima;

	VeiculoUtilitario(int id, String placa, String modelo, int ano, int id_Cor, String cor, double diaria, double cargaMaxima, boolean ativo) {
		super(id, placa, modelo, ano, id_Cor, cor, diaria, ativo);
		setCargaMaxima(cargaMaxima);
	}

	public VeiculoUtilitario() {
		this(0,"Sem placa", "Sem modelo",0, 0, "Sem cor", 0.0, 0.0, false);
	}

	public double getCargaMaxima() {
		return cargaMaxima;
	}

	public void setCargaMaxima(double cargaMaxima) {
		this.cargaMaxima = cargaMaxima;
	}
	
	@Override
	public String toString() {
		return "Placa.........: " + getPlaca() 
			 + "Modelo........: " + getModelo() 
			 + "Ano...........: " + getAno()
			 + "Cor...........: " + getCor()
			 + "Diaria........: " + getDiaria()
			 + "Carga M�xima..: " + getCargaMaxima();
	}

}
