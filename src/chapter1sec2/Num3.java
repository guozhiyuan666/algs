package chapter1sec2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Num3 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);

        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setPenRadius(.008);
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);

        for(int i = 0; i < N; i++){
            double xlo = StdRandom.uniform(min, max);
            double xhi = StdRandom.uniform(min, max);
            double ylo = StdRandom.uniform(min, max);
            double yhi = StdRandom.uniform(min, max);

            if(xlo > xhi){
                double temp;
                temp = xlo;
                xlo = xhi;
                xhi = temp;
            }
            if(ylo > yhi){
                double temp;
                temp = ylo;
                ylo = yhi;
                yhi = temp;
            }

            Interval1D x = new Interval1D(xlo, xhi);
            Interval1D y = new Interval1D(ylo, yhi);
            Interval2D box = new Interval2D(x, y);
            box.draw();

        }
    }
}
