/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist;

import fifthlist.Exceptions.RpnException;

/**
 *
 * @author jjpikoov
 * Computable interface.
 */

public interface Computable {
    double compute() throws RpnException;
}
