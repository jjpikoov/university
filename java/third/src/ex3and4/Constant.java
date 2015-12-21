package ex3and4;

public class Constant extends Expression{
	public double constant;
	
	public Constant(double constant){
		this.constant = constant;
	}

	@Override
	public double compute(){
		return this.constant;
	}
	
	@Override
	public String toString(){
		return Double.toString(this.constant);
	}
	
	@Override
	public boolean equals(Object o){
		if (o.getClass().getName().equals(this.getClass().getName())){
			if (((Constant) o).constant == this.constant)
				return true;
		}
		return false;
	}
}
