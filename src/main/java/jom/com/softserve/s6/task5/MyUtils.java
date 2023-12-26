package jom.com.softserve.s6.task5;

import java.util.Map;
import java.util.stream.Stream;

public class MyUtils {

    public static Stream<String> nameList(Map<String, Stream<String>> map) {
        if (map == null) {
            throw new NullPointerException("Map cannot be null");
        }

        return map.values().stream()
                .filter(s -> s != null)
                .flatMap(s -> s.map(participant -> participant != null ? participant.trim() : "")
                        .filter(name -> !name.isEmpty())
                        .map(name -> name.replaceAll("\\s+", ""))
                        .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase()))
                .distinct()
                .sorted();
    }
}
