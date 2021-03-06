/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Functions.OneArgument;

import fifthlist.Exceptions.RpnNotEnoughArgumentsException;

/**
 *
 * @author jjpikoov
 * Acot
 */
public class Acot extends OneArgument {
    
    @Override
    public double compute() throws RpnNotEnoughArgumentsException{
        if (super.missingArguments() == 0)
            return ((Math.PI / 2) - Math.atan(super.arg1));
        else
            throw new RpnNotEnoughArgumentsException();
    }
    
}
