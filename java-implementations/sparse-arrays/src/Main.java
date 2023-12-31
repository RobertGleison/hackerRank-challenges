import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        List<String> names = new ArrayList<>(size);
        List<String> query = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            names.add(sc.nextLine());
        }
        int querySize = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < querySize; i++) {
            query.add(sc.nextLine());
        }
        if ((names.size() == size) && (query.size() == querySize))
            queryString(names, query);
        }

    //  HashMap implementation
    public static void queryString(List<String> names, List<String> query) {
        Map<String, Integer> words = new LinkedHashMap<>();
        query.forEach(name -> words.putIfAbsent(name, 0));
        for (String nameToFind : names) {
            if (words.containsKey(nameToFind)) {
                int newValue = words.get(nameToFind) + 1;
                words.put(nameToFind, newValue);
            }
        }
        words.values().forEach(System.out::println);

    }

    public static void matchingStrings(List<String> strings, List<String> queries) {
        final List<Integer> responseList = new ArrayList<>();
        queries.forEach(query -> {responseList.add((int) strings.stream().filter(str -> str.equals(query)).count());});
        responseList.forEach(System.out::println);
    }
}

