import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] numbersAsString = input.trim().split(" ");
        long[] nums = Arrays.stream(numbersAsString).mapToLong(Long::parseLong).toArray();
        miniMax(nums);
    }

    public static void miniMax(long[] array) {
        long sum = Arrays.stream(array).reduce(0, Long::sum);
        long min = Arrays.stream(array).min().orElse(0);
        long max = Arrays.stream(array).max().orElse(0);
        System.out.println((sum-max) + " " + (sum-min));
    }
}


