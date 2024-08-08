import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line= reader.readLine();
        String[] circle = line.split(" ");
        int circle_x = Integer.parseInt(circle[0]);
        int circle_y = Integer.parseInt(circle[1]);
        line= reader.readLine();
        double circle_rad = Double.parseDouble(line);

        reader = new BufferedReader(new FileReader(args[1]));

        while ((line = reader.readLine()) != null) {
            String[] a = line.split(" ");
            int x = Integer.parseInt(a[0]);
            int y = Integer.parseInt(a[1]);
            if (Math.abs(x - circle_x) > circle_rad || Math.abs(y - circle_y) > circle_rad) {
                System.out.println(2);
            } else {
                double vector_length = Math.abs(Math.sqrt(Math.pow(x - circle_x, 2) + Math.pow(y - circle_y, 2)));
                if (circle_rad < vector_length) {
                    System.out.println(2);
                } else if (circle_rad > vector_length) {
                    System.out.println(1);
                } else System.out.println(0);
            }
        }
        reader.close();
    }
}