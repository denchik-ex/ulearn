import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int shifts = 0;

        for (int i = 1; i < n; i++) {
            int current = a[i];
            int j = i - 1;
            int limit = Math.max(0, i - k);

            while (j >= limit && a[j] > current) {
                a[j + 1] = a[j];
                j--;
                shifts++;
            }

            a[j + 1] = current;
        }

        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println(shifts);
    }
}
