package ex3and4;

public class Multiplication extends TwoArguments{
	
	public Multiplication(Expression e1, Expression e2){
		super(e1, e2);
	}
	
	@Override
	public double compute(){
		return super.expr.compute() * super.expr2.compute();
	}

	@Override
	public String toString(){
		return super.expr.toString() + " * " + super.expr2.toString();
	}
}
