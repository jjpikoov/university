package fourthlist.tools;

/**
 *
 * @author jjpikoov
 */
public class UnsortedList implements Cloneable { //,Priority{
    
    //to do implementation of comparable and priority
    protected class Node implements Cloneable, Comparable<Node>{
        Pair pair = null;
        Node next = null;
        Pair tg;

        public Node(){
            this.tg = new Pair("foo");
            tg.setValue(Double.MIN_VALUE);
        }
        
        void insertPair(Pair p){
            if (this.pair == null){
                this.pair = p.clone();
            }
            else if (this.next == null){
                Pair newPair = p.clone();
                Node newNode = new Node();
            
                newNode.pair = newPair;
                newNode.next = null;
                
                this.next = newNode;
            }
            else
                this.next.insertPair(p);
        }
        

        Pair theGreatest(){
            if (this.next == null){
                if (this.tg.getValue() != Double.MIN_VALUE)
                    return this.tg;
                else
                    return this.pair;
            }
            else {
                this.next.tg = maxOfThreePairs(this.pair, this.tg, this.next.pair).clone();
            }
            return this.next.theGreatest();
        }
            
        Pair maxOfThreePairs(Pair f, Pair s, Pair t){
            Pair r1, r;
            if (f.compareTo(s) > 0)
                r1 = f;
            else
                r1 = s;
            
            
            if (r1.compareTo(t) > 0)
                r = r1;
            else
                r = t;
            
            return r;
        }
        
        void removePair(Pair p){
            if (this.pair.equals(p))
                beg = this.next;
            else {
                Node temp = this;
                while(temp.next != null) {
                    if (temp.next.pair.equals(p)){
                        temp.next = temp.next.next;
                        break;
                    }
                    else
                        temp = temp.next;
                }
            }
        }
        
        Pair removeGreatest(){
            Pair theg = this.theGreatest();
            removePair(theg);
            
            return theg;
        }
        
        int size(){
            if (this.next == null)
                return 1;
            else {
                return 1 + this.next.size();
            }
        }
                
        void printPairs(Node beg){
            Node b = beg;
            while(b != null){
                if (b.pair != null)
                    System.out.println(b.pair.toString());
                b = b.next;
            }
        }
        
        @Override
        public int compareTo(Node n){
            if (this.pair.equals(n.pair)){
                return 0;
            }
            else if (this.pair.compareTo(n.pair) < 0){
                return - 10;
            }
            return 10;
        }
    }
    
    protected Node beg = new Node();

    public void printPairs(){
        beg.printPairs(beg);
    }
}
