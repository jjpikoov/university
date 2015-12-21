/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sixthlist;

import sixthlist.algorithms.BST;

/**
 *
 * @author jjpikoov
 */
public class SixthList {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        
        bst.insert(0);
        bst.insert(1);
        bst.insert(0);
        bst.insert(300);
        bst.insert(500);
        bst.insert(1000);
        bst.allInOrderTreeWalk();
        
        System.out.println("");
        
        bst.remove(0);
        bst.remove(300);
        bst.insert(7);
        bst.clear();
        bst.allInOrderTreeWalk();
        System.out.println(bst.search(1000));
        System.out.println(bst.size());
        bst.allInOrderTreeWalk();
        
    }
    
}