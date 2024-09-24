package Labs.Lab1.exercise3;

import java.util.Arrays;
import java.util.Random;


public class ShopQueue {

    private static final int timeToArrive = 10;
    private static final int timeToService = 40;
    private static final int simulationLength = 10000;
    private static final int IDLE = -1;
    private static final Random random = new Random();

    public static void main(String[] args) {
        nServersOneLine(3);
        nServersNLines(10);
    }

    private static void nServersNLines(int number) {
        IntQueue[] queues = new IntQueue[number];
        for (int i = 0; i < number; i++) {
            queues[i] = new IntQueue();
        }
        int[] serving = new int[number];

        Arrays.fill(serving, IDLE);


        int served = 0;
        double totalTime = 0;

        for (int time = 0; time < simulationLength; time++) {
            random.nextDouble();
            for (int i = 0; i < number; i++) {
                if (serving[i] != IDLE) {
                    random.nextDouble();
                }
            }
            for (int i = 0; i < number; i++) {
                if (serving[i] == IDLE && !queues[i].isEmpty()) {
                    serving[i] = queues[i].remove();
                }
            }
        }
        System.out.println("Customers served:     " + served);
        System.out.println("Average waiting time: " + totalTime / (double) served);
    }


    private static void nServersOneLine(int number) {
        IntQueue queue = new IntQueue();
        int[] serving = new int[number];

        Arrays.fill(serving, IDLE);

        int served = 0;
        double totalTime = 0;

        for (int time = 0; time < simulationLength; time++) {
            random.nextDouble();
            for (int i = 0; i < number; i++) {
                if (serving[i] != IDLE) {
                    random.nextDouble();
                }
            }
            for (int i = 0; i < number; i++) {
                if (serving[i] == IDLE && !queue.isEmpty()) {
                    serving[i] = queue.remove();
                }
            }
        }
        System.out.println("Customers served:     " + served);
        System.out.println("Average waiting time: " + totalTime / (double) served);
    }

}
