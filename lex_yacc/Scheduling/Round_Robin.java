import java.util.Scanner;

public class Round_Robin {
    public static void WaitingTime(int processId[], int n, int bt[], int wt[], int timeSlice) {
        int remainingBt[] = new int[n];

        for (int i = 0; i < n; i++) {
            remainingBt[i] = bt[i];
        }

        int currentTime = 0;

        while (true) {
            boolean done = true;

            for (int i = 0; i < n; i++) {
                if (remainingBt[i] > 0) {
                    done = false;
                    if (remainingBt[i] > timeSlice) {
                        currentTime += timeSlice;
                        remainingBt[i] -= timeSlice;
                    } else {
                        currentTime += remainingBt[i];
                        wt[i] = currentTime - bt[i];
                        remainingBt[i] = 0;
                    }
                }
            }

            if (done == true) {
                break;
            }
        }
    }

    public static void TurnAroundTime(int processId[], int n, int bt[], int wt[], int tat[], int timeSlice) {
        for (int i = 0; i < n; i++) {
            tat[i] = bt[i] + wt[i];
        }
    }

    public static void AverageTime(int processId[], int n, int timeSlice, int bt[]) {
        int wt[] = new int[n];
        int tat[] = new int[n];
        int totalWt = 0, totalTat = 0;

        WaitingTime(processId, n, bt, wt, timeSlice);
        TurnAroundTime(processId, n, bt, wt, tat, timeSlice);

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
        int timeSlice;

        System.out.println("Enter the number of processes: ");
        n = sc.nextInt();
        processId = new int[n];
        burstTime = new int[n];

        System.out.printf("Enter the burst times:\n");
        for (int i = 0; i < n; i++) {
            processId[i] = i;
            System.out.printf("Process %d: ", i);
            burstTime[i] = sc.nextInt();
        }

        System.out.printf("Enter the time slice: ");
        timeSlice = sc.nextInt();
        sc.close();

        AverageTime(processId, n, timeSlice, burstTime);
    }
}