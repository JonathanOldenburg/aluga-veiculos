package edu.asselvi.model.bean;

import java.util.Date;

public class Reserva {
	private int id;

	private Date inicio;
	private Date fim;
	private int idCliente;
	private String dsc_Cliente;
	private int id_Carro;
	private String dsc_Carro;
	private boolean reservou;

	public Reserva(int id, Date inicio, Date fim,int id_Cliente, String cliente, int id_Carro, String dsc_Carro, boolean reservou) {
		setId(id);
		setInicio(inicio);
		setFim(fim);
		setIdCliente(id_Cliente);
		setCliente(cliente);
		setReservou(reservou);
	}
	
	public Reserva() {
		this(0, new Date(), new Date(), 0, "Cliente sem nome", 0, "Carro sem nome",false);
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int id_Cliente) {
		this.idCliente = id_Cliente;
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
	
	public int getIdCarro() {
		return id_Carro;
	}
	

	public String getDscCarro() {
		return dsc_Carro;
	}

	public void setDscCarro(String dsc_Carro) {
		this.dsc_Carro = dsc_Carro;
	}


	public void setIdCarro(int id_Carro) {
		this.id_Carro = id_Carro;
	}
	
	@Override
	public String toString() {
		return "ID............: " + getId() +
		     "\nInicio........: " + getInicio() +
			 "\nFim...........: " + getFim() + 
			 "\nCliente.......: " + getDsc_Cliente() +
			 "\nCarro.........: " + getDscCarro() +
			 "\nReservou......: " + (isReservou() ? "S" : "N")
			 + "\n------------------------------------";
	}

}
