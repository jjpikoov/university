/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifthlist.Calculator;

import fifthlist.Collections.Expression;
import fifthlist.Exceptions.RpnException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jjpikoov
 * RpnCalculator implementation.
 */
public class RpnCalculator {
    
    private Logger logger;
    private HashMap<String, Double> varables = new HashMap<String, Double>();
    
    /** You can give some variables in constructor */
    public RpnCalculator(HashMap<String, Double> variables){
        this.logger = Logger.getLogger("calc");
        this.varables = variables;
    }
    
    /** Main starting method */
    public void start() throws RpnException{
        
        Scanner scanner = new Scanner(System.in);
        
        while (true){
            System.out.print("Enter instruction: ");
            String currentLine = scanner.nextLine();
            
            if (currentLine.equals("calc")){
                System.out.print("Variable? ");
                String isVar = scanner.nextLine();
                String varName = null;
                if (isVar.equals("yes")){
                    System.out.print("Name: ");
                    varName = scanner.nextLine();
                    logger.log(Level.INFO, "Variable added");
                }
                System.out.print("Expression: ");
                String rpn = scanner.nextLine();

                Expression expr = new Expression(rpn, this.varables);
                expr.parse();
                expr.compute();
                double result = expr.returrn();
                this.logger.log(Level.INFO, Double.toString(result));
                if (isVar.equals("yes"))
                    varables.put(varName, result);
            }
            else if (currentLine.equals("exit")){
                logger.log(Level.INFO, "EXIT");
                System.exit(0);
            }
            else if (currentLine.equals("clear")){
                System.out.print("Want to clear some vars?: ");
                String answer = scanner.nextLine();
                if (answer.equals("yes")){
                    System.out.print("Vars to delete: ");
                    String[] varsToDelete = scanner.nextLine().split("\\s");
                    for (String var : varsToDelete){
                        this.varables.remove(var);
                    }
                    logger.log(Level.INFO, "Vars deleted");
                }
                else {
                    for (String key : this.varables.keySet()){
                        this.varables.remove(key);
                    }
                    logger.log(Level.INFO, "All vars deleted");
                }
            }
            else{
                throw new AssertionError();
            }
        }
    }
    
}
