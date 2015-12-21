package ex3and4;

import zad1and2.Pair;
import zad1and2.Set;

public class Variable extends Expression {
	private final String name;
	public static Set set = new Set();
	
	public Variable(String name){
		this.name = name;
	}
	
	public static void addVariable(String name, double value){
		Pair var = new Pair(name);
		var.setValue(value);
		set.add(var);
	}
	
	public double getValue(){
		return set.getValueFromPair(this.name);
	}

	@Override
	public double compute(){
		return this.getValue();
	}
	
	@Override
	public String toString(){
		return this.name;
	}
	
	@Override
	public boolean equals(Object o){
		if (o.getClass().getName().equals(this.getClass().getName())){
			if (((Variable)o).getValue() == this.getValue())
				return true;
		}
		return false;
	}
}
