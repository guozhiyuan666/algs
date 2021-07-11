package chapter2sec4;
/*
基于堆的优先队列
2.4.27 为优先队列添加min()方法。
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;
    private Key min = null;

    public MaxPQ() { //默认大小为 4；
        pq = (Key[]) new Comparable[5];
    }

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    /*
    主要方法
     */
    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        if (N + 1 == pq.length) {
            resize(pq.length * 2);
        }
        if(N == 0){//每插入一个元素就更新最小值
            min = v;
        }
        else if(min.compareTo(v) > 0){
            min = v;
        }
        pq[++N] = v;
        swim(N);
    }
    public Key getMax(){
        return pq[1];
    }

    public Key delMax() {
        if (N == pq.length / 4) {
            resize(pq.length / 2);
        }
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null; //防止对象游离
        sink(1);
        if(N == 0){//如果优先队列为空更新最小值为null
            min = null;
        }
        return max;
    }
    public Key min(){
       return min;
    }

    /*
    辅助方法
     */
    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int i = 2 * k;                       //i指针移动到左子树
            if (i < N && less(i, i + 1)) {
                i++;
            } //判断左子树和右子树那个大
            if (!less(k, i)) break;                //如果子结点比父节点小，则break不交换
            exch(k, i);
            k = i;                               //指针i移动到子树
        }
    }

    private void resize(int cap) {
        Key[] aux = (Key[]) new Comparable[cap];
        for (int i = 0; i <= N; i++) { //这里需要注意，不是i < pq.length  !!!!!!
            aux[i] = pq[i];
        }
        pq = aux;
    }

    public static void main(String[] args) {
        MaxPQ<Integer> pq = new MaxPQ<>(2);
        pq.insert(2);
        pq.insert(-1);
        //System.out.println(pq.delMax());
        //System.out.println(pq.delMax());
        pq.insert(100);
        pq.insert(10);
        //System.out.println(pq.delMax());
        System.out.println(pq.min());
    }

}
