/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Functions.TwoArgument;

import fifthlist.Exceptions.RpnNotEnoughArgumentsException;

/**
 *
 * @author jjpikoov
 * Addition function
 */
public class Plus extends TwoArgument{
    
    @Override
    public double compute() throws RpnNotEnoughArgumentsException{
        if (super.missingArguments() == 0)
            return super.arg1 + super.arg2;
        else
            throw new RpnNotEnoughArgumentsException();
    }
    
}
