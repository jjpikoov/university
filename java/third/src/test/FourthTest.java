package test;


import ex3and4.Addition;
import ex3and4.Arctangens;
import ex3and4.Constant;
import ex3and4.Division;
import ex3and4.Exponent;
import ex3and4.Expression;
import ex3and4.Logarithm;
import ex3and4.Multiplication;
import ex3and4.Substraction;
import ex3and4.Variable;

public class FourthTest {
	
	
	public static Expression e;
	public void test(){
		Variable.addVariable("x", -1.678);
		Variable.addVariable("y", 1);

		e = new Addition(new Constant(3), new Constant(5));
		this.printExpression();
		
		e = new Addition(new Constant(2), new Multiplication(new Variable("x"), new Constant(7)));
		this.printExpression();
		
		e = new Division(new Substraction(new Multiplication(new Constant(3), new Constant(11)), new Constant(1)), new Addition(new Constant(7), new Constant(5)));
		this.printExpression();
		
		e = new Arctangens(new Division(new Multiplication(new Addition(new Variable("x"), new Constant(13)), new Variable("x")), new Constant(2)));
		this.printExpression();
		
		e = new Addition(new Exponent(new Constant(2), new Constant(5)), new Multiplication(new Variable("x"), new Logarithm(new Constant(2), new Variable("y"))));
		this.printExpression();
	
	}
	
	public void printExpression(){
		System.out.print(e.toString());
		System.out.print(" = ");
		System.out.print(e.compute());
		System.out.println();
	}
}
