/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Functions.OneArgument;

import fifthlist.Exceptions.RpnException;
import fifthlist.Exceptions.RpnNotEnoughArgumentsException;

/**
 *
 * @author jjpikoov
 * Abs
 */
public class Abs extends OneArgument{
   
    @Override
    public double compute() throws RpnException {
        if (super.missingArguments() == 0)
            return Math.abs(super.arg1);
        else
            throw new RpnNotEnoughArgumentsException();
    }
    
}
