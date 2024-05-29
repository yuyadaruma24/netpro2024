package thread;

public class ExThreadsMain extends Thread{
    private static final Object object1 = new Object();
    private static final Object object2 = new Object();
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized(object1){
                run1();
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized(object2){
                run2();
            }
        });

        thread1.start();
        thread2.start();
    }

    public static void run1(){
        for(int i = 0;i <= 10; i++){
            try {
                Thread.sleep(1000);
                System.out.println("スレッド1：thread課題");
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }

    public static void run2(){
        int num = 0;
        for(int i = 0; i <= 10;i++){
            num++;
            try {
                Thread.sleep(1000);
                System.out.println("スレッド2：合計は" + num);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }
}
