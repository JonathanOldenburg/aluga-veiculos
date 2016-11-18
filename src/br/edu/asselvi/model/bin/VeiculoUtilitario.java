package br.edu.asselvi.model.bin;

public class VeiculoUtilitario extends Veiculo{
	
	private double cargaMaxima;

	VeiculoUtilitario(String placa, String modelo, int ano, String cor, double diaria, double cargaMaxima) {
		super(placa, modelo, ano, cor, diaria);
		setCargaMaxima(cargaMaxima);
	}

	public VeiculoUtilitario() {
		this("Sem placa", "Sem modelo", 0, "Sem cor", 0.0, 0.0);
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
			 + "Carga Máxima..: " + getCargaMaxima();
	}

}
