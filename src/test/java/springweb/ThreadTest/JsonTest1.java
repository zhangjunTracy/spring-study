package springweb.ThreadTest;

public class JsonTest1 {

    public static void main(String[] args) {
        Object obj = new Object();
        try {
            obj.wait();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        obj.notifyAll();
    }

}
