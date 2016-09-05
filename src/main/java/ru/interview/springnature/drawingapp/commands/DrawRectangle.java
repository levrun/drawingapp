package ru.interview.springnature.drawingapp.commands;

import ru.interview.springnature.drawingapp.drawing.CanvasPainter;
import ru.interview.springnature.drawingapp.exceptions.IllegalParametersException;
import ru.interview.springnature.drawingapp.exceptions.NoCanvasCreated;
import ru.interview.springnature.drawingapp.models.Canvas;
import ru.interview.springnature.drawingapp.models.Rectangle;

/**
 * Created by Eraskin Alexei on 03.09.2016.
 */
public class DrawRectangle implements Command {

    private Rectangle rectangle;
    private Canvas canvas;

    public DrawRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public void execute(CanvasPainter painter) throws IllegalParametersException, NoCanvasCreated {
        canvas = painter.getCanvas();
        validateParameters();

        painter.drawRectangle(rectangle);
        painter.showCanvas();
    }

    @Override
    public void validateParameters() throws IllegalParametersException, NoCanvasCreated {
        if(canvas == null) {
            throw new NoCanvasCreated();
        }

        int rectangleWidth = rectangle.getEnd().getX() - rectangle.getStart().getX();
        int rectangleHeight = rectangle.getEnd().getY() - rectangle.getStart().getY();

        if(rectangleWidth < 1 || rectangleHeight < 1) {
            throw new IllegalParametersException();
        }

        int canvasWidth = canvas.getSize().getX();
        if(rectangle.getStart().getX() < 1 || rectangle.getEnd().getX() > canvasWidth) {
            throw new IllegalParametersException();
        }

        int canvasHeight = canvas.getSize().getY();
        if(rectangle.getStart().getY() < 1 || rectangle.getEnd().getY() > canvasHeight) {
            throw new IllegalParametersException();
        }

    }

    @Override
    public String getName() {
        return DRAW_RECTANGLE;
    }

}
