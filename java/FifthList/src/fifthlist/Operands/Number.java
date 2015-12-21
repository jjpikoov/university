/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Operands;

/**
 *
 * @author jjpikoov
 * Number class with some value
 */
public class Number extends Operand{
    
    private final double value;
    
    public Number(double value){
        this.value = value;
    }
    
    @Override
    public double compute(){
        return this.value;
                
    }
    
}
