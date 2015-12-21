package ex3and4;

public class Cosinus extends OneArgument{
	
	public Cosinus(Expression expr){
		super(expr);
	}
	
	@Override
	public double compute(){
		return Math.cos(super.compute());
	}
	
	@Override
	public String toString(){
		return "cos(" + expr.toString() + ")";
	}
}
