import java.util.Scanner;

public class Priority {

    public static void WaitingTime(int processId[], int bt[], int wt[], int n) {
        wt[0] = 0;
        for (int i = 1; i < n; i++) {
            wt[i] = bt[i - 1] + wt[i - 1];
        }
    }

    public static void TurnAroundTime(int processId[], int bt[], int wt[], int tat[], int n) {
        for (int i = 0; i < n; i++) {
            tat[i] = bt[i] + wt[i];
        }
    }

    private static void AverageTime(int processId[], int bt[], int priority[], int n) {
        int wt[] = new int[n];
        int tat[] = new int[n];

        int totalWt = 0, totalTat = 0;

        WaitingTime(processId, bt, wt, n);
        TurnAroundTime(processId, bt, wt, tat, n);

        System.out.printf("Pr   Prior    BT    WT    TAT\n");

        for (int i = 0; i < n; i++) {
            totalWt += wt[i];
            totalTat += tat[i];
            System.out.printf("    %d", processId[i]);
            System.out.printf("    %d", priority[i]);
            System.out.printf("    %d", bt[i]);
            System.out.printf("    %d", wt[i]);
            System.out.printf("    %d", tat[i]);
            System.out.printf("\n");
        }

        float s = (float) totalWt / (float) n;
        float t = (float) totalTat / (float) n;
        System.out.printf("Average waiting time: %f", s);
        System.out.printf("\n");
        System.out.printf("Average turn around time: %f", t);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int processId[], burstTime[], priority[], n;

        System.out.println("Enter the number of processes: ");
        n = sc.nextInt();
        processId = new int[n];
        burstTime = new int[n];
        priority = new int[n];

        System.out.println("Enter the burst times and priorities for the processes:\n");
        for (int i = 0; i < n; i++) {
            processId[i] = i;
            System.out.printf("Burst time for process %d: ", i);
            burstTime[i] = sc.nextInt();
            System.out.printf("Priority for process %d: ", i);
            priority[i] = sc.nextInt();
            System.out.printf("\n");
        }

        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (priority[j] < priority[j + 1]) {
                    temp = processId[j];
                    processId[j] = processId[j + 1];
                    processId[j + 1] = temp;

                    temp = burstTime[j];
                    burstTime[j] = burstTime[j + 1];
                    burstTime[j + 1] = temp;

                    temp = priority[j];
                    priority[j] = priority[j + 1];
                    priority[j + 1] = temp;
                }
            }
        }

        sc.close();

        AverageTime(processId, burstTime, priority, n);
    }
}