package ru.interview.springnature.drawingapp.drawing;

import ru.interview.springnature.drawingapp.exceptions.IllegalParametersException;
import ru.interview.springnature.drawingapp.models.Canvas;
import ru.interview.springnature.drawingapp.models.Line;

/**
 * Created by Eraskin Alexei on 03.09.2016.
 */
public abstract class CanvasPainter {

    protected Canvas canvas;

    public static final int BLANK_POINT = 0;
    public static final int X_POINT = 1;

    public abstract void showCanvas() throws IllegalParametersException;
    public abstract void drawLine(Line line) throws IllegalParametersException;

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
}
