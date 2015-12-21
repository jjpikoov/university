/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourthlist.tools;

/**
 *
 * @author jjpikoov
 */
public class Pair implements Comparable<Pair>, Cloneable{
    
    /** Fullfill contructor with key which is type of String */
    public Pair(String key) {
        this.key = key;
    }
    
    /** Key of pair */
    public final String key;
    /** Value of pair */
    private double value;

    /** Getter for value */
    public double getValue() {
        return value;
    }
    
    /** Setter for value */
    public void setValue(double value) {
        this.value = value;
    }
    
    /** Compare to implementation of Pair */
    @Override
    public int compareTo(Pair p){
        if (this.getValue() == p.getValue())
            return 0;
        else if (this.getValue() < p.getValue())
            return -10;
        else
            return 10;
    }
    /** Equals implementation */
    @Override
    public boolean equals(Object o){
        if (o.getClass().getName().equals(this.getClass().getName())){
            if (((Pair) o).key.equals(this.key))
                return true;
        }
        return false;
    }
    
    /** ToString overwritten */
    @Override
    public String toString(){
        return "[" + this.key + " --> " + this.value + "]";
    }
    
    /** Clone pair */
    @Override
    public Pair clone(){
        Pair newPair = new Pair(this.key);
        newPair.setValue(this.getValue());
        return newPair;
    }
}
