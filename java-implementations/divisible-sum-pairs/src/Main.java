import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arraySize = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        int[] nums = Arrays.stream(sc.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

        //hashmap
        if (arraySize == nums.length) {
            int result = divisibleSumPairs(nums, k);
            System.out.println(result);
        }
    }

    public static int divisibleSumPairs(int[] nums, int k) {
        Map<Integer, Integer> remainderFreq = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            int remainder = num % k;
            int complement = (k - remainder) % k;
            if (remainderFreq.containsKey(complement)) {
                count += remainderFreq.get(complement);
            }
            remainderFreq.put(remainder, remainderFreq.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }
}