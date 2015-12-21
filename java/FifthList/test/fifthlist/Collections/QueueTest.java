/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jjpikoov
 */
public class QueueTest {
    
    public QueueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class Queue.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Elem e = new Elem(10);
        Elem e2 = new Elem(20);
        Elem e3 = new Elem(30);
        Queue instance = new Queue();
        assertEquals(instance.isEmpty(), true);
        instance.insert(e);
        instance.insert(e2);
        instance.insert(e3);
        
        instance.delete();
        assertEquals(instance.isEmpty(), false);
        instance.delete();
        instance.delete();
        assertEquals(instance.isEmpty(), true);
        instance.delete();
        assertEquals(instance.isEmpty(), true);
        instance.print();
 
    }
}
