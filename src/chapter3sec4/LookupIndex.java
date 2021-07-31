package chapter3sec4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *由数据库文件txt建立索引，以及反向索引
 */
public class LookupIndex {
    public static void main(String[] args) throws FileNotFoundException{ //

        Scanner in = new Scanner(new File(args[0]));//文件数据据库
        String Separator = args[1];                 //分隔符

        ST<String, Queue<String>> st = new ST<>();
        ST<String, Queue<String>> ts = new ST<>();  //反向索引
        while(in.hasNextLine()){
            String line = in.nextLine();
            String[] separated = line.split(Separator); // 分割成数组，0是电影名，1-i是演员名
            String key = separated[0];
            for(int i = 1; i < separated.length; i++){
                String val = separated[i];
                if(!st.contains(key)){
                    st.put(key, new Queue<String>());
                }
                if(!ts.contains(val)){
                    ts.put(val, new Queue<String>());
                }
                st.get(key).enqueue(val);
                ts.get(val).enqueue(key);
            }
        }
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String query = sc.nextLine();
            if(st.contains(query)){
                for(String s : st.get(query)){
                    System.out.println(s);
                }
            }
            if(ts.contains(query)){
                for(String s : ts.get(query)){
                    System.out.println(s);
                }
            }
        }
    }
}
