class MyThread extends Thread
{
    public MyThread()
    {
        super();
    }

    public void run()
    {
        System.out.println(this.getName());
    }
}

public class Main
{
    public static void main(String args[])
    {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread1.start();
        myThread2.start();
        System.out.println("Thread: Main");
    }
}