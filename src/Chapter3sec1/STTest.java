package Chapter3sec1;

import chapter3sec4.SeparateChainingHashST;
import edu.princeton.cs.algs4.ST;

import java.util.Scanner;

//public class STTest {//在控制台输入  S E A R C H E X A M P L E
//    public static void main(String[] args) {
//        ST<String, Integer> st = new ST<>();
//        for(int i = 0; i < args.length; i++){
//            st.put(args[i], i);
//        }
//        for(String s : st.keys()){
//            System.out.println(s + "  " + st.get(s));
//        }
//    }
//}


public class STTest{//运行程序后用户输入, CTRL + D ,或者控制台 < SEARCHEXAMPLE.txt将文件作为输入流，而不是等待用户输入

    public static void main(String[] args) {
        //ST<String, Integer> st = new ST<>();
        //SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<>();
        Scanner in = new Scanner(System.in);  //等待用户输入，或者将文件作为输入流

        for(int i = 0; in.hasNext(); i++){
            st.put(in.next(), i);
        }

        for(String s : st.keys()){
            System.out.println(s + "  " + st.get(s));
        }
    }

}
