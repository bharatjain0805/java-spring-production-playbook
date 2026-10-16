package collections;

import java.util.Iterator;
import java.util.List;

public class SafeRemoval {
    public static void removeUnder100(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() < 100) {
                it.remove(); // Updates expectedModCount internally
            }
        }
    }
}
