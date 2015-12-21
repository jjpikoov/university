/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Functions.TwoArgument;

import fifthlist.Exceptions.RpnException;
import fifthlist.Exceptions.RpnTooManyArgumentsExeption;
import fifthlist.Functions.Function;

/**
 *
 * @author jjpikoov
 * Two arguments function
 */
public class TwoArgument extends Function{
    
    protected int ar = 2;
    protected double arg1;
    protected double arg2;
    
    @Override
    public int arity() {
        return 2;
    }

    @Override
    public int missingArguments() {
        return this.ar;
    }

    @Override
    public void addArgument(double arg) throws RpnException {
        if (this.ar == 0)
            throw new RpnTooManyArgumentsExeption();
        else if (this.ar == 2){
            this.arg1 = arg;
            this.ar--;
        }
        else if (this.ar == 1){
            this.arg2 = arg;
            this.ar--;
        }
    }

    @Override
    public double compute() throws RpnException {
        throw new RpnException("You can't use TwoArgument mocup class!");
    }
    
}