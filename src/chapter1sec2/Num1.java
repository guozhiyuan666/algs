package chapter1sec2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Num1{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        StdDraw.setPenRadius(0.008);
        double[][] points = new double[N][2];
        for(int i = 0; i < N; i++)
        {
            double x = StdRandom.random();
            double y = StdRandom.random();
            points[i][0] = x;
            points[i][0] = x;
            StdDraw.point(x, y);
        }
        double min = 100000;
        for(int j = 0; j < points.length-1 ; j++)
        {
            double xx = Math.pow((points[j][0] - points[j+1][0]), 2);
            double yy = Math.pow((points[j][1] - points[j+1][1]), 2);
            double distance = Math.sqrt(xx + yy);
            if(distance < min) min = distance;
        }
        System.out.println(min);
    }
}
