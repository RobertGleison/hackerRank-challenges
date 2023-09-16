import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine().trim();
        List<Integer> list = Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int element = foundUniqueElement(list);
        System.out.println(element);
    }


    public static int foundUniqueElement(List<Integer> list) {
        for(Integer i : list){
            if (list.indexOf(i) == list.lastIndexOf(i)) return i;
        }
        return -1;
    }
}
