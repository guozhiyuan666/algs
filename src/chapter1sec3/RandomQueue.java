package chapter1sec3;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
/**
 * 练习1.3.35 泛型随机队列
 */

public class RandomQueue<Item> implements Iterable<Item>{
    public final int DEFAULTCAP = 5;
    private int size;
    Item[] arr = (Item[]) new Object[DEFAULTCAP];

    //调整数组大小
    private void resize(int cap){
        Item[] temp = (Item[]) new Object[cap];
        System.arraycopy(arr,0,temp,0,size);
        arr = temp;
    }
    //将数组顺序打乱
    private void randomExchange(){
        int r = StdRandom.uniform(0,size);
        Item temp;
        temp = arr[size - 1];
        arr[size - 1] = arr[r];
        arr[r] = temp;
    }
    //将数组洗乱
    public void shuffle(Item[] a){
        for(int i = 0; i < size; i++){
            int r = i + StdRandom.uniform(size - i);
            Item temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }


    public boolean isEmpty(){ return size == 0; }
    public int size() { return size;}

    //入队
    public void enqueue(Item item){
        if(size == arr.length){ resize(arr.length * 2);}
        arr[size] = item;
        size++;
    }
    //随机出队
    public Item dequeue(){
        if(isEmpty()){throw new RuntimeException("随机队列为空");}
        randomExchange();
        Item item = arr[size - 1];
        arr[size - 1] = null;
        size--;
        return item;
    }
    //随机返回一个元素，但不删除
    public Item sample(){
        randomExchange();
        return arr[size - 1];
    }

    //实现迭代器；
    public Iterator<Item> iterator(){
        return new RandomQueueIterator(arr);
    }
    public class RandomQueueIterator implements Iterator<Item>{
        RandomQueueIterator(Item[] a){
            shuffle(arr);
        }
        int current = size;
        public boolean hasNext(){
            return current > 0;
        }
        public Item next(){
            Item item;
            item = arr[current - 1];
            current--;
            return item;
        }
    }


}
