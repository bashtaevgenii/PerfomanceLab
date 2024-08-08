public class Task1 {
    public static void main(String[] args) {
        int n = 0;
        int m = 0;
        for (int i = 0; i < args.length; i++) {
            n = Integer.parseInt(args[0]);
            m = Integer.parseInt(args[1]);
        }
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        String result = new String();
        int iterator = 0;
        do {
            result = result + array[iterator];
            iterator = (iterator + m - 1) % n;

        } while (array[iterator] != array[0]);
        System.out.println(result);
    }
    }
