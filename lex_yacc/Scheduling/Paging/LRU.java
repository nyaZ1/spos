import java.util.*;

public class LRU {

    private static void Paging(int pages[], int n, int capacity) {
        ArrayList<Integer> memory = new ArrayList<>(capacity);
        int count = 0;
        int pageFaults = 0, pageHits = 0;

        for (int i = 0; i < n; i++) {
            if (!memory.contains(pages[i])) {
                if (memory.size() == capacity) {
                    memory.remove(0);
                    memory.add(capacity - 1, pages[i]);
                } else {
                    memory.add(count, pages[i]);
                }

                pageFaults++;
                ++count;
            } else {
                memory.remove(pages[i]);
                memory.add(memory.size(), pages[i]);
                pageHits++;
            }
        }

        System.out.printf("Number of page faults: %d\n", pageFaults);
        System.out.printf("Number of page faults: %d\n", pageFaults);
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