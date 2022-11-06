package org.exa.formula.traduccion;


import org.exa.Catedra;


/**
 * Clase que define el metodo getValue(), donde las clases que extiendan de esta
 * deberan definir el comportamiento para calcular el valor resultado de la variable
 */
public abstract class Traductor {
    
    protected Catedra catedra;

    public abstract Double getValue();

}