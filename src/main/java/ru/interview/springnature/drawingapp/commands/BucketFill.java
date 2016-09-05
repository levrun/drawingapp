package ru.interview.springnature.drawingapp.commands;

import ru.interview.springnature.drawingapp.drawing.CanvasPainter;
import ru.interview.springnature.drawingapp.exceptions.IllegalParametersException;

/**
 * Created by Eraskin Alexei on 03.09.2016.
 */
public class BucketFill implements Command {

    @Override
    public void execute(CanvasPainter painter) throws IllegalParametersException {
        validateParameters();

        // TODO
    }

    @Override
    public void validateParameters() throws IllegalParametersException {
        // TODO
    }

    @Override
    public String getName() {
        return null;
    }

}
