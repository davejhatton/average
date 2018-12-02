package com.test;

import java.util.Arrays;
import java.util.OptionalDouble;

public class Averager {


    public static int getAverage(int[] numbers) {

        int sum = 0;
        for (int number : numbers) {
            sum +=number;
        }

        return sum/numbers.length;
    }


    public static OptionalDouble getAvererageStream(int[] numbers){

       return  Arrays.stream(numbers).average();
    }

}
