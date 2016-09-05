package ru.interview.springnature.drawingapp.commands;

import ru.interview.springnature.drawingapp.drawing.CanvasPainter;
import ru.interview.springnature.drawingapp.exceptions.IllegalParametersException;
import ru.interview.springnature.drawingapp.exceptions.NoCanvasCreated;
import ru.interview.springnature.drawingapp.models.Canvas;
import ru.interview.springnature.drawingapp.models.Line;

/**
 * Created by Eraskin Alexei on 03.09.2016.
 */
public class DrawLine implements Command {

    private Line line;
    private Canvas canvas;

    public DrawLine(Line line) {
        this.line = line;
    }

    @Override
    public void execute(CanvasPainter painter) throws IllegalParametersException, NoCanvasCreated {
        canvas = painter.getCanvas();
        validateParameters();

        painter.drawLine(line);
        painter.showCanvas();
    }

    @Override
    public void validateParameters() throws IllegalParametersException, NoCanvasCreated {
        if(canvas == null) {
            throw new NoCanvasCreated();
        }

        int canvasWidth = canvas.getSize().getX();
        if(line.getStart().getX() < 1 || line.getEnd().getX() > canvasWidth) {
            throw new IllegalParametersException();
        }

        if(line.isHorizontal() && canvasWidth < line.getLength()) {
            throw new IllegalParametersException();
        }

        int canvasHeight = canvas.getSize().getY();
        if(line.getStart().getY() < 1 || line.getEnd().getY() > canvasHeight) {
            throw new IllegalParametersException();
        }

        if(line.isVertical() && canvasHeight < line.getLength()) {
            throw new IllegalParametersException();
        }

    }

    @Override
    public String getName() {
        return DRAW_LINE;
    }

}
