package br.edu.asselvi.model;

import java.io.Serializable;

import br.edu.asselvi.model.dao.Field;
import br.edu.asselvi.model.dao.FieldTypes;
import br.edu.asselvi.model.dao.Table;

@Table("pessoas")
public class TesteBean implements Serializable {

    private static final long serialVersionUID = 4568670420344055371L;

    @Field(name="codigo", type=FieldTypes.INT)
    private int codigo;
    
    @Field(name="nome", type=FieldTypes.VARCHAR)
    private String nome;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
