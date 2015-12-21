/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourthlist.tools;

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
public class SortedListTest {
    
    public SortedListTest() {
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
     * Test of insert method, of class SortedList.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Pair p = new Pair("p");
        p.setValue(500);
        Pair p1 = new Pair("p1");
        p1.setValue(20);
        Pair p2 = new Pair("p2");
        p2.setValue(1);
        SortedList instance = new SortedList();
        instance.insert(p);
        instance.insert(p1);
        instance.insert(p2);
        instance.printPairs();

    }
    
}
