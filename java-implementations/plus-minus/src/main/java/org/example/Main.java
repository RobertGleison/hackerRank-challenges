package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        List<Integer> numbers = Stream.of(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        plusMinus(numbers);
    }

    public static void plusMinus(List<Integer> list) {
        int positives = 0, negatives = 0, zeros = 0;
        double negativeRatio = 0.0, positiveRatio = 0.0, zeroRatio = 0.0;
        for (Integer i : list){
            if (i<0) negatives++;
            if (i>0) positives++;
            if (i==0) zeros++;
        }
        negativeRatio = negatives / list.size();
        positiveRatio = positives / list.size();
        zeroRatio = zeros / list.size();

        System.out.println(
                String.format("%.6f%n",positiveRatio) +
                String.format("%.6f%n",negativeRatio) +
                String.format("%.6f%n",zeroRatio)
        );
}}