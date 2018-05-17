package springweb.test;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {

    public static void main(String[] args) {

        List<String> c = new ArrayList<String>();
        c.add("3");

        List<String> ele = new ArrayList<String>();
        ele.add("1");
        ele.add("3");
        Integer size = 2;
        final Object[] elementData = ele.toArray();
        int r = 0, w = 0;
        boolean modified = false;
        try {
            for (; r < size; r++)
                if (c.contains(elementData[r]) == true) elementData[w++] = elementData[r];
        } finally {
            // Preserve behavioral compatibility with AbstractCollection,
            // even if c.contains() throws.
            if (r != size) {
                System.arraycopy(elementData, r, elementData, w, size - r);
                w += size - r;
            }
            if (w != size) {
                // clear to let GC do its work
                for (int i = w; i < size; i++)
                    elementData[i] = null;
                size = w;
                modified = true;
            }
        }
    }

}
