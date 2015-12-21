/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sixthlist.algorithms;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jjpikoov
 */
public class BSTTest {

    @Test
    public void testString() {
        System.out.println("STRING TEST");
        
        String key = "foo";
        BST<String> instance = new BST<>();
        
        instance.insert("zawada");
        instance.insert("foo");
        instance.insert("abecadlo");
        instance.insert("zzz");
        instance.insert("zba");
        instance.insert(("zzzz"));
        instance.allInOrderTreeWalk();
        assertEquals(instance.size(), 6);
        
        boolean expResult = true;
        boolean result = instance.search(key);
        assertEquals(expResult, result);
        
        instance.remove("foo");
        instance.remove("zzz");
        
        System.out.println("");
        instance.allInOrderTreeWalk();

        result = instance.search(key);
        assertEquals(false, result);
        assertEquals(instance.size(), 4);
        
        assertEquals(instance.max(), "zzzz");
        assertEquals(instance.min(), "abecadlo");
        
        instance.clear();
        assertEquals(instance.size(), 0);
        

    }    
    @Test(expected = NullPointerException.class)
    public void testNullPointerException(){
        BST<String> bst = new BST<>();
        BST<Integer> bstt = new BST<>();
        bst.insert(null);
        bstt.insert(null);
    }
    
    
    @Test
    public void testInteger(){
        BST<Integer> bst = new BST<>();
        assertEquals(bst.size(), 0);
        
        bst.insert(15);
        bst.insert(5);
        bst.insert(16);
        bst.insert(3);
        bst.insert(12);
        bst.insert(20);
        bst.insert(10);
        bst.insert(13);
        bst.insert(18);
        bst.insert(23);
        bst.insert(6);
        bst.insert(7);
        System.out.println("");
        bst.allInOrderTreeWalk();
        System.out.println("");

        assertEquals(bst.size(), 12);
        assertEquals(bst.max(), (Integer) 23);
        assertEquals(bst.min(), (Integer) 3);
        assertEquals(bst.search((Integer) 12), true);
        
        
        bst.remove((Integer) 5);
        bst.allInOrderTreeWalk();
        assertEquals(bst.size(), 11);
        
    }
    
    
}
