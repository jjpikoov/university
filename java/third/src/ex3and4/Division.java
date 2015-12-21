package ex3and4;

public class Division extends TwoArguments{
	
	public Division(Expression e1, Expression e2){
		super(e1, e2);
	}
	
	@Override
	public double compute(){
		double r = super.expr2.compute();
		if (r == 0)
			System.err.println("Can't divide by zero!!!");
		return super.expr.compute() / super.expr2.compute();
	}
	
	@Override
	public String toString(){
		return super.expr.toString() + " / " + super.expr2.toString();
	}
}
