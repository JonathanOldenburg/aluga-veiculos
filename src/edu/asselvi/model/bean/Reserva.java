package edu.asselvi.model.bean;

import java.util.Date;

public class Reserva {
	private int id;

	private Date inicio;
	private Date fim;
	private int id_Cliente;
	private String dsc_Cliente;
	private int id_Carro;
	private String dsc_Carro;
	private boolean reservou;

	public Reserva(int id, Date inicio, Date fim,int id_Cliente, String cliente, int id_Carro, String dsc_Carro, boolean reservou) {
		setId(id);
		setInicio(inicio);
		setFim(fim);
		setId_Cliente(id_Cliente);
		setCliente(cliente);
		setReservou(reservou);
	}
	
	public Reserva() {
		this(0, new Date(), new Date(), 0, "Cliente sem nome", 0, "Carro sem nome",false);
	}

	public int getId_Cliente() {
		return id_Cliente;
	}

	public void setId_Cliente(int id_Cliente) {
		this.id_Cliente = id_Cliente;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}
	
	public String getDsc_Cliente() {
		return dsc_Cliente;
	}

	public void setCliente(String dsc_Cliente) {
		this.dsc_Cliente = dsc_Cliente;
	}

	public boolean isReservou() {
		return reservou;
	}

	public void setReservou(boolean reservou) {
		this.reservou = reservou;
	}
	
	public int getId_Carro() {
		return id_Carro;
	}
	

	public String getDsc_Carro() {
		return dsc_Carro;
	}

	public void setDsc_Carro(String dsc_Carro) {
		this.dsc_Carro = dsc_Carro;
	}


	public void setId_Carro(int id_Carro) {
		this.id_Carro = id_Carro;
	}
	
	@Override
	public String toString() {
		return "Inicio........: " + getInicio() +
			 "\nFim...........: " + getFim() + 
			 "\nCliente.......: " + getDsc_Cliente() +
			 "\nCarro.........: " + getDsc_Carro() +
			 "\nReservou......: " + (isReservou() ? "S" : "N");
	}

}
