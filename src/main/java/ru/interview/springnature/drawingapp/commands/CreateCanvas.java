package ru.interview.springnature.drawingapp.commands;

import ru.interview.springnature.drawingapp.drawing.CanvasPainter;
import ru.interview.springnature.drawingapp.exceptions.IllegalParametersException;
import ru.interview.springnature.drawingapp.exceptions.UnknownCommandException;
import ru.interview.springnature.drawingapp.models.Canvas;
import ru.interview.springnature.drawingapp.models.Point;

import static ru.interview.springnature.drawingapp.models.Canvas.MAX_LENGTH;
import static ru.interview.springnature.drawingapp.models.Canvas.MIN_LENGTH;

/**
 * Created by Eraskin Alexei on 03.09.2016.
 */
public class CreateCanvas implements Command {

    private Point size;
    private Canvas canvas;

    public CreateCanvas(Point size) {
        this.size = size;
    }

    @Override
    public void validateParameters() throws IllegalParametersException {
        if(size.getX() < MIN_LENGTH || size.getX() > MAX_LENGTH) {
            throw new IllegalParametersException();
        }

        if(size.getY() < MIN_LENGTH || size.getY() > MAX_LENGTH) {
            throw new IllegalParametersException();
        }
    }

    @Override
    public void execute(CanvasPainter painter) throws IllegalParametersException, UnknownCommandException {
        validateParameters();

        canvas = new Canvas(size);
        painter.setCanvas(canvas);
        painter.showCanvas();
    }

    @Override
    public String getName() {
        return CREATE_CANVAS;
    }
}
