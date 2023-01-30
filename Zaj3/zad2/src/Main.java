public class Main {
    public static void main(String[] args) {
        SharedObject shared = new SharedObject();
        Thread producer = new Thread(new Producer(shared));
        Thread consumer = new Thread(new Consumer(shared));
        producer.start();
        consumer.start();
    }
}

class SharedObject {
    private String value;
    private boolean isDataAvailable = false;

    public synchronized void setValue(String value) {
        while(isDataAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.value = value;
        isDataAvailable = true;
        notify();
    }

    public synchronized String getValue() {
        while(!isDataAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isDataAvailable = false;
        notify();
        return value;
    }
}

class Producer implements Runnable {
    private SharedObject shared;

    public Producer(SharedObject shared) {
        this.shared = shared;
    }

    @Override
    public void run() {
        while(true) {
            String value = "some data";
            shared.setValue(value);
        }
    }
}

class Consumer implements Runnable {
    private SharedObject shared;

    public Consumer(SharedObject shared) {
        this.shared = shared;
    }

    @Override
    public void run() {
        while(true) {
            String value = shared.getValue();
            System.out.println(value);
        }
    }
}