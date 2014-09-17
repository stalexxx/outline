package com.aostrovskiy.client;

/**
 * Created by alex on 15.09.14.
 */
public class Side<T extends Number & Comparable<T>> {

    private boolean left;

    private Rect<T> rect;

    public Side(Rect<T> rect, boolean left) {
        this.rect = rect;
        this.left = left;
    }

    public Boolean isLeft() {
        return left;
    }
    public Boolean isRight() {
        return !left;
    }

    public Rect<T> getRect() {
        return rect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Side)) return false;

        Side side = (Side) o;

        if (left != side.left) return false;
        if (rect != null ? !rect.equals(side.rect) : side.rect != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (left ? 1 : 0);
        result = 31 * result + (rect != null ? rect.hashCode() : 0);
        return result;
    }

    public T getX() {
        return left ? rect.getLeft() : rect.getRight();
    }


    @Override
    public String toString() {
        return (left ? "left" : "right") +
                " " + rect + "/x=" + getX()
                ;
    }

    public T getHeight() {
        return rect.getHeight();
    }
}
