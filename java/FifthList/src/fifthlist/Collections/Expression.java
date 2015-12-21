/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Collections;

import fifthlist.Exceptions.RpnEmptyStackException;
import fifthlist.Exceptions.RpnException;
import fifthlist.Functions.Constants.E;
import fifthlist.Functions.Constants.Pi;
import fifthlist.Functions.Function;
import fifthlist.Functions.OneArgument.Abs;
import fifthlist.Functions.OneArgument.Acot;
import fifthlist.Functions.OneArgument.Atan;
import fifthlist.Functions.OneArgument.Ceil;
import fifthlist.Functions.OneArgument.Cos;
import fifthlist.Functions.OneArgument.Exp;
import fifthlist.Functions.OneArgument.Floor;
import fifthlist.Functions.OneArgument.Ln;
import fifthlist.Functions.OneArgument.OneArgument;
import fifthlist.Functions.OneArgument.Sgn;
import fifthlist.Functions.OneArgument.Sin;
import fifthlist.Functions.TwoArgument.Div;
import fifthlist.Functions.TwoArgument.Log;
import fifthlist.Functions.TwoArgument.Max;
import fifthlist.Functions.TwoArgument.Minus;
import fifthlist.Functions.TwoArgument.Mul;
import fifthlist.Functions.TwoArgument.Plus;
import fifthlist.Functions.TwoArgument.Pow;
import fifthlist.Functions.TwoArgument.TwoArgument;
import java.util.HashMap;
import fifthlist.Operands.Number;
import fifthlist.Operands.Variable;
/**
 *
 * @author jjpikoov
 * Main class for parsing and calculating expressions in RPN
 */
public class Expression {
    private Queue queue = new Queue();
    private Stack stack = new Stack();
    private HashMap<String, Double> variables;
    private String exp;
    
    /** Constructor needs expression and possible variables */
    public Expression(String exp, HashMap<String, Double> variables){
        this.exp = exp;
        this.variables = variables;
    }
    
    /** Parsing method, parses tokens and adds them to queue */
    public void parse(){
        for (String token : this.exp.split("\\s")){
            Double tokenNum = null;
            try{
                tokenNum = Double.parseDouble(token);
            }
            catch(NumberFormatException e){}
            if (tokenNum != null){
                this.queue.insert(new Elem(new Number(tokenNum)));
            }
            else if (token.equals("+")){
                queue.insert(new Elem((new Plus())));
            }
            else if (token.equals("-")){
                queue.insert(new Elem(new Minus()));
            }
            else if (token.equals("/")){
                queue.insert(new Elem(new Div()));
            }
            else if (token.equals("*")){
                queue.insert(new Elem(new Mul()));
            }
            else if (token.equals("Abs")){
                queue.insert(new Elem(new Abs()));
            }
            else if (token.equals("Sgn")){
                queue.insert(new Elem(new Sgn()));
            }
            else if (token.equals("Floor")){
                queue.insert(new Elem(new Floor()));
            }
            else if (token.equals("Ceil")){
                queue.insert(new Elem(new Ceil()));
            }
            else if (token.equals("Sin")){
                queue.insert(new Elem(new Sin()));
            }
            else if (token.equals("Cos")){
                queue.insert(new Elem(new Cos()));
            }
            else if (token.equals("Atan")){
                queue.insert(new Elem(new Atan()));
            }
            else if (token.equals("Acot")){
                queue.insert(new Elem(new Acot()));
            }
            else if (token.equals("Ln")){
                queue.insert(new Elem(new Ln()));
            }
            else if (token.equals("Exp")){
                queue.insert(new Elem(new Exp()));
            }
            else if (token.equals("Pi")){
                queue.insert(new Elem(new Pi()));
            }
            else if (token.equals("E")){
                queue.insert(new Elem(new E()));
            }
            else if (token.equals("Min")){
                queue.insert(new Elem(new Minus()));
            }
            else if (token.equals("Max")){
                queue.insert(new Elem(new Max()));
            }
            else if (token.equals("Log")){
                queue.insert(new Elem(new Log()));
            }
            else if (token.equals("Pow")){
                queue.insert(new Elem(new Pow()));
            }
            else {
                queue.insert(new Elem(new Variable(token)));
            }
        }
    }
    
    /** Method takes elements from Queue and compute them with stack */
    public void compute() throws RpnEmptyStackException, RpnException{
        
        while (!queue.isEmpty()){
            
            Elem eq = queue.delete();
            

            if (eq.value instanceof Number){
                Number val = (Number) eq.value;
                Elem n = new Elem(val.compute());
                stack.insert(n);
            }
            else if (eq.value instanceof Variable){
                Variable val = (Variable) eq.value;
                val.container = this.variables;
                Elem n = new Elem(val.compute());
                stack.insert(n);
            }
            else if (eq.value instanceof OneArgument){
                double arg1 = (double) stack.delete().value;
                OneArgument function = (OneArgument) eq.value;
                while (function.missingArguments() > 0){
                    function.addArgument(arg1);
                }
                stack.insert(new Elem(function.compute()));
            }
            else if (eq.value instanceof TwoArgument){
                double arg1 = (double) stack.delete().value;
                double arg2 = (double) stack.delete().value;
                TwoArgument function = (TwoArgument) eq.value;
                function.addArgument(arg1);
                function.addArgument(arg2);
                stack.insert(new Elem(function.compute()));
                }
            else if ((eq.value instanceof E) || (eq.value instanceof Pi)){
                Function function = (Function) eq.value;
                stack.insert(new Elem(function.compute()));
            }
        }
    }
    
    /** Method for returning final value */
    public double returrn() throws RpnEmptyStackException{
        return (double) stack.delete().value;
    }
    
}
