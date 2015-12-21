/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sixthlist.algorithms;

/**
 *
 * @author jjpikoov
 * @param <T>
 */
public interface Dict <T extends Comparable<T>>{
    boolean search(T key);
    void insert(T key);
    T remove(T key);
    T min();
    T max();
}
