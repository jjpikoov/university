package fourthlist.tools;
/**
 *
 * @author jjpikoov
 */
public interface Priority {
    void insert(Pair p);
    Pair theGreatest();
    Pair removeGreatest();
    int size();
}
