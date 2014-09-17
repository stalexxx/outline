package com.aostrovskiy.client;

import java.util.Objects;

/**
 * Created by alex on 15.09.14.
 */
public abstract class Rect<T extends Number & Comparable<T>> implements Comparable<Rect<T>> {
    private T left;
    private T right;
    private T height;

    public Rect(T left, T right, T height) {

        this.left = left;
        this.right = right;
        this.height = height;
    }

    @Override
    public String toString() {
        return "[" +
                "" + left +
                ", " + right +
                ", " + height +
                ']';
    }

    public T getLeft() {
        return left;
    }

    public T getRight() {
        return right;
    }

    public T getHeight() {
        return height;
    }

    public abstract T getWidth(); /*{
        return right - left;
    }*/


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rect)) return false;

        Rect rect = (Rect) o;

        if (height != rect.height) return false;
        if (left != rect.left) return false;
        if (right != rect.right) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = left.intValue();
        result = 31 * result + right.intValue();
        result = 31 * result + height.intValue();
        return result;
    }

    public Side<T> leftSide() {
        return new Side<>(this, true);
    }

    public Side<T> rightSide() {
        return new Side<>(this, false);
    }




    @Override
    public int compareTo(Rect o) {
        int heightCompare = getHeight().compareTo((T) o.getHeight());
        if (heightCompare != 0) {
            return heightCompare;
        }

        int lc = getLeft().compareTo((T) o.getLeft());
        if (lc != 0) {
            return lc;
        }

        int rc = getRight().compareTo((T) o.getRight());
        if (rc != 0) {
            return rc;
        }

        return 0;
    }
}
