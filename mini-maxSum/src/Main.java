import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] strArray = input.trim().split(" ");
        int[] intArray = Arrays.stream(strArray).mapToInt(Integer::parseInt).toArray();
        int minSum = minSum(intArray);
        int maxSum = maxSum(intArray);
        System.out.println(minSum + " " + maxSum);

    }

    public static int maxSum(int[] array){
        int min = Arrays.stream(array).min().orElse(0);
        return Arrays.stream(array).filter(n->n!= min).reduce(0,(x,y)->x+y);
    }

    public static int minSum(int[] array){
        int max = Arrays.stream(array).max().orElse(0);
        return Arrays.stream(array).filter(n->n!= max).reduce(0,(x,y)->x+y);
    }


}