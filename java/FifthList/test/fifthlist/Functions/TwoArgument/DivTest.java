/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Functions.TwoArgument;

import fifthlist.Exceptions.RpnDivisionByZeroException;
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
public class DivTest {
    
    public DivTest() {
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
     * Test of addArgument method, of class Div.
     */
    @Test(expected = RpnDivisionByZeroException.class)
    public void testAddArgument() throws Exception {
        System.out.println("addArgument");
        double arg = 0.0;
        Div instance = new Div();
        instance.addArgument(arg);
        instance.addArgument(0);
        assertEquals(instance.missingArguments(), 0);
    }
    
}
