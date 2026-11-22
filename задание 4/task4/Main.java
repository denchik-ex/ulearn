import java.util.Scanner;

class SortedArray {
    private int[] data;
    private int size;

    public SortedArray(int capacity) {
        data = new int[Math.max(1, capacity)];
        size = 0;
    }

    // Первая позиция, где элемент >= x.
    private int lowerBound(int x) {
        int left = 0;
        int right = size;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (data[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // Первая позиция, где элемент > x.
    private int upperBound(int x) {
        int left = 0;
        int right = size;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (data[mid] > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            int[] newData = new int[data.length * 2];

            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }

            data = newData;
        }
    }

    public void add(int x) {
        ensureCapacity();
        int pos = lowerBound(x);

        for (int i = size; i > pos; i--) {
            data[i] = data[i - 1];
        }

        data[pos] = x;
        size++;
    }

    public boolean contains(int x) {
        int pos = lowerBound(x);
        return pos < size && data[pos] == x;
    }

    public void remove(int x) {
        int pos = lowerBound(x);

        if (pos < size && data[pos] == x) {
            for (int i = pos; i < size - 1; i++) {
                data[i] = data[i + 1];
            }

            size--;
        }
    }

    public int countRange(int l, int r) {
        if (l > r) {
            return 0;
        }

        return upperBound(r) - lowerBound(l);
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(data[i]);
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        SortedArray array = new SortedArray(n + q);

        for (int i = 0; i < n; i++) {
            array.add(sc.nextInt());
        }

        for (int i = 0; i < q; i++) {
            String command = sc.next();

            switch (command) {
                case "ADD": {
                    int x = sc.nextInt();
                    array.add(x);
                    break;
                }
                case "CONTAINS": {
                    int x = sc.nextInt();
                    System.out.println(array.contains(x) ? "YES" : "NO");
                    break;
                }
                case "REMOVE": {
                    int x = sc.nextInt();
                    array.remove(x);
                    break;
                }
                case "COUNT_RANGE": {
                    int l = sc.nextInt();
                    int r = sc.nextInt();
                    System.out.println(array.countRange(l, r));
                    break;
                }
                case "PRINT": {
                    array.print();
                    break;
                }
            }
        }
    }
}
