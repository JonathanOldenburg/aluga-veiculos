package edu.asselvi.model.bean;

public class Cor {
	
	private int id;
	private String dscCor;
	
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
	public String getDscCor() {
		return dscCor;
	}
	public void setDsc_cor(String dsc_cor) {
		this.dscCor = dsc_cor;
	}

	@Override
	public String toString() {
	    return "ID : "+getId()+"\n"
	            + "Cor : "+getDscCor()
				 + "\n------------------------------------";
	}
}
