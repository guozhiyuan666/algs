package chapter1sec2;

import edu.princeton.cs.algs4.Interval1D;

import java.util.Scanner;
import static edu.princeton.cs.algs4.StdDraw.*;

public class Num2 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Scanner sc = new Scanner(System.in);
        Interval1D[] lines = new Interval1D[N];
        for(int i = 0; i < N; i++){
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            Interval1D alines= new Interval1D(x, y);
            //alines.draw(); //你这个库并不能画呀。
            lines[i] = alines;
        }
    }
}
