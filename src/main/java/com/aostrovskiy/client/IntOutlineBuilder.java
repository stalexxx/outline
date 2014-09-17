package com.aostrovskiy.client;

import java.util.List;

/**
 * Created by alex on 17.09.14.
 */
public class IntOutlineBuilder extends AbstractOutlineBuilder<Integer> {

    public IntOutlineBuilder(List<Rect<Integer>> rects) {
        super(rects);
    }

    @Override
    protected Integer minHeight() {
        return 0;
    }

    @Override
    protected boolean greater(Integer a, Integer b) {
        return a > b;
    }


}
