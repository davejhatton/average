package com.test;

import java.util.Arrays;

public class Averager {


    public static int getAverage(int[] numbers) {

        int sum = 0;
        for (int number : numbers) {
            sum +=number;
        }

        return sum/numbers.length;
    }


    public static double getAvererageStream(int[] numbers){

       return  Arrays.stream(numbers).average().getAsDouble();
    }

}
