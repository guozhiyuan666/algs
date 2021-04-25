package chapter1sec3;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomBag <Item> implements Iterable<Item>{
    private static final int DEFAULTCAP = 10;
    Item[] a = (Item[])new Object[DEFAULTCAP];
    private int size = 0;
    private int first = 0;

    public boolean isEmpty(){ return size == 0; }
    public int size(){ return size; }

    //像背包中添加一个元素
    public void add(Item item){
        a[first] = item;
        first++;
        size++;
        if(first == a.length){ resize(a.length * 2); }
    }

    //调整数组大小
    private void resize(int cap){
        Item[] temp = (Item[])new Object[cap];
        for(int i = 0; i < size; i++){
            temp[i] = a[i];
        }
        first = size;
        a = temp;
    }

    //实现迭代器，随机打乱
    public Iterator<Item> iterator(){
        resize(size);
        return new RandomBagIterator(a);
    }
    public class RandomBagIterator implements Iterator<Item>{
        //构造函数，打乱顺序
         RandomBagIterator(Item[] a){
            int N;
            for(int i = 0; i < size; i++){
                N = i + StdRandom.uniform(size - i);
                Item temp = a[i];
                a[i] = a[N];
                a[N] = temp;
            }
        }

        int current = size - 1;
        public boolean hasNext(){
            return current >= 0;
        }

        public Item next(){
            Item item;
            item = a[current];
            current--;
            return item;
        }

    }


}
