package com.aostrovskiy.client;

/**
 * Created by alex on 16.09.14.
 */
public class FloatRect extends Rect<Float> {
    public FloatRect(Float left, Float right, Float height) {
        super(left, right, height);
    }

    @Override
    public Float getWidth() {
        return getRight() - getLeft();
    }
}
