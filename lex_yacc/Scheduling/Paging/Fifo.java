import java.util.*;

public class Fifo {
    static void Paging(int pages[], int n, int capacity) {
        HashSet<Integer> memory = new HashSet<>(capacity);
        Queue<Integer> pageIndexes = new LinkedList<>();

        int pageFaults = 0, pageHits = 0;

        for (int i = 0; i < n; i++) {
            if (memory.size() < capacity) {
                if (!memory.contains(pages[i])) {
                    memory.add(pages[i]);
                    pageFaults++;
                    pageIndexes.add(pages[i]);
                }
            } else {
                if (!memory.contains(pages[i])) {
                    int val = pageIndexes.peek();
                    pageIndexes.poll();
                    memory.remove(val);
                    memory.add(pages[i]);
                    pageIndexes.add(pages[i]);
                    pageFaults++;
                } else {
                    pageHits++;
                }
            }
        }

        System.out.printf("Number of page faults: %d\n", pageFaults);
        System.out.printf("Number of page hits: %d\n", pageHits);
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
