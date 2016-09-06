package ru.interview.springnature.drawingapp.commands;

import ru.interview.springnature.drawingapp.drawing.CanvasPainter;
import ru.interview.springnature.drawingapp.exceptions.IllegalParametersException;
import ru.interview.springnature.drawingapp.exceptions.NoCanvasCreated;
import ru.interview.springnature.drawingapp.models.Canvas;
import ru.interview.springnature.drawingapp.models.Point;

import static ru.interview.springnature.drawingapp.drawing.CanvasPainter.BLANK_POINT;

/**
 * Created by Eraskin Alexei on 03.09.2016.
 */
public class BucketFill implements Command {

    private Point point;
    private char colorCode;
    private Canvas canvas;

    public BucketFill(Point point, char colorCode) {
        this.point = point;
        this.colorCode = colorCode;
    }

    @Override
    public void execute(CanvasPainter painter) throws IllegalParametersException, NoCanvasCreated {
        canvas = painter.getCanvas();
        validateParameters();

        painter.bucketFill(point, colorCode);
        painter.showCanvas();
    }

    @Override
    public void validateParameters() throws IllegalParametersException, NoCanvasCreated {
        if(canvas == null) {
            throw new NoCanvasCreated();
        }

        if(canvas.getArray()[point.getConvertedX()][point.getConvertedY()].getValue() != BLANK_POINT) {
            throw new IllegalParametersException("Can't fill already painted area");
        }

        if(point.getX() < 1 || point.getY() < 1) {
            throw new IllegalParametersException();
        }

        if(point.getX() > canvas.getSize().getX() || point.getY() > canvas.getSize().getY()) {
            throw new IllegalParametersException();
        }

        Point canvasPoint = canvas.getArray()[point.getX()][point.getY()];
        if(canvasPoint.getValue() != BLANK_POINT) {
            throw new IllegalParametersException();
        }

    }

    @Override
    public String getName() {
        return BUCKET_FILL;
    }

}
