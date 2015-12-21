package ex3and4;

public class Sinus extends OneArgument{
	
	public Sinus(Expression expr){
		super(expr);
	}
	
	@Override
	public double compute(){
		return Math.sin(super.compute());
	}
	
	@Override
	public String toString(){
		return "sin(" +  expr.toString() + ")";
	}

}
