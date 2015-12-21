package ex3and4;

abstract public class Expression {
	abstract public double compute();
	
	 public static double add(Expression... expressions) {
		 double sum = 0;
		 for (Expression expr : expressions){
			 sum += expr.compute();
		 }
		 
		 return sum;
		 
	 }
	 
	 public static double mul(Expression... expressions) {
		 double product = 1;
		 for (Expression expr : expressions){
			 product *= expr.compute();
		 }
		 return product;
	 }
}
