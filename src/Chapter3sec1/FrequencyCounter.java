package Chapter3sec1;

import edu.princeton.cs.algs4.ST;
//import edu.princeton.cs.algs4.StdIn;

import java.util.Scanner;

/*
符号表性能测试程序,统计单词出现的频率
 */
public class FrequencyCounter {
    public static void main(String[] args) {//控制台输入单词的最小长度
        int minlength = Integer.parseInt(args[0]);
        //ST<String,Integer> st = new ST<>();
        //SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
        //BinarySearchST<String,Integer> st = new BinarySearchST<>(1000000);
        BST<String,Integer> st = new BST<>();
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){//  < **.txt  在控制台输入文件名，将文件作为输入流
            String string = in.next();
            if(string.length() < minlength) continue;
            if(!st.contains(string)){
                st.put(string,1);
            }else{
                st.put(string,st.get(string) + 1);
            }
        }

        //遍历符号表找出频率最大的键
        String max = " "; //将空格作为键，值为最小值0，用来将最大值初始化
        st.put(max,0);
        for(String word : st.keys()){
            if(st.get(word) > st.get(max)){
                max = word;
            }
        }
        System.out.println(max + " " + st.get(max));
    }
}
