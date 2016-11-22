package edu.asselvi.bean;

import java.util.Date;

public class Reserva {
	private int id;

	private Date inicio;
	private Date fim;
	private String cliente;
	private boolean reservou;

	Reserva(int id, Date inicio, Date fim, String cliente, boolean reservou) {
		setInicio(inicio);
		setFim(fim);
		setCliente(cliente);
		setReservou(reservou);
	}

	Reserva() {
		this(0, new Date(), new Date(), "Sem cliente", false);
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

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public boolean isReservou() {
		return reservou;
	}

	public void setReservou(boolean reservou) {
		this.reservou = reservou;
	}

	@Override
	public String toString() {
		return "Inicio........: " + getInicio() + "Fim...........: " + getFim() + "Cliente.......: " + getCliente()
				+ "Reservou......: " + isReservou();
	}

}
