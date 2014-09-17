package com.aostrovskiy.client;

import java.util.List;

/**
 * Created by alex on 17.09.14.
 */
public class FloatOutlineBuilder extends AbstractOutlineBuilder<Float> {
    public FloatOutlineBuilder(List<Rect<Float>> rects) {
        super(rects);
    }

    @Override
    protected Float minHeight() {
        return 0f;
    }

    @Override
    protected boolean greater(Float a, Float b) {
        return a > b;
    }


}
