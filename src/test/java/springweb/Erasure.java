package springweb;

public class Erasure<T extends String> {

    T object;

    public Erasure(T t) {
        this.object = t;
    }

    public void add(T object) {
        System.out.println(object.toString());
    }
}
