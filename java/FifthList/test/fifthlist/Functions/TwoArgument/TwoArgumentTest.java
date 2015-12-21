/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Functions.TwoArgument;

import fifthlist.Exceptions.RpnException;
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
public class TwoArgumentTest {
    
    public TwoArgumentTest() {
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
     * Test of arity method, of class TwoArgument.
     */
    @Test
    public void testArity() {
        System.out.println("arity");
        TwoArgument instance = new TwoArgument();
        int expResult = 2;
        int result = instance.arity();
        assertEquals(expResult, result);
    }

    /**
     * Test of missingArguments method, of class TwoArgument.
     */
    @Test
    public void testMissingArguments() throws RpnException {
        System.out.println("missingArguments");
        TwoArgument instance = new TwoArgument();
        int expResult = 2;
        int result = instance.missingArguments();
        assertEquals(expResult, result);
        
        instance.addArgument(90);
        expResult = 1;
        result = instance.missingArguments();
        assertEquals(expResult, result);
        
        instance.addArgument(80);
        expResult = 0;
        result = instance.missingArguments();
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of addArgument method, of class TwoArgument.
     */
    @Test(expected = RpnTooManyArgumentsExeption.class)
    public void testAddArgument() throws Exception {
        System.out.println("addArgument");
        double arg = 0.0;
        TwoArgument instance = new TwoArgument();
        instance.addArgument(arg);
        instance.addArgument(20);
        instance.addArgument(30);
    }
}
