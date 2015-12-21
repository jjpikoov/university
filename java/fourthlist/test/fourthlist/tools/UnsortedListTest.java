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
public class UnsortedListTest {
    
    public UnsortedListTest() {
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

    @Test
    public void testSomeMethod() {
       UnsortedList ul = new UnsortedList();
       
       Pair p1 = new Pair("p1");
       p1.setValue(100);
       Pair p2 = new Pair("p2");
       p2.setValue(500);
       Pair p3 = new Pair(("p3"));
       p3.setValue(1);
       ul.beg.insertPair(p1);
       ul.beg.insertPair(p2);
       ul.beg.insertPair(p3);
       
        assertTrue(ul.beg.theGreatest().equals(p2));
    }
    @Test
    public void removePairTest(){
       
       UnsortedList ul = new UnsortedList();
       
       Pair p1 = new Pair("p1");
       p1.setValue(100);
       Pair p2 = new Pair("p2");
       p2.setValue(500);
       Pair p3 = new Pair(("p3"));
       p3.setValue(1);
       ul.beg.insertPair(p1);
       ul.beg.insertPair(p2);
       ul.beg.insertPair(p3);
       
        System.out.println("before");
        ul.beg.printPairs(ul.beg);
        ul.beg.removePair(p3);
        System.out.println("after");
        ul.beg.printPairs(ul.beg);
       
       
    }
    @Test
    public void removeGreatest(){
       UnsortedList ul = new UnsortedList();
       
       Pair p1 = new Pair("p1");
       p1.setValue(100);
       Pair p2 = new Pair("p2");
       p2.setValue(500);
       Pair p3 = new Pair(("p3"));
       p3.setValue(1);
       ul.beg.insertPair(p1);
       ul.beg.insertPair(p2);
       ul.beg.insertPair(p3);
       
        System.out.println("before");
        ul.beg.printPairs(ul.beg);
        Pair foo = ul.beg.removeGreatest();
        System.out.println("after");
        ul.beg.printPairs(ul.beg);
        assertTrue(foo.equals(p2));
    }
    
    @Test
    public void sizeTest(){
       UnsortedList ul = new UnsortedList();
       
       Pair p1 = new Pair("p1");
       p1.setValue(100);
       Pair p2 = new Pair("p2");
       p2.setValue(500);
       Pair p3 = new Pair(("p3"));
       p3.setValue(1);
       ul.beg.insertPair(p1);
       ul.beg.insertPair(p2);
       ul.beg.insertPair(p3);
       


        assertTrue(ul.beg.size() == 3);
        Pair p4 = new Pair("p4");
        p4.setValue(2342);
        ul.beg.insertPair(p4);
        assertTrue(ul.beg.size() == 4);



    }
    
}
