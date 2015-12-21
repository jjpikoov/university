package zad1and2;

public class Pair {
	public final String key;
	private double value;
	
	public Pair(String k){
		this.key = k;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Para [key=" + key + ", value=" + value + "]";
	}
	
	@Override
	public boolean equals(Object o){
		if (o.getClass().getName() == "zad1.Para"){
			Pair opp = (Pair) o;
			if(opp.key.equals(this.key))
				return true;
		}
			
		return false;
	}
	
	

}
