package chapter1sec4;

import chapter1sec1.BinarySearch;

import java.awt.image.BufferedImage;

public class FourSum {
    static int counter = 0;
    public static int count(int [] a){
        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j < a.length; j++){
                for (int k = j + 1; k < a.length; k++){
                    if( BinarySearch.rank( - a[i] - a[j] - a[k],a) > k ){
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public static int count2(int [] a){
        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j < a.length; j++){
                for (int k = j + 1; k < a.length; k++){
                    for(int l = k + 1; l <a.length; l++){
                        if(a[i] + a[j] + a[k] + a[l] == 0){
                            counter++;
                        }
                    }
                }
            }
        }
        return counter;
    }
}
