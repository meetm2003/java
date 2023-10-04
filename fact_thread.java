class FactThread extends Thread {
    private int start;
    private int end;
    private int result;

    FactThread(int start, int end) {
        this.start = start;
        this.end = end;
        this.result = 1; // Initialize the result to 1
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            result *= i;
        }
    }

    public int getResult() {
        return result;
    }
}

public class fact_thread {
    public static void main(String[] args) {
        int n = 5; // Calculate factorial of n
        int numThreads = 5; // Number of threads

        int numbersPerThread = n / numThreads;
        int start = 1;
        int end = numbersPerThread;
        FactThread[] threads = new FactThread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new FactThread(start, end);
            threads[i].start();
            start = end + 1;
            end = (i == numThreads - 2) ? n : end + numbersPerThread;
        }

        try {
            for (FactThread thread : threads) {
                thread.join(); // Wait for all threads to finish
            }

            // Calculate the final result by multiplying the results of each thread
            int factorial = 1;
            for (FactThread thread : threads) {
                factorial *= thread.getResult();
            }

            System.out.println("Factorial of " + n + " is " + factorial);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
