/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Collections;

import fifthlist.Symbol;

/**
 *
 * @author jjpikoov
 * Some helper class for creating collections.
 */ 
public class Elem {
    
    public Elem next;
    public Elem previous;
    public Object value;
    
    public Elem(Object value){
        this.value = value;
    }
    
    public Elem(double value){
        this.value = value;
    }
}
