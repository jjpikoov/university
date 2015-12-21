/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Collections;

import fifthlist.Exceptions.RpnException;
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
public class ExpressionTest {
    
    public ExpressionTest() {
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
     * Test of parse method, of class Expression.
     */
    @Test
    public void testParse() throws RpnException {
        System.out.println("parse");
        String exp = "2 2 + var + var2 + -1 * Abs";
        HashMap<String, Double> vars = new HashMap<String, Double>();
        vars.put("var", 1.);
        vars.put("var2", 2.);
        
        Expression instance = new Expression(exp, vars);
        instance.parse();
        instance.compute();
        System.out.println(instance.returrn());
    
    }

  
    
}
