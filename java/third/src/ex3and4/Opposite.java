package ex3and4;

public class Opposite extends OneArgument{
	
	public Opposite(Expression expr){
		super(expr);
	}
	
	@Override
	public double compute(){
		return -1 * super.compute(); 
	}
	
	@Override 
	public String toString(){
		return "-" + super.toString();
	}
}
