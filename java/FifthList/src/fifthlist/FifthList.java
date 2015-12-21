/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist;

import fifthlist.Calculator.RpnCalculator;
import fifthlist.Exceptions.RpnException;
import java.util.HashMap;

/**
 *
 * @author jjpikoov
 * Class made only for tests for RPN calculator
 */
public class FifthList {
    
    /** Main method */
    public static void main(String[] args) throws RpnException {
        
        System.out.println("start");
        HashMap<String, Double> variables = new HashMap<String, Double>();
        RpnCalculator instance = new RpnCalculator(variables);
        instance.start();
    }
    
}
