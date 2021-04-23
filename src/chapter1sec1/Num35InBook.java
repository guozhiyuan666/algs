package chapter1sec1;

public class Num35InBook {
    public static void randomDots(){
        int SIDES = 6;
        double[] dist = new double[2*SIDES+1];
        for (int i = 1; i <= SIDES; i++)
        {
            for (int j = 1; j <= SIDES; j++) {
                dist[i + j] += 1.0;
            }
        }
        for (int k = 2; k <= 2*SIDES; k++){
            System.out.println( dist[k] / 36.0);
        }
    }

}
