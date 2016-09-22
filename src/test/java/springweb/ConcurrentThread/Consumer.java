package springweb.ConcurrentThread;

public class Consumer implements Runnable {

    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            store.get();
        }

    }

}
