package stream;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Collector {

    public static void main(String[] args){

        ArrayList<String> collect = new ArrayList<>();
        collect.stream()
                .collect(Collectors.toList());


    }
}
