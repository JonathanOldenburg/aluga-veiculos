package edu.asselvi.model.bean;

public class Locacao {
	
	private int id;
	private int idReserva;
	private boolean entrege;
	
	public Locacao(int id, int id_Reserva, boolean entrege){
		setId(id);
		setIdReserva(id_Reserva);
		setId(id_Reserva);
	}
	
	public Locacao(){
		this(0,0, false);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int id_Reserva) {
		this.idReserva = id_Reserva;
	}
	public boolean isEntrege() {
		return entrege;
	}
	public void setEntrege(boolean entrege) {
		this.entrege = entrege;
	}

	@Override
	public String toString() {
		return "ID: " + getId()
		     + "\nReserva: " + getIdReserva()
		     + "\nEntrege: " + (isEntrege() ? "Entregue" : "Não entregue"); 
	}
}
