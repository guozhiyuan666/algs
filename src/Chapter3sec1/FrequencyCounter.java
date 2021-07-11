package Chapter3sec1;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;

/*
符号表性能测试程序
 */
public class FrequencyCounter {
    public static void main(String[] args) {//控制台输入单词的最小长度
        int minlength = Integer.parseInt(args[0]);
        ST<String,Integer> st = new ST<>();
        while(!StdIn.isEmpty()){//  < **.txt  在控制台输入文件名，将文件作为输入流
            String string = StdIn.readString();
            if(string.length() < minlength) continue;
            if(!st.contains(string)){
                st.put(string,1);
            }else{
                st.put(string,st.get(string) + 1);
            }
        }

        //遍历符号表找出频率最大的键
        String max = " "; //将空格最为键
        st.put(max,0);
        for(String word : st){
            if(st.get(word) > st.get(max) ){
                max = word;
            }
        }
        System.out.println(max + " " + st.get(max));

    }
}
