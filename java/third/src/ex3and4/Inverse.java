package ex3and4;

public class Inverse extends OneArgument{
	
	public Inverse(Expression expr){
		super(expr);
	}
	
	@Override
	public double compute(){
		double comp = super.compute();
		if (comp == 0){
			System.err.println("Division by zero!!!!");
		return 0;
		}
		else
			return 1/comp;
	}
	
	@Override
	public String toString(){
		return "inv(" + expr.toString() + ")";
	}
}
