package chapter2sec4;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.Transaction;
import java.util.Scanner;

public class MaxPQTest {
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]); //优先队列中保留M个元素
        MaxPQ<Transaction> pq = new MaxPQ<>(20);
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            pq.insert(new Transaction(in.nextLine()));
            if(pq.size() > M){    //超过M把最小的删掉
                pq.delMax();
            }
        }
        Stack<Transaction> st = new Stack<>();
        while(!pq.isEmpty()){
            st.push(pq.delMax());
        }
        for(Transaction t : st){  //最后打印剩下的M个元素，降序排列
            System.out.println(t);
        }
    }
}
