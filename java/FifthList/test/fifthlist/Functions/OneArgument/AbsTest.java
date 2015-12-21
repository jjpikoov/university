/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Functions.OneArgument;

import fifthlist.Exceptions.RpnException;
import fifthlist.Exceptions.RpnNotEnoughArgumentsException;
import fifthlist.Exceptions.RpnTooManyArgumentsExeption;
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
public class AbsTest {
    
    public AbsTest() {
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
     * Test of arity method, of class Abs.
     */
    @Test
    public void testArity() {
        System.out.println("arity");
        Abs instance = new Abs();
        int expResult = 1;
        int result = instance.arity();
        assertEquals(expResult, result);
       }

    /**
     * Test of missingArguments method, of class Abs.
     */
    @Test
    public void testMissingArguments() throws RpnException {
        System.out.println("missingArguments");
        Abs instance = new Abs();
        int expResult = 1;
        int result = instance.missingArguments();
        assertEquals(expResult, result);
        
        instance.addArgument(10);
        expResult = 0;
        result = instance.missingArguments();
        assertEquals(expResult, result);
    }

    /**
     * Test of addArgument method, of class Abs.
     * @throws java.lang.Exception
     */
    @Test(expected = RpnTooManyArgumentsExeption.class)
    public void testAddArgument() throws Exception {
        System.out.println("addArgument");
        double arg = 0.0;
        Abs instance = new Abs();
        instance.addArgument(arg);
        instance.addArgument(20);
  
    }

    /**
     * Test of compute method, of class Abs.
     */
    @Test(expected = RpnNotEnoughArgumentsException.class)
    public void testCompute() throws Exception {
        System.out.println("compute");
        Abs instance = new Abs();
        double expResult = 0.0;
        double result = instance.compute();
        assertEquals(expResult, result, 0.0);
 
    }

}
