package fourthlist.tools;

/**
 *
 * @author jjpikoov
 */
public class SortedList extends UnsortedList{
    
    public void insert(Pair p){
        Node newNode = new Node();
        newNode.next = null;
        newNode.pair = p;
        
        Node first = this.beg;
        Node previous = null;
        Node current = this.beg;
        
        while (current != null && current.pair != null && p.compareTo(current.pair) > 0){
            previous = current;
            current = current.next;
        }    
        
        if (previous == null)
            first.pair = p;
        else {
            previous.next = newNode;
            newNode.next = current;
        }
            
        
    }
    
    
}
