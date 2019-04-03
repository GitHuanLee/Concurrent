public class MultiThread {
    //private static int count = 0;
    private int count = 0;

//    private static synchronized void run(String args){
//        if("a".equals(args)){
//            count = 200;
//            System.out.println("tag a set num over!");
//        }else{
//            count = 100;
//            System.out.println("tag b set num over!");
//        }
//
//        System.out.println("tag = "+args+" count = "+count);
//    }

    private synchronized void run(String args){
        if("a".equals(args)){
            count = 200;
            System.out.println("tag a set num over!");
        }else{
            count = 100;
            System.out.println("tag b set num over!");
        }

        System.out.println("tag = "+args+" count = "+count);
    }


    public static void main(String[] args) {
        MultiThread multiThread1 = new MultiThread();
        MultiThread multiThread2 = new MultiThread();


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                multiThread1.run("a");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                multiThread2.run("b");
            }
        });

        thread.start();
        thread2.start();

    }


}
