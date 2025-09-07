package other;

import java.util.List;
import java.util.ArrayList;

public class MeetingRooms {
    public static void main(String[] args) {
        System.out.println(countMeetingRooms(List.of(List.of(2,5), List.of(0,6), List.of(0,3), List.of(9,11), List.of(5,8)))); // 3
    }

    public static int countMeetingRooms(List<List<Integer>> intervals) {
        List<List<Integer>> points = new ArrayList<>();

        for (List<Integer> interval : intervals) {
            points.add(List.of(interval.get(0), +1));
            points.add(List.of(interval.get(1), -1));
        }

        points.sort((a, b) -> a.get(0).equals(b.get(0)) ? a.get(1).compareTo(b.get(1)) : a.get(0).compareTo(b.get(0)));

        int maxRooms = 0;
        int currRooms = 0;
        for (List<Integer> point : points) {
            currRooms += point.get(1);
            maxRooms = Math.max(maxRooms, currRooms);
        }

        return maxRooms;
    }
}
