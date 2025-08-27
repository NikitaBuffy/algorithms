package other;

import java.util.*;

public class LineReflection {
    public static void main(String[] args) {
        List<List<Integer>> list1 = new ArrayList<>();
        list1.add(List.of(1, 2));
        list1.add(List.of(3, 1));

        List<List<Integer>> list2 = new ArrayList<>();
        list2.add(List.of(1, 2));
        list2.add(List.of(3, 1));
        list2.add(List.of(4, 2));
        list2.add(List.of(2, 1));
        list2.add(List.of(2, 1));
        System.out.println(isSymmetric(list1));
        System.out.println(isSymmetric(list2));
    }

    static boolean isSymmetric(List<List<Integer>> points) {
        int minX = points.get(0).get(0);
        int maxX = points.get(0).get(0);

        for (List<Integer> point : points) {
            minX = Math.min(minX, point.get(0));
            maxX = Math.max(maxX, point.get(0));
        }

        Set<Point> pointSet = new HashSet<>();
        for (List<Integer> point : points) {
            pointSet.add(new Point(point.get(0), point.get(1)));
        }

        for (List<Integer> point : points) {
            int symX = maxX + minX - point.get(0);
            if (!pointSet.contains(new Point(symX, point.get(1)))) {
                return false;
            }
        }

        return true;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
