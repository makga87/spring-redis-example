package map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MapApiTest {

    @DisplayName("각 맵별로, 정렬이 어떻게 되는지 확인해본다.")
    @Test
    void mapSortedTest() {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 1);
        hashMap.put(3, 3);
        hashMap.put(4, 4);
        hashMap.put(2, 2);

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 1);
        treeMap.put(3, 3);
        treeMap.put(4, 4);
        treeMap.put(2, 2);

        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, 1);
        linkedHashMap.put(3, 3);
        linkedHashMap.put(4, 4);
        linkedHashMap.put(2, 2);

        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        hashtable.put(1, 1);
        hashtable.put(3, 3);
        hashtable.put(4, 4);
        hashtable.put(2, 2);

        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1, 1);
        concurrentHashMap.put(3, 3);
        concurrentHashMap.put(4, 4);
        concurrentHashMap.put(2, 2);

        hashMap.entrySet()
                .stream()
                .peek(map -> System.out.println("hashMap : " + map.getKey()))
                .collect(Collectors.toList());

        System.out.println("----------------------------");

        treeMap.entrySet()
                .stream()
                .peek(map -> System.out.println("treeMap : " + map.getKey()))
                .collect(Collectors.toList());

        System.out.println("----------------------------");

        linkedHashMap.entrySet()
                .stream()
                .peek(map -> System.out.println("linkedHashMap : " + map.getKey()))
                .collect(Collectors.toList());

        System.out.println("----------------------------");

        hashtable.entrySet()
                .stream()
                .peek(map -> System.out.println("hashtable : " + map.getKey()))
                .collect(Collectors.toList());

        System.out.println("----------------------------");

        concurrentHashMap.entrySet()
                .stream()
                .peek(map -> System.out.println("concurrentHashMap : " + map.getKey()))
                .collect(Collectors.toList());
    }
}