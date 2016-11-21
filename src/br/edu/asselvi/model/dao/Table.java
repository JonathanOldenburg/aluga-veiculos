package br.edu.asselvi.model.dao;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
/**
 * Indica que tabela a classe ou interface está referenciando.
 * @author jonathan
 */
public @interface Table {

    /**
     * Retorna o nome da tabela
     * @return o nome da tabela
     */
    String value();
}
