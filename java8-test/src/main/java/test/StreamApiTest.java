package test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CollectorsTest {

    @Test
    public void 문자열_인트형으로_변환() {

        List<String> stringList = Arrays.asList("1", "2", "3", "4", "5");

        List<Integer> integerList = stringList.stream()
                .map(data -> {
                    return Integer.parseInt(data);
                })
                .peek(data -> System.out.println(data.getClass().getName() + " : " + data))
                .collect(Collectors.toList());

    }

    @Test
    public void 리스트_필터링() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        integerList.stream()
                .peek(data -> System.out.println("인입된 데이터 : " + data))
                .filter(data -> data % 2 == 0)
                .peek(data -> System.out.println("출력된 데이터 : " + data))
                .collect(Collectors.toList());
    }

    @Test
    public void 리스트_DISTINCT() {

        List<String> stringList = Arrays.asList("A", "a", "B", "B", "C", "C", "c");

        System.out.println("== DISTINCT ==");

        stringList.stream()
                .distinct()
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("== TO_UPPERCASE DISTINCT ==");

        stringList.stream()
                .map(data -> data.toUpperCase())
                .distinct()
                .peek(System.out::println)
                .collect(Collectors.toList());

    }
}