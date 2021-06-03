package list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListApiTest {

    @Test
    void REMOVE_IF() {
        List<Integer> list = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        list.removeIf(n -> 5 <= n);

        System.out.println(list.toString());
    }
}
