import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> textInput = new ArrayList<>();

        while (sc.hasNextLine()) {
            String in = sc.nextLine();
            if (in.trim().isEmpty()) {
                break;
            }
            textInput.add(in);
        }

        String[] lines = textInput.toArray(String[]::new);
        StringBuilder output = new StringBuilder();

        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length == 3) {
                String operation = parts[0];
                String designation = parts[1];
                String text = parts[2];
                if ("S".equals(operation)) {
                    text = splitCamelCase(text, designation);

                } else if ("C".equals(operation)) {
                    text = combineCamelCase(text, designation);
                }
                output.append(text).append("\n");
            }
        }
        System.out.println(output.toString().trim());
    }

    private static String splitCamelCase(String input, String designation) {
        if (designation.equals("M"))
            return input.substring(0, input.length() - 2).replaceAll("([a-z])([A-Z])", "$1 $2").toLowerCase();
        if (designation.equals("V")) return input.replaceAll("([a-z])([A-Z])", "$1 $2").toLowerCase();
        if (designation.equals("C")) return input.replaceAll("([a-z])([A-Z])", "$1 $2").toLowerCase();
        else return input;
    }

    private static String combineCamelCase(String input, String designation) {
        if (designation.equals("M")) {
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ' ') {
                    input = input.replace(input.substring(i, i + 2), input.substring(i + 1, i + 2).toUpperCase());
                }
            }
            input = input + "()";
        }
        if (designation.equals("V")) {
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ' ') {
                    input = input.replace(input.substring(i, i + 2), input.substring(i + 1, i + 2).toUpperCase());
                }
            }
        }
        if (designation.equals("C")){
            for (int i = 0; i < input.length(); i++) {
                input = input.substring(0, 1).toUpperCase() + input.substring(1);
                if (input.charAt(i) == ' ') {
                    input = input.replace(input.substring(i, i + 2), input.substring(i + 1, i + 2).toUpperCase());
                }
            }
    }
        return input;
}
}