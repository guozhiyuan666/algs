package Chapter3sec1;

import chapter1sec3.Queue;

import java.util.ArrayList;

public class BST <Key extends Comparable, Value>{

    private class Node{
        private int N;
        private Key key;
        private Value val;
        private Node left;
        private Node right;

        public Node(Key key, Value val, int N){
            this.N  = N;
            this.key = key;
            this.val = val;
        }
    }
    private Node root;

    public void put(Key key, Value val){
        root = put(root, key, val);
    }
    private Node put(Node x, Key key, Value val){
        if(x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if(cmp > 0) x.right = put(x.right, key, val);     //未命中
        else if(cmp < 0) x.left = put(x.left, key, val); //未命中
        else x.val = val;  //命中
        x.N = size(x.right) + size(x.left);
        return x;
    }

    public int size(){
        return size(root);
    }
    private int size(Node x){
        if(x == null) return 0;
        else return x.N;
    }

    public Value get(Key key){
        return get(root, key);
    }
    private Value get(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp > 0) return get(x.right,key);
        else if(cmp < 0) return get(x.left,key);
        else return x.val;
    }

    public Key floor(Key key){ //
        Node x = floor(root, key);
        if(x == null) return null;
        return x.key;
    }
    private Node floor(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) return floor(x.left, key);
        if(cmp == 0 ) return x;

        Node r = floor(x.right, key);
        if(r != null)  return r;
        else return x; //x是该层根节点*给定key大于根节点时，若根节点的右子树（比根节点大）中有比key小的则这个就是小于等于key的最大键，若根节点中没找到比key小的，那么该根节点就是小于等于key的最大键
    }

    public Key min(){
        return min(root).key;
    }
    private Node min(Node x){
        if(x.left == null) return x;
        return min(x.left);
    }
    public Key max() {return max(root).key;}
    private Node max(Node x){
        if(x.right == null) return x;
        return max(x.right);
    }

    public void deleteMin(){
        root = deleteMin(root); //从root开始删除最小的
    }
    private Node deleteMin(Node x){
        if(x.left == null) return x.right; //到最左边的结点时，把该节点的右子树（比该节点大）的链接返回
        x.left = deleteMin(x.left);  //从x.left开始删除最小的
        x.N = size(x.left) + size(x.right) + 1;  //重置大小N
        return x;
    }

    public void delete(Key key){
        root = delete(root, key);
    }
    private Node delete(Node x, Key key){
        if(x == null)  return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = delete(x.left, key);
        if(cmp > 0) x.right = delete(x.right, key);
        else{
            if(x.left == null) return x.right;
            if(x.right == null) return x.left;

            Node temp = x;
            temp.left = x.left;
            x = min(temp.right);
            x.right = deleteMin(temp.right); //怎么理解，去看deleMin方法
            x.left = temp.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public int rank(Key key){//小于key的个数
        return rank(root, key);
    }
    private int rank(Node x, Key key){
        if(x == null) return 0;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) return rank(x.left, key);
        if(cmp > 0) return 1 + size(x.left) + rank(x.right. key);
        else return size(x.left);
    }

    public Key select(int k){
        return select(root, k).key;
    }
    private Node select(Node x, int k){//返回排名为 k 的结点
        if(x == null) return null;
        int t = size(x.left);
        if(t > k) return select(x.left, k);
        if(t < k) return select(x.right, t - k - 1);
        else return x;
    }

    public ArrayList<Key> keys(){
        return keys(min(), max());
    }
    public ArrayList<Key> keys(Key lo, Key hi){
        ArrayList<Key> al = new ArrayList<>();
        keys(root, al, lo, hi);
        return al;
    }
    private void keys(Node x, ArrayList<Key> al, Key lo, Key hi){
        if(x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);

        if(cmplo < 0) keys(x.left, al, lo, hi);
        if(cmplo <= 0 && cmphi >= 0) al.add(x.key);
        if(cmphi > 0) keys(x.right, al, lo, hi);
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

}
