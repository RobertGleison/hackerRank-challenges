import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] strArray = input.trim().split(" ");
        int[] intArray = Arrays.stream(strArray).mapToInt(Integer::parseInt).toArray();

    }


}