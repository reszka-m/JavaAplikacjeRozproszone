import java.util.Random;
class MyClass extends Thread implements Runnable
{
    private Random rnd;
    private String str;

    public MyClass(String str)
    {
        this.str = str;
        rnd = new Random();
    }
    public void run()
    {
        for(int i = 0; i < 5; i++){
            try{
                Thread.sleep(rnd.nextInt(2500) + 500);
                System.out.println(this.getName() + " " +i );

            }
            catch(InterruptedException e){
            }
//            System.out.println(str + " " + i);
        }
    }
}

public class Main
{
    public static void main(String args[])
    {
        MyClass mc1 = new MyClass("Pierwszy");
        MyClass mc2 = new MyClass("Drugi");
        Thread thread1 = new Thread(mc1);
        Thread thread2 = new Thread(mc2);
        thread1.start();
        thread2.start();
    }
}
