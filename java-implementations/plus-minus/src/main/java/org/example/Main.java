package org.example;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            Locale.setDefault(Locale.US);
            int size = sc.nextInt();
            sc.nextLine();
            String line = sc.nextLine();
            String[] StrNumbers = line.split(" ");

            if (StrNumbers.length == size) {
                List<Integer> numbers = Stream.of(StrNumbers).
                                        map(Integer::parseInt).
                                        collect(Collectors.toList());
                plusMinus(numbers);
            }
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void plusMinus(List<Integer> list) {
        double positives = 0.0, negatives = 0.0, zeros = 0.0;
        for (Integer i : list) {
            if (i < 0.0) negatives++;
            if (i > 0.0) positives++;
            if (i == 0.0) zeros++;
        }
        double negativeRatio = negatives / list.size();
        double positiveRatio = positives / list.size();
        double zeroRatio = zeros / list.size();

        System.out.println(String.format("%.6f%n", positiveRatio) +
                           String.format("%.6f%n", negativeRatio) +
                           String.format("%.6f%n", zeroRatio));
    }
}