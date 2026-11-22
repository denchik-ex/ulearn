import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int t = 0; t < q; t++) {
            int x = sc.nextInt();

            int left = 0;
            int right = n;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (a[mid] >= x) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            System.out.println(left);
        }
    }
}
