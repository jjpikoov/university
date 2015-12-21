package ex3and4;

public class AbsoluteValue extends OneArgument{
	
	public AbsoluteValue(Expression expr){
		super(expr);
	}
	
	@Override
	public double compute(){
		double result = super.compute();
		if (result < 0)
			result *= -1;
		return result;
	}
	
	@Override
	public String toString(){
		return "|" + expr.toString() + "|";
	}
}
