/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Collections;

import com.sun.org.apache.bcel.internal.generic.InstructionConstants;
import fifthlist.Exceptions.RpnEmptyStackException;

/**
 *
 * @author jjpikoov
 * Own implementation of stack 
 */
public class Stack {
    
    private Elem sentinel;
    
    public Stack(){
        this.sentinel = new Elem(null);
        this.sentinel.next = this.sentinel;
        this.sentinel.previous = this.sentinel;
    }
    
    /** Method for inserting element */
    public void insert(Elem e){
        e.next = this.sentinel.next;
        this.sentinel.next.previous = e;
        this.sentinel.next = e;
        e.previous = this.sentinel;
    }
    
    /** Method for deleting an element from stack */
    public Elem delete() throws RpnEmptyStackException{
        if (this.sentinel.next == this.sentinel && this.sentinel.previous == this.sentinel)
            throw new RpnEmptyStackException();
        Elem deleted = this.sentinel.next;
        this.sentinel.next = this.sentinel.next.next;
        this.sentinel.next.next.previous = this.sentinel;
        return deleted;
    }
    
    /** Helper function to print full stack */
    public void print(){
        Elem start = this.sentinel.next;
        while (start != this.sentinel){
            System.out.println(start.value);
            start = start.next;
        }
    }
}
    
    
    

