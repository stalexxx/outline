package com.aostrovskiy.client;

import com.google.common.base.Splitter;
import com.google.gwt.core.client.EntryPoint;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Main implements EntryPoint {
    public static final int RAND_COUNT = 10;

    static final int height = 450;
    static final int width = 800;
    static final int scale = 50;

    private MainView view;

    public void onModuleLoad() {
        view = new MainView(width, height, scale);
        view.setPresenter(this);
    }

    private List<Rect<Integer>> readFromString(String initRects) {
        Iterable<String> split = Splitter.on("] [").split(initRects);

        ArrayList<Rect<Integer>> result = new ArrayList<>();

        for (String tuple : split) {
            Iterable<String> tupleIter = Splitter.on(", ").split(tuple);
            Iterator<String> iterator = tupleIter.iterator();
            int left = Integer.parseInt(iterator.next());
            int right = Integer.parseInt(iterator.next());
            int height = Integer.parseInt(iterator.next());
            IntegerRect rect = new IntegerRect(left, right, height);
            result.add(rect);

        }
        return result;
    }

    private <T extends Number & Comparable<T>> void redrawRects(List<Rect<T>> rects) {
        view.drawRects(rects);
        view.printRects(rects);
    }

    public void generateRects() {
        List<Rect<Integer>> rects = new ArrayList<>();

        for (int i = 0; i < RAND_COUNT; i++) {

            IntegerRect randomRect = RandomUtils.createRandomRect();
            rects.add(randomRect);
        }

        redrawRects(rects);

        IntOutlineBuilder builder = new IntOutlineBuilder(rects);
        List<Point<Integer>> pointList = builder.build();

        view.showPoints(pointList);
    }

    public void generateFloatRects() {
        List<Rect<Float>> rects = new ArrayList<>();

        for (int i = 0; i < RAND_COUNT; i++) {
            rects.add(RandomUtils.createRandomFloatRect());
        }

        redrawRects(rects);

        FloatOutlineBuilder builder = new FloatOutlineBuilder(rects);

        List<Point<Float>> pointList = builder.build();

        view.showPoints(pointList);
    }

}
