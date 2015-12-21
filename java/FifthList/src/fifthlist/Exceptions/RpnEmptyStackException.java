/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Exceptions;

/**
 *
 * @author jjpikoov
 * RpnEmptyStackException
 */
public class RpnEmptyStackException extends RpnException{
    
    public RpnEmptyStackException(){
        super("Empty stack");
    }
    
}
