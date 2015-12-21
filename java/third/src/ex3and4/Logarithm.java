package ex3and4;

public class Logarithm extends TwoArguments{
	
	public Logarithm(Expression e1, Expression e2){
		super(e1, e2);
	}
	
	@Override
	public double compute(){
		return Math.log(super.expr.compute()) / Math.log(super.expr2.compute());
	}
	
	@Override
	public String toString(){
		return "log" + super.expr.toString() + "(" + super.expr2.toString() + ")";
	}
}
