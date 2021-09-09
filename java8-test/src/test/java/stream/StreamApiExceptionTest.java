package stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class StreamApiExceptionTest {

    @Test
    void For문안에서_Exception_발생시_캐치를_확인한다() {
        List<String> data = Arrays.asList("1", "2", "3", "4", "5");
        for (String s : data) {
            System.out.println(s);
            if ("3".equals(s)) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    void Stream안에서_Exception_발생시_캐치를_확인한다() {

        List<String> data = Arrays.asList("1", "2", "3", "4", "5");

        data.forEach(value -> {
            System.out.println(value);
            if ("3".equals(value)) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}