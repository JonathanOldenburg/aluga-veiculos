package edu.asselvi.model.bean;

public class Cor {
	
	private int id;
	private String dsc_cor;
	
	public Cor(int id, String dsc_cor){
		setId(id);
		setDsc_cor(dsc_cor);
	}
	
	public Cor(){
		this(0,"Sem cor");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDsc_cor() {
		return dsc_cor;
	}
	public void setDsc_cor(String dsc_cor) {
		this.dsc_cor = dsc_cor;
	}

}
