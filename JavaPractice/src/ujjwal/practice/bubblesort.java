package ujjwal.practice;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class bubblesort {

    @Test
    public void test() {
        assertNotNull("Ujjwal Singh");
    }

    public static class NotComparable {
        private int i;

        private NotComparable(int i) {
            this.i = i;
        }
    }

    @Test
    public void sortNotComparable() {

        final List<NotComparable> objects = new ArrayList<NotComparable>();

        for (int i = 0; i < 10; i++) {
            objects.add(new NotComparable(i));
        }
        Arrays.sort(objects.toArray());
        fail();
    }

}
