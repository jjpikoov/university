/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Functions.Constants;

import fifthlist.Exceptions.RpnException;
import fifthlist.Exceptions.RpnTooManyArgumentsExeption;
import fifthlist.Functions.Function;

/**
 *
 * @author jjpikoov
 * E
 */
public class E extends Function{

    @Override
    public int arity() {
        return 0;
    }

    @Override
    public int missingArguments() {
        return 0;
    }

    @Override
    public void addArgument(double arg) throws RpnException {
        throw new RpnTooManyArgumentsExeption();
    }

    @Override
    public double compute() throws RpnException {
        return Math.E;
    }
    
    
}
