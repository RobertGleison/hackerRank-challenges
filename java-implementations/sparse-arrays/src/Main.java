import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        List<String> names = new ArrayList<>(size);
        List<String> query = new ArrayList<>();
        for (int i = 0; i < size; i++){
            names.add(sc.nextLine());
        }
        int querySize = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < querySize; i++){
            query.add(sc.nextLine());
        }
        if((names.size()==size) && (query.size() == querySize))  queryString(names, query);
    }

    //HashMap implementation
    public static void queryString(List<String> names, List<String> query){
        Map<String,Integer> words = new LinkedHashMap<>();
        for(String name : query){
            if (!words.containsKey(name)){
            words.put(name, 0);
            }
        }
        for(String nameToFind : names){
            if(words.containsKey(nameToFind)){
                int newValue = words.get(nameToFind)+1;
                words.put(nameToFind,newValue);
            }
        }
        words.values().forEach(x-> System.out.println(x));

    }
}