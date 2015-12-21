/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Calculator;

import java.util.HashMap;
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
public class RpnCalculatorTest {
    
    public RpnCalculatorTest() {
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
     * Test of start method, of class RpnCalculator.
     */
    @Test
    public void testStart() throws Exception {
        System.out.println("start");
        HashMap<String, Double> variables = new HashMap<String, Double>();
        RpnCalculator instance = new RpnCalculator(variables);
        instance.start();
    }
    
}
