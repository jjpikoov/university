/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Exceptions;

/**
 *
 * @author jjpikoov
 * RpnTooManyArgumentsException
 */
public class RpnTooManyArgumentsExeption extends RpnException{
    public RpnTooManyArgumentsExeption(){
        super("Function was given too many arguments");
    }
}
