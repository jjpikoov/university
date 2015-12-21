package ex3and4;

public class Arctangens extends OneArgument{
	
	public Arctangens(Expression expr){
		super(expr);
	}
	
	@Override
	public double compute(){
		return Math.atan(super.compute());
	}
	
	@Override
	public String toString(){
		return "arct(" + expr.toString() + ")";
	}
}
