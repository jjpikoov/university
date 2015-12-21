/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Functions.TwoArgument;

import fifthlist.Exceptions.RpnException;
import fifthlist.Exceptions.RpnLogFormatException;
import fifthlist.Exceptions.RpnNotEnoughArgumentsException;
import fifthlist.Exceptions.RpnTooManyArgumentsExeption;

/**
 *
 * @author jjpikoov
 * Logarithm function
 */
public class Log extends TwoArgument{
    
    @Override
    public void addArgument(double arg) throws RpnException {
        if (super.ar == 0)
            throw new RpnTooManyArgumentsExeption();
        else if (super.ar == 2){
            super.arg1 = arg;
            if (super.arg1 <= 0 || super.arg1 == 1)
                throw new RpnLogFormatException();
            super.ar--;
        }
        else if (super.ar == 1){
            super.arg2 = arg;
            if (super.arg2 <= 0)
                throw new RpnLogFormatException();
            super.ar--;
        }
    }
    
    @Override
    public double compute() throws RpnNotEnoughArgumentsException{
        if (super.missingArguments() == 0)
            return Math.log(super.arg1) / Math.log(super.arg2);
        else
            throw new RpnNotEnoughArgumentsException();
    }
}
