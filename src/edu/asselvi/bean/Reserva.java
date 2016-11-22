package edu.asselvi.bean;

import java.util.Date;

public class Reserva {
	private int id;

	private Date inicio;
	private Date fim;
	private int id_Cliente;
	//private String cliente;             ???????   se tiver certo tem que atualizar o reservaDAO
	private int id_Carro;
	private boolean reservou;

	public Reserva(int id, Date inicio, Date fim,int id_Cliente, boolean reservou) {
		setId(id);
		setInicio(inicio);
		setFim(fim);
		setId_Cliente(id_Cliente);
		setReservou(reservou);
	}
	
	public Reserva() {
		this(0, new Date(), new Date(), 0, false);
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
		fim = fim;
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

	public void setId_Carro(int id_Carro) {
		this.id_Carro = id_Carro;
	}
	
	@Override
	public String toString() {
		return "Inicio........: " + getInicio() + "Fim...........: " + getFim() //+ "Cliente.......: " + getCliente() como vai ficar esse cliente aq
		
				+ "Reservou......: " + isReservou();
	}

}
