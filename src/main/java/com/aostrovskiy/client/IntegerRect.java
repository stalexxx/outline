package com.aostrovskiy.client;

/**
 * Created by alex on 16.09.14.
 */
public class IntegerRect extends Rect<Integer> {
    public IntegerRect(Integer left, Integer right, Integer height) {
        super(left, right, height);
    }

    @Override
    public Integer getWidth() {
        return getRight() - getLeft();
    }
}
