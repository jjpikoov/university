package ex3and4;

public class TwoArguments extends OneArgument{
	
	protected Expression expr2;
	
	public TwoArguments(Expression expr, Expression expr2){
		super(expr);
		this.expr2 = expr2;
	}
	
	public Expression getExpr1(){
		return expr;
	}
	
	public Expression getExpr2(){
		return expr2;
	}

	@Override
	public double compute(){
		return 0;
	}
	
	@Override
	public boolean equals(Object o){
		if (o.getClass().getName().equals(this.getClass().getName())){
			if (((TwoArguments) o).getExpr1().equals(this.getExpr1()) && ((TwoArguments) o).getExpr2().equals(this.getExpr2()))
				return true;
		}
		return false;
	}
}
