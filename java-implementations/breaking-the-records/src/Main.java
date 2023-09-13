import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int games = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();
        String[] strNums = line.split(" ");
        int[] nums = Arrays.stream(strNums).mapToInt(Integer::parseInt).toArray();
        if (nums.length == games) records(nums);
    }

    public static void records(int[] array) {
        int max = array[0];
        int min = array[0];
        int[] score = {0,0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                score[0]++;
                max = array[i];
            }
            if (array[i] < min) {
                score[1]++;
                min = array[i];
            }
        }
        for(int i = 0; i< score.length;i++){
            System.out.print(score[i] +" ");
        }
    }
}