package zad1and2;

public class Set {

	private int i = 0;
	private int numberOfElements;
	private Pair[] set;

	public Set() {
		this.numberOfElements = 1 << 21;
		set = new Pair[this.numberOfElements];
	}
	
	public Set(int numberOfElements){
		this.numberOfElements = numberOfElements;
		set = new Pair[this.numberOfElements];
	}
	
	public Pair find(String key){
		for (Pair pair : this.set){
			if (pair != null && pair.key.equals(key))
				return pair;
		}
		return null;
	}
	
	public void add(Pair pair) throws IllegalArgumentException {
		if (this.find(pair.key) != null)
			throw new IllegalArgumentException("Such key exists already!");
		
		if (i != this.set.length){
			set[this.i++] = pair;
		}
	}
	
	public double getValueFromPair(String key) throws IllegalArgumentException {
		Pair pair = this.find(key);
		if (pair == null)
			throw new IllegalArgumentException("No such key");
		return pair.getValue();
	}
	
	public void update(Pair pair){
		Pair p = this.find(pair.key);
		if (p == null)
			this.add(pair);
		else {
			p.setValue(pair.getValue());
		}
	}
	
	public int howManyPairs(){
		return this.i;
	}
	
	public void clear(){
		for (int j = 0; j < this.set.length; j++) {
			this.set[j] = null;
		}
		this.i = 0;
	}
}
