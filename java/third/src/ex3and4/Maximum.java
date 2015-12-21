package ex3and4;

public class Maximum extends TwoArguments{

	public Maximum(Expression e1, Expression e2){
		super(e1, e2);
	}
	
	@Override
	public double compute(){
		return Math.max(super.expr.compute(), super.expr2.compute());
	}
	
	@Override
	public String toString(){
		return Double.toString(Math.max(super.expr.compute(), super.expr2.compute()));
	}
	

}
