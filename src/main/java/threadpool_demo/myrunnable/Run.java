package threadpool_demo.myrunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 复用线程池中的线程对象
public class Run {
    public static void main(String[] args) throws Exception {
        fixedThreadPoolDemo();
    }

    private static void fixedThreadPoolDemo() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.execute(new MyRunnable("" + i));
        }

        for (int i = 0; i < 3; i++) {
            executorService.execute(new MyRunnable("" + i));
        }
    }

    private static void cachedThreadPoolDemo() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable(("" + (i + 1))));
        }

        Thread.sleep(1000);
        System.out.println("");
        System.out.println("");
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable(("" + (i + 1))));
        }

        executorService.shutdown();

    }
}
