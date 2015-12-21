/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Exceptions;

/**
 *
 * @author jjpikoov
 * RpnException
 */
public class RpnException extends Exception {
    public RpnException(String message){
        super(message);
    }
    public RpnException(){
        super("Reverse Polish Notation Exeption");
    }
}
