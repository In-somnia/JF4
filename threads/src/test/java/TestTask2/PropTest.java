package TestTask2;


import lombok.SneakyThrows;
import task2.ReadingThread;

public class PropTest {
    @SneakyThrows
    public static void main(String[] args)  {

        Thread t1 = new Thread(new ReadingThread("thread1"));
        Thread t2 = new Thread(new ReadingThread("thread2"));
        Thread t3 = new Thread(new ReadingThread("thread3"));
        Thread t4 = new Thread(new ReadingThread("thread4"));
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        t4.start();
        t4.join();
    }
}
