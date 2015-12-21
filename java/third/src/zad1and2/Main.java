package zad1and2;

import test.FourthTest;

public class Main {

	public static void main(String[] args) {
		Pair p1 = new Pair("user1");
		Pair p2 = new Pair("user1");
		Pair p3 = new Pair("user2");
		
		p1.setValue(1);
		p2.setValue(2);
		p3.setValue(1);
		
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		System.out.println(p1);
		System.out.println("=========================");
		
		
		Set set = new Set();
		set.add(p1);
		//set.add(p2);
		set.add(p3);
		System.out.println(set.howManyPairs());
		System.out.println();

		System.out.println(set.getValueFromPair("user1"));
		System.out.println(set.find("user2"));
		System.out.println();

		Pair p4 = new Pair("user10");
		p4.setValue(10);
		set.update(p4);
		System.out.println(set.howManyPairs());
		System.out.println(set.find("user10"));;
		Pair p5 = new Pair("user10");
		p5.setValue(20);
		set.update(p5);
		System.out.println(set.howManyPairs());
		System.out.println(set.find("user10"));
		System.out.println();
		
		set.clear();
		System.out.println(set.howManyPairs());
		System.out.println(set.find("user10"));


		System.out.println("========THIRD============");
		FourthTest ft = new FourthTest();
		ft.test();
		
		
	
	}

}
