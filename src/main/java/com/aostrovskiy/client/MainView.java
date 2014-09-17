package com.aostrovskiy.client;

import com.google.common.base.Joiner;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

import java.util.List;

/**
 * Created by alex on 15.09.14.
 */
public class MainView {
    static final String canvasHolderId = "canvasholder";
    static final String buttonsHolderId = "buttons";
    static final String rectsHolderId = "rects";

    static final String unsupportedBrowser = "Your browser does not support the HTML5 Canvas";

    private HTML pointsContainer;
    private HTML rectContainer;

    private Canvas canvas;
    private int width;
    private int height;
    private int scale;
    private Main presenter;

    public MainView(int width, int height, int scale) {
        this.width = width;
        this.height = height;
        this.scale = scale;
        canvas = Canvas.createIfSupported();
        if (canvas == null) {
            RootPanel.get(canvasHolderId).add(new Label(unsupportedBrowser));
            return;
        }
        createCanvas();
        createButtons();
        createRectsContainer();
    }

    private void createCanvas(){

        canvas.setWidth(width + "px");
        canvas.setHeight(height + "px");
        canvas.setCoordinateSpaceWidth(width);
        canvas.setCoordinateSpaceHeight(height);

        RootPanel.get(canvasHolderId).add(canvas);

    }


    private void createRectsContainer() {
        rectContainer = new HTML();
        pointsContainer = new HTML();
        RootPanel.get(rectsHolderId).add(pointsContainer);
        RootPanel.get(rectsHolderId).add(rectContainer);

    }


    private void createButtons() {
        RootPanel buttonsPane = RootPanel.get(buttonsHolderId);
        buttonsPane.add(new Button("Целочисленный рандом", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                getPresenter().generateRects();
            }
        }));
        buttonsPane.add(new Button("рандом с плавающей точкой", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                getPresenter().generateFloatRects();

            }
        }));

    }

    public void setPresenter(Main presenter) {
        this.presenter = presenter;
    }

    public Main getPresenter() {
        return presenter;
    }

    public <T extends Number & Comparable<T>> void drawRects(List<Rect<T>> rects) {
        Context2d context = canvas.getContext2d();


        context.beginPath();
        context.clearRect(0, 0, width, height);
        context.strokeRect(0, 0, width - 1, height - 1);
        for (Rect rect : rects) {
            context.setFillStyle(RandomUtils.randColor());
            context.fillRect(rect.getLeft().doubleValue() * scale,
                    height - rect.getHeight().doubleValue() * scale,
                    rect.getWidth().doubleValue() * scale,
                    height);

        }

        context.closePath();
    }

    public <T extends Number & Comparable<T>> void printRects(List<Rect<T>> rects) {
        String join = Joiner.on(" ").join(rects);
        pointsContainer.setHTML(join);

    }


    public <T extends Number & Comparable<T>> void showPoints(List<Point<T>> pointList) {
        Context2d context = canvas.getContext2d();
        context.beginPath();


        for (Point point : pointList) {
            context.setFillStyle(CssColor.make("red"));
            context.fillRect(point.getX().doubleValue() * scale - 5,
                    height - point.getY().doubleValue() * scale - 5, 10 , 10);
        }

        context.closePath();

        String join = Joiner.on(" ").join(pointList);
        rectContainer.setHTML(join);

    }
}
