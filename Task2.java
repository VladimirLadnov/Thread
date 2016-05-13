package dz.module7.Task2;

/**
 * Created by Володимир on 13.05.2016.
 */
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Task2 {
    public static class CountTime extends Thread{
        public void run(){
            while ( ! isInterrupted()) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    System.out.println(sdf.format(System.currentTimeMillis()));
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            CountTime c= new CountTime();
            c.start();
            while (!c.isInterrupted()) {
                Scanner sc = new Scanner(System.in);
                String y = sc.next();
                if (y != null) {
                    c.interrupt();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Finish");
    }
}
