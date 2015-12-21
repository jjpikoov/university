/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sixthlist.algorithms;



/**
 *
 * @author jjpikoov
 * @param <T>
 */
public class BST <T extends Comparable<T>> implements Dict<T>{
    
    private class Node<T extends Comparable<T>>{
        Node<T> left, right, parent;
        T key;
    
    }
    
    private Node<T> root;
    
    public BST(){
    }

    public boolean search(T key) {
        Node<T> x = root;
        
        while (x != null && (!x.key.equals(key))){
            if (key.compareTo(x.key) < 0)
                x = x.left;
            else
                x = x.right;
        }
        if (x == null){
            return false;
        }
        else if (x.key.equals(key))
            return true;
        
        return false;
    }
    
    /**
     *
     * @param key
     * @return
     */
    private Node<T> searchAndReturn(T key){
        Node<T> x = root;
        
        while (x != null && (!key.equals(x.key))){
            if (key.compareTo(x.key) < 0)
                x = x.left;
            else
                x = x.right;
        }
        return x;
    }
    

    @Override
    public void insert(T key) {
        if (key == null)
            throw new NullPointerException();
        
        Node<T> z = new Node<>();
        z.key = key;
        z.left = null;
        z.right = null;
        
        Node<T> y, x;
        y = null;
        x = root;
        
        while(x != null){
            y = x;
            if (z.key.compareTo(x.key) < 0)
                x = x.left;
            else
                x = x.right;
        }
        
        z.parent = y;
        
        if (y == null){
            root = z;
        }
        else{ 
            if (z.key.compareTo(y.key) < 0){
                y.left = z;
            }
            else{
                y.right = z;
            }
        }
    }

    @Override
    public T remove(T key) {
        Node<T> z = this.searchAndReturn(key);
        Node<T> y, x;
        
        if (z.left == null || z.right == null)
            y = z;
        else
            y = this.successor(z);
        
        if (y.left != null)
            x = y.left;
        else
            x = y.right;
        
        if (x != null)
            x.parent = y.parent;
        
        if (y.parent == null)
            root = x;
        else if (y.equals(y.parent.left))
            y.parent.left = x;
        else
            y.parent.right = x;
        
        if (y != z){
            z.key = y.key;
        }
        
        return key;
    }

    

    @Override
    public T min() {
        Node<T> x = root;
        
        while (x.left != null)
            x = x.left;
        return x.key;
    }
    
    /** Must exsits becouse successor and deletion need it */
    private Node<T> min(Node<T> x){
        while (x.left != null)
            x = x.left;
        return x;
    }

    @Override
    public T max() {
        Node<T> x = root;
        
        while(x.right != null)
            x = x.right;
        return x.key;
    }


    private Node<T> successor(Node<T> x) {
        if (x.right != null)
            return this.min(x.right);
        
        Node<T> y = x.parent;
        
        while (y != null && x.equals(y.right)){
            x = y;
            y = y.parent;
        }
        return y;
    }

    public int size(){
        return this.recursiveSize(this.root);
    }
    
    private int recursiveSize(Node<T> x){
        if (x == null)
            return 0;
        if (x.left == null && x.right == null)
            return 1;
        else if (x.left != null && x.right != null)
            return 1 + recursiveSize(x.left) + recursiveSize(x.right);
        else if (x.left != null)
            return 1 + recursiveSize(x.left);
        else if (x.right != null)
            return 1 + recursiveSize(x.right);
        
        return 0;
    }
//    
//    public void clear(){
//        root.left = null;
//        root.right = null;
//        root.key = null;
//    }
    public void clear(){
        root = null;
    }
    
    private void inOrderTreeWalk(Node x){
       
        if (x != null){
            inOrderTreeWalk(x.left);
            System.out.println(x.key);
            inOrderTreeWalk(x.right);
        }
    }
    
    public void allInOrderTreeWalk(){
        this.inOrderTreeWalk(root);
    }
}
