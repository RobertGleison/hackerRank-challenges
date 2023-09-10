import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        String inputTime = sc.nextLine();
        convertTime(inputTime);
        sc.close();
    }

    public static void convertTime(String inputTime) {
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