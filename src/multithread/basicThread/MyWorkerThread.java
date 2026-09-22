package multithread.basicThread;

public class MyWorkerThread extends Thread{

    MyWorkerThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(getName() + " is processing item " + i);

            try{
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(getName() + " was interrupted.");
            }
        }
    }
}
