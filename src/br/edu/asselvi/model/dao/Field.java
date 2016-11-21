package br.edu.asselvi.model.dao;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
/**
 * Indica que campo da tabela o atributo da classe representa.
 * @author jonathan
 *
 */
public @interface Field {

    /**
     * Nome do campo da tabela.
     */
    String name();
    /**
     * Tipo do campo no banco de dados.
     */
    FieldTypes type();
}
