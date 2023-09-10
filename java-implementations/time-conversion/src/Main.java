import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        String inputTime = sc.nextLine();
        String output = convertTime(inputTime);
        System.out.println(output);
        sc.close();
    }

    //Getting the result using DateTimeFormatter
    public static String convertTime(String s) throws ParseException {
        if (s == null || s.isEmpty()) {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("hh:mm:ssa");
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime time = LocalTime.parse(s, inputFormatter);

            return time.format(outputFormatter);
        } else return "";
    }

    //Getting the result using manual conversion
    public static void convertTimeManual(String inputTime) {
        if (inputTime != null && !inputTime.isEmpty()) {
            String typeAMorPM = inputTime.substring(8, 10);
            String hours = inputTime.substring(0, 2);
            int intHours = Integer.parseInt(hours);
            String minutes = inputTime.substring(3, 5);
            String seconds = inputTime.substring(6, 8);
            if (typeAMorPM.equals("PM") && intHours >= 12)
                System.out.println(hours + ":" + minutes + ":" + seconds);
            if (typeAMorPM.equals("PM") && intHours < 12)
                System.out.println((intHours + 12) + ":" + minutes + ":" + seconds);
            if (typeAMorPM.equals("AM") && intHours >= 12) {
                String temp = String.valueOf(intHours - 12);
                if (temp.length() == 1) temp = temp + "0";
                System.out.println(temp + ":" + minutes + ":" + seconds);
            }
            if (typeAMorPM.equals("AM") && intHours < 12)
                System.out.println(hours + ":" + minutes + ":" + seconds);
        }
    }
}