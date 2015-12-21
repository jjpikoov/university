/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Collections;

/**
 *
 * @author jjpikoov
 * Own implementation of Queue
 */
public class Queue {
    
    private Elem sentinel;
    
    public Queue(){
        this.sentinel = new Elem(null);
        this.sentinel.next = this.sentinel;
        this.sentinel.previous = this.sentinel;
    }
    
    /** Checks whether queue is empty */
    public boolean isEmpty(){
        return this.sentinel.next == this.sentinel && this.sentinel.previous == this.sentinel;
    }
       
    /** Method for inserting an element */
    public void insert(Elem e){
        e.next = this.sentinel.next;
        this.sentinel.next.previous = e;
        this.sentinel.next = e;
        e.previous = this.sentinel;
    }
    
    /** Method for deleting an element */
    public Elem delete(){
        Elem deleted = this.sentinel.previous;
        this.sentinel.previous.previous.next = this.sentinel;
        this.sentinel.previous = this.sentinel.previous.previous;
        return deleted;
    }
    
    /** Helper function to print elements */
    public void print(){
        Elem start = this.sentinel.next;
        while (start != this.sentinel){
            System.out.println(start.value);
            start = start.next;
        }
               
    }
}
