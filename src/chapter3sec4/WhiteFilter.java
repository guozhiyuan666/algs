package chapter3sec4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class WhiteFilter {
    public static void main(String[] args) throws FileNotFoundException {
        HashSet<String> set = new HashSet<>();
        File file = new File(args[0]);
        Scanner sc = new Scanner(new FileInputStream(file));
        while(sc.hasNext()){
            set.add(sc.next());
        }
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.next();
            if(set.contains(s)){
                System.out.print(s + " ");
            }
        }
    }
}
