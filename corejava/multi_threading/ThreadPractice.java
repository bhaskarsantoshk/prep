package corejava.multi_threading;

public class ThreadPractice {
    public static void main(String[] args){
        Multi t1 = new Multi(); // new born state ( 1 )
        t1.start(); //runnable state ( 2 )
        PrintNumbers thread = new PrintNumbers();
        thread.start();
    }
}

class Multi extends Thread{
    @Override
    public void run(){
        // Running state ( 3 )
        System.out.print("Thread is running");
    }
}

class PrintNumbers extends Thread{
    @Override
    public void run() {
        for ( int i=0; i<10; i++){
            if ( i == 5){
                stop();
            }
            System.out.print(i);
        }
    }
}
