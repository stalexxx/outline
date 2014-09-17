package com.aostrovskiy.client;

/**
 * Created by alex on 15.09.14.
 */
public class Point<T extends Number & Comparable<T>> {
    private T x;
    private T y;

    public Point(T x, T y) {
        this.x = x;
        this.y = y;
    }


    public T getY() {
        return y;
    }

    public T getX() {
        return x;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        if (y != point.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x.intValue();
        result = 31 * result + y.intValue();
        return result;
    }

    @Override
    public String toString() {
        return "{" + x + "," + y + '}';
    }
}
