package ex3and4;

public class Minimum extends TwoArguments{
	
	public Minimum(Expression e1, Expression e2){
		super(e1, e2);
	}
	
	@Override
	public double compute(){
		double r1 = super.expr.compute();
		double r2 = super.expr2.compute();
		if (r1 >= r2)
			return r2;
		else
			return r1;
	}
	
	@Override
	public String toString(){
		return Double.toString(Math.min(super.expr.compute(), super.expr2.compute()));
	}
}
