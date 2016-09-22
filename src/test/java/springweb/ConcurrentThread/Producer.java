package springweb.ConcurrentThread;

public class Producer implements Runnable {

    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            store.set();

        }

    }

}
