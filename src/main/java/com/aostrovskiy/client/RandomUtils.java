package com.aostrovskiy.client;

import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.canvas.dom.client.FillStrokeStyle;
import com.google.gwt.user.client.Random;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 15.09.14.
 */
public class RandomUtils {
    static final CssColor[] colors;
    static int nextColorIndex = 0;

    static {
        List<CssColor> list = new ArrayList<>();
        list.add(CssColor.make("blue"));
        list.add(CssColor.make("green"));
        list.add(CssColor.make("black"));
        list.add(CssColor.make("pink"));
        list.add(CssColor.make("brown"));
        list.add(CssColor.make("yellow"));
        colors = list.toArray(new CssColor[list.size()]);
    }
    public static FillStrokeStyle randColor() {
        return colors[nextColorIndex++ % colors.length];
    }

    public static IntegerRect createRandomRect() {
        int left = nextInt(0, 14);
        int right = nextInt(left + 1, 17);
        int height = nextInt(0, 9);
        return new IntegerRect(
                left, right, height
        );
    }
    public static FloatRect createRandomFloatRect() {
        float left = nextFloat(0, 14);
        float right = nextFloat(left + 1, 16);
        float height = nextFloat(0, 9);
        return new FloatRect(
                left, right, height
        );
    }

    private static int nextInt(int startIncl, int endExcl) {
        return startIncl + Random.nextInt(endExcl - startIncl);
    }


    private static float nextFloat(float startIncl, float endExcl) {
        return (float) (startIncl + Random.nextDouble() * (endExcl - startIncl));
    }
}
