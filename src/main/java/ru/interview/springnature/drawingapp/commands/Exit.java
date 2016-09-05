package ru.interview.springnature.drawingapp.commands;

import ru.interview.springnature.drawingapp.drawing.CanvasPainter;
import ru.interview.springnature.drawingapp.exceptions.IllegalParametersException;

/**
 * Created by Eraskin Alexei on 03.09.2016.
 */
public class Exit implements Command {

    @Override
    public void execute(CanvasPainter painter) {
        // remove canvas and resources
    }

    @Override
    public void validateParameters() throws IllegalParametersException {
    }

    @Override
    public String getName() {
        return EXIT;
    }

}
