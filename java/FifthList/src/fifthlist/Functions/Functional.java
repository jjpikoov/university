/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Functions;

import fifthlist.Computable;
import fifthlist.Exceptions.RpnException;


/**
 *
 * @author jjpikoov
 * Extension of Computable interface.
 */
public interface Functional extends Computable{
    int arity();
    int missingArguments();
    void addArgument(double arg) throws RpnException;
}
