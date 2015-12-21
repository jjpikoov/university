package ex3and4;

public class OneArgument extends Expression {
	
	protected Expression expr;
	
	public OneArgument(Expression expr){
		this.expr = expr;
	}
	
	public Expression getExpr(){
		return this.expr;
	}
	
	@Override
	public double compute(){
		return expr.compute();
	}
	
	@Override
	public String toString(){
		return this.expr.toString();
	}
	
	@Override
	public boolean equals(Object o){
		if (o.getClass().getName().equals(this.getClass().getName())){
			if (((OneArgument) o).getExpr().equals(this.expr))
				return true;
		}
		return false;
	}
}