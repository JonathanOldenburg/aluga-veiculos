package edu.asselvi.model.bean;

public class Locacao {
	
	private int id;
	private int id_Reserva;
	private boolean entrege;
	
	public Locacao(int id, int id_Reserva, boolean entrege){
		setId(id);
		setId_Reserva(id_Reserva);
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
	public int getId_Reserva() {
		return id_Reserva;
	}
	public void setId_Reserva(int id_Reserva) {
		this.id_Reserva = id_Reserva;
	}
	public boolean isEntrege() {
		return entrege;
	}
	public void setEntrege(boolean entrege) {
		this.entrege = entrege;
	}

//	@Override
//	public String toString() {
//		return "Entrege: " + get // está entrege ou não? queria por um operador ternario 
//			 + "\nAtivo.........: " +  (isAtivo() ? "S" : "N");
//	}
}
