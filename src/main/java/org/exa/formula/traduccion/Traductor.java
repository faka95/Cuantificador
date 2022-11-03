package org.exa.formula.traduccion;


import org.exa.Catedra;
import org.mariuszgromada.math.mxparser.Expression;


public abstract class Traductor {
    
    protected Expression e = new Expression();
    protected Catedra catedra;

    public abstract Double getValue();

}