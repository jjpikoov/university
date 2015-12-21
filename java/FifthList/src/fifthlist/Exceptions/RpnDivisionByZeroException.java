/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Exceptions;

/**
 *
 * @author jjpikoov
 * DivisionByZeroException
 */
public class RpnDivisionByZeroException extends RpnException{
    public RpnDivisionByZeroException(){
        super("Division by zero is not allowed");
    }
}
