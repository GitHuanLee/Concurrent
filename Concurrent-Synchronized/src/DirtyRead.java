public class DirtyRead {

    private String username = "l4";
    private String password = "789";

    public synchronized void setValue(String username,String password){
        this.username = username;
        try {

            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

        this.password = password;

        System.out.println("设值成功 username="+username+" password="+password);
    }

    public synchronized void getValue(){

        System.out.println("取值成功 username="+username+" password="+password);
    }

    public static void main(String[] args)throws Exception {
        DirtyRead dirtyRead = new DirtyRead();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                dirtyRead.setValue("z3","456");
            }
        });
        thread.start();
        Thread.sleep(1000);
        dirtyRead.getValue();


    }

}
