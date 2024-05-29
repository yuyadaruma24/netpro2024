package thread;

public class CountAZTenRunnable implements Runnable {
    String myAlfabetStr;

    public static void main(String[] args){
        CountTenRunnable [] ctr = new CountTenRunnable[26];


        for(int i = 0;i<ctr.length;i++){
            ctr[i] = new CountTenRunnable();
            String name = (char)(97+i) + "_chan thread";
            ctr[i].setAlfabet(name);
        }

        for(CountTenRunnable ct : ctr){
            new Thread(ct).start();
        }
    

        try {
            for(int i = 0; i < 10; i++) {
                System.out.println("main:i=" + i);

                Thread.sleep(500);
            }
        }
        catch(InterruptedException e) {
            System.err.println(e);
        }
    }

    public void setAlfabet(String alfabetstr) {
        myAlfabetStr=alfabetstr;
    }

    public void run() {
        try {
            for(int i = 0; i < 10; i++) {
                System.out.println(myAlfabetStr + "runnable thread:i=" + i);

                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e) {
            System.err.println(e);
        }
    }
}