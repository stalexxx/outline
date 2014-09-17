package com.aostrovskiy.client;

import java.util.*;

/**
 * Main algo class for counting outline for int rects
 * Created by alex on 15.09.14.
 */
public abstract class AbstractOutlineBuilder<T extends Number & Comparable<T>> {

    private final List<Rect<T>> rects;

    private final Comparator<Side<T>> X_COMPARATOR = new Comparator<Side<T>>() {
        @Override
        public int compare(Side<T> o1, Side<T> o2) {

            int compareX = o1.getX().compareTo(o2.getX());

            if (compareX != 0) {
                return compareX;
            }

            int isLeftCompare = o1.isRight().compareTo(o2.isRight());
            if (isLeftCompare != 0) {
                return isLeftCompare;
            }

            int heightCompare = (o1.isLeft() ) ? o2.getHeight().compareTo(o1.getHeight()) :
                    o1.getHeight().compareTo(o2.getHeight());
            if (heightCompare != 0) {
                return heightCompare;
            }

            int rightCompare = o1.getRect().getRight().compareTo(o2.getRect().getRight());
            if (rightCompare != 0) {
                return rightCompare;
            } else {
                return 0;
            }

        }
    };

    public AbstractOutlineBuilder(List<Rect<T>> rects) {
        this.rects = rects;
    }

    public List<Point<T>> build() {
        Collection<Side<T>> sides = collectSides(rects);

        List<Point<T>> points = new ArrayList<>();

        TreeSet<Rect<T>> set = new TreeSet<>();

        T maxY;

        for (Side<T> side : sides) {

            if (side.isLeft()) {
                maxY = heighest(set);

                set.add(side.getRect());

                T heighest = heighest(set);
                if (greater(heighest,  maxY)) {
                    points.add(new Point<>(side.getX(), maxY));
                    points.add(new Point<>(side.getX(), heighest));
                }


            } else {
                maxY = heighest(set);

                set.remove(side.getRect());

                T heighest = heighest(set);
                if (greater(maxY, heighest)) {
                    points.add(new Point<>(side.getX(), maxY));
                    points.add(new Point<>(side.getX(), heighest));
                }

            }
        }

        return points;
    }


    private T heighest(TreeSet<Rect<T>> set) {
        if (set.isEmpty()) {
            return minHeight();
        } else {
            return set.last().getHeight();
        }
    }


    private Collection<Side<T>> collectSides(List<Rect<T>> rects) {
        List<Side<T>> result = new ArrayList<>();

        for (Rect<T> rect : rects) {
            Side<T> left = rect.leftSide();
            Side<T> right = rect.rightSide();
            result.add(left);
            result.add(right);
        }


        Collections.sort(result, X_COMPARATOR);

        return result;
    }

    protected abstract T minHeight() ;

    protected abstract boolean greater(T a, T b);


}
