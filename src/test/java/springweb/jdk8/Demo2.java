package springweb.jdk8;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {

    public static void main(String[] args) {

        List<MapD> list = new ArrayList<MapD>();
        MapD mapD1 = new MapD();
        mapD1.setKey("a");
        mapD1.setValue1(2);
        mapD1.setValue2(3);
        list.add(mapD1);
        MapD mapD2 = new MapD();
        mapD2.setKey("b");
        mapD2.setValue1(1);
        mapD2.setValue2(1);
        list.add(mapD2);
        MapD mapD3 = new MapD();
        mapD3.setKey("a");
        mapD3.setValue1(1);
        mapD3.setValue2(1);
        list.add(mapD3);
        MapD mapD4 = new MapD();
        mapD4.setKey("b");
        mapD4.setValue1(1);
        mapD4.setValue2(1);
        list.add(mapD4);

    }

}

class MapD {
    private String key;

    private Integer value1;

    private Integer value2;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getValue1() {
        return value1;
    }

    public void setValue1(Integer value1) {
        this.value1 = value1;
    }

    public Integer getValue2() {
        return value2;
    }

    public void setValue2(Integer value2) {
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "MapD [key=" + key + ", value1=" + value1 + ", value2=" + value2 + "]";
    }

}
