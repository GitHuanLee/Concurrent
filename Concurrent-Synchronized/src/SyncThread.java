public class SyncThread {

    public synchronized void runmethod1(){
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(4000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public synchronized void runmethod2(){

        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                syncThread.runmethod1();
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncThread.runmethod2();
            }
        });
        thread.start();
        thread1.start();


    }

}
