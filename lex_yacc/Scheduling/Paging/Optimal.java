import java.util.*;

public class Optimal {

    private static int Predict(int pages[], ArrayList<Integer> memory, int n, int capacity, int index) {
        // store index of page to be used recently in the future
        int res = -1;
        int farthest = index;
        int y;

        for (int x = 0; x < memory.size(); x++) {
            for (y = index; y < n; y++) {
                if (memory.get(x) == pages[y]) {
                    if (y > farthest) {
                        farthest = y;
                        res = x;
                    }
                    break;
                }
            }

            if (y == n) {
                return x;
            }
        }

        if (res == -1) {
            return 0;
        } else {
            return res;
        }
    }

    private static void Paging(int pages[], int n, int capacity) {
        ArrayList<Integer> memory = new ArrayList<>(capacity);

        int pageHit = 0;

        for (int i = 0; i < n; i++) {
            if (memory.contains(pages[i])) {
                pageHit++;
            } else {
                if (memory.size() < capacity) {
                    memory.add(memory.size(), pages[i]);
                } else {
                    int j = Predict(pages, memory, n, capacity, i + 1);
                    memory.add(j, pages[i]);
                }
            }
        }

        System.out.printf("Number of page hits: %d\n", pageHit);
        System.out.printf("Number of page faults: %d\n", n - pageHit);
    }

    public static void main(String[] args) {

        int pages[], capacity, n;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the  number of pages: ");
        n = sc.nextInt();
        System.out.println("Enter the capacity: ");
        capacity = sc.nextInt();
        pages = new int[n];

        System.out.printf("Enter %d pages:\n", n);
        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        Paging(pages, n, capacity);
        sc.close();
    }
}