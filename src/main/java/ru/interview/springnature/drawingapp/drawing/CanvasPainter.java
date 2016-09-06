package ru.interview.springnature.drawingapp.drawing;

import ru.interview.springnature.drawingapp.exceptions.IllegalParametersException;
import ru.interview.springnature.drawingapp.models.Canvas;
import ru.interview.springnature.drawingapp.models.Line;
import ru.interview.springnature.drawingapp.models.Point;
import ru.interview.springnature.drawingapp.models.Rectangle;

/**
 * Created by Eraskin Alexei on 03.09.2016.
 */
public abstract class CanvasPainter {

    protected Canvas canvas;

    public static final char BLANK_POINT = ' ';
    public static final char X_POINT = 'x';

    public abstract void showCanvas() throws IllegalParametersException;
    public abstract void drawLine(Line line) throws IllegalParametersException;
    public abstract void drawRectangle(Rectangle rectangle) throws IllegalParametersException;
    public abstract void bucketFill(Point point, char colorCode) throws IllegalParametersException;

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
}
