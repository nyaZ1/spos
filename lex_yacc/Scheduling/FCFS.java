import java.util.Scanner;

class FCFS {
    private static void WaitingTime(int processId[], int n, int bt[], int wt[]) {
        wt[0] = 0;

        for (int i = 1; i < n; i++) {
            wt[i] = bt[i - 1] + wt[i - 1];
        }
    }

    private static void TurnAroundTime(int processId[], int n, int bt[], int wt[], int tat[]) {
        for (int i = 0; i < n; i++) {
            tat[i] = bt[i] + wt[i];
        }
    }

    private static void AverageTime(int processId[], int n, int bt[]) {
        int wt[] = new int[n];
        int tat[] = new int[n];

        int totalWt = 0, totalTat = 0;

        WaitingTime(processId, n, bt, wt);
        TurnAroundTime(processId, n, bt, wt, tat);

        System.out.printf("Pr   BT    WT    TAT\n");

        for (int i = 0; i < n; i++) {
            totalWt += wt[i];
            totalTat += tat[i];
            System.out.printf("    %d", processId[i]);
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
        int processId[], burstTime[], n;

        System.out.printf("Enter the number of processes: ");
        n = sc.nextInt();
        processId = new int[n];
        burstTime = new int[n];

        System.out.printf("Enter the burst times:\n");
        try {
            for (int i = 0; i < n; i++) {
                processId[i] = i;
                System.out.printf("Process %d: ", i);
                burstTime[i] = sc.nextInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();

        AverageTime(processId, n, burstTime);
    }
}