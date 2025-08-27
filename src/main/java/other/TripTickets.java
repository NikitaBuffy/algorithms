package other;

import java.util.*;

public class TripTickets {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(List.of("A", "B"));
        list.add(List.of("B", "C"));
        list.add(List.of("D", "E"));
        list.add(List.of("C", "D"));
        System.out.println(route(list));
    }

    public static List<String> route(List<List<String>> tickets) {
        Set<String> dest = new HashSet<>();
        Map<String, String> mapping = new HashMap<>();

        for (List<String> routes : tickets) {
            dest.add(routes.get(1));
            mapping.put(routes.get(0), routes.get(1));
        }

        String start = "";
        for (List<String> routes : tickets) {
            if (!dest.contains(routes.get(0))) {
                start = routes.get(0);
                break;
            }
        }

        List<String> result = new ArrayList<>();
        result.add(start);

        while (mapping.containsKey(start)) {
            String next = mapping.get(start);
            result.add(next);
            start = next;
        }

        return result;
    }
}
