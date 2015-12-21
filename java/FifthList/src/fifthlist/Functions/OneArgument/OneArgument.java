/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Functions.OneArgument;

import fifthlist.Exceptions.RpnException;
import fifthlist.Exceptions.RpnTooManyArgumentsExeption;
import fifthlist.Functions.Function;

/**
 *
 * @author jjpikoov
 * OneArgument function
 */
public class OneArgument extends Function{
    
       
    protected int ar = 1;
    protected double arg1;
    

    @Override
    public int arity() {
        return 1;
    }

    @Override
    public int missingArguments() {
        return this.ar;
    }

    @Override
    public void addArgument(double arg) throws RpnException {
        if (ar != 0){
            this.arg1 = arg;
            this.ar--;
        }
        else
            throw new RpnTooManyArgumentsExeption();
    }
    
    @Override
    public double compute() throws RpnException {
            throw new RpnException("You can't use OneArgument mocup class!");
    }
}
