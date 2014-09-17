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
        colors = new CssColor[6];
        List<CssColor> list = new ArrayList<>();
        colors[0]=(CssColor.make("blue"));
        colors[1]=(CssColor.make("green"));
        colors[2]=(CssColor.make("black"));
        colors[3]=(CssColor.make("pink"));
        colors[4]=(CssColor.make("brown"));
        colors[5]=(CssColor.make("yellow"));
        //colors = list.toArray(new CssColor[list.size()]);
    }
    public static FillStrokeStyle randColor() {
        return colors[nextColorIndex++ % colors.length];
//        return CssColor.make("blue");
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
