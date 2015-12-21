package ex3and4;

public class Addition extends TwoArguments{
	
	public Addition(Expression expr1, Expression expr2){
		super(expr1, expr2);
	}
	
	@Override
	public double compute(){
		return super.expr.compute() + super.expr2.compute(); 
	}
	
	@Override
	public String toString(){
		return super.expr.toString() + " + " + super.expr2.toString();
	}
}
