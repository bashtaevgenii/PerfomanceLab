import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line;
        ArrayList<Integer> num = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            num.add(Integer.parseInt(line));
        }
        num.trimToSize();

        int sum = num.stream().reduce(0, Integer::sum);
        int average = Math.round(sum / num.size());
        int rezult = 0;
        for (int i = 0; i < num.size(); i++) {
            rezult = rezult + Math.abs(average - num.get(i));
        }
        System.out.println(rezult);
    }
}