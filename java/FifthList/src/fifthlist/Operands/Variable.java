/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Operands;

import java.util.HashMap;

/**
 *
 * @author jjpikoov
 * Variable class
 */
public class Variable extends Operand{
    private final String name;
    public static HashMap<String, Double> container = new HashMap<>();
    
    /** Each variable has to have name */
    public Variable(String name){
        this.name = name;
    }
    
    /** Add varables */
    public static void addVariable(String name, double val){
        container.put(name, val);
    }
    
    /** Getting value of current variable */
    public double getValue(){
        return container.get(this.name);
    }
    
    /** Value of current variable */
    @Override
    public double compute(){
        return this.getValue();
    }
}
