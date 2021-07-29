package Chapter3sec1;

import edu.princeton.cs.algs4.ST;
import java.util.Scanner;

public class SequentialSearchSTTest {
    public static void main(String[] args) {
        ST<String, Integer> st = new ST<>();
        //SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
        Scanner in = new Scanner(System.in);  //等待用户输入，或者将文件作为输入流

        for(int i = 0; in.hasNext(); i++){
            st.put(in.next(), i);
        }

        for(String s : st.keys()){
            System.out.println(s + "  " + st.get(s));
        }
    }

}
